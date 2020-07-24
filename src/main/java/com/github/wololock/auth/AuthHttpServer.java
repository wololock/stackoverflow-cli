package com.github.wololock.auth;

import com.sun.net.httpserver.HttpServer;
import picocli.CommandLine;
import picocli.CommandLine.Help.Ansi;

import javax.inject.Inject;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

final class AuthHttpServer {

    final ServerConfiguration config;
    final StackOverflowAuthClient authClient;

    @Inject
    public AuthHttpServer(ServerConfiguration config, StackOverflowAuthClient authClient) {
        this.config = config;
        this.authClient = authClient;
    }

    void start() {
        try {
            var latch = new CountDownLatch(1);
            var server = HttpServer.create(new InetSocketAddress(config.getHost(), config.getPort()), 0);
            server.createContext(config.getContext(), exchange -> {
                var code = exchange.getRequestURI().toString().split("=")[1];
                System.out.println("Code retrieved. Exchanging for an access token...");

                var accessToken = authClient.accessToken(code);
                System.out.println("Access token retrieved!");

                Credentials.store(accessToken.token);

                var response = "Success! Authentication completed. You can close web browser and return to the terminal window.";

                exchange.sendResponseHeaders(200, response.length());
                exchange.getResponseBody().write(response.getBytes(StandardCharsets.UTF_8));

                latch.countDown();
            });
            server.start();
            System.out.println("Waiting for redirect URI...");
            latch.await(config.getTimeout(), TimeUnit.SECONDS);
            server.stop(0);

            System.out.println(Ansi.ON.string("@|bold,fg(green) Success! You are now authenticated!|@"));

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
