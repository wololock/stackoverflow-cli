package com.github.wololock;

import com.github.wololock.auth.AuthCommand;
import com.github.wololock.auth.Credentials;
import com.github.wololock.me.MeCommand;
import com.github.wololock.search.SearchCommand;
import io.micronaut.configuration.picocli.PicocliRunner;
import io.micronaut.context.ApplicationContext;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@Command(name = "stackoverflow-cli", description = "...",
        mixinStandardHelpOptions = true, subcommands = {SearchCommand.class, AuthCommand.class, MeCommand.class})
public class StackoverflowCliCommand implements Runnable {

    @Option(names = {"-v", "--verbose"}, description = "...")
    boolean verbose;

    public static void main(String[] args) throws Exception {
        Credentials.init();

        PicocliRunner.run(StackoverflowCliCommand.class, args);

        System.exit(0);
    }

    public void run() {
        // business logic here
        if (verbose) {
            System.out.println("Hi!");
        }
    }
}
