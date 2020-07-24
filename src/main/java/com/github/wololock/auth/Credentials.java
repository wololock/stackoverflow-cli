package com.github.wololock.auth;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

final public class Credentials {

    final static String LOCATION = String.format(
            "%s/.stackoverflow-cli/credentials.properties",
            System.getenv("HOME")
    );

    public static void init() {
        var file = new File(LOCATION);
        var parent = file.getParentFile();

        if (!parent.exists() && !parent.mkdirs()) {
            throw new IllegalStateException("Cannot create folder " + parent.getAbsolutePath());
        }

        try {
            if (!file.exists() && !file.createNewFile()) {
                throw new IllegalStateException("Cannot create file " + file.getAbsolutePath());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.setProperty("micronaut.config.files", LOCATION);
    }

    public static void store(String token) {
        try (var os = new FileOutputStream(new File(LOCATION))) {
            var content = "stackoverflow.auth.credentials.token="+token+"\n";
            os.write(content.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
