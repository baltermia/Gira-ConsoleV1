package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class logger {
    String filePath;

    public logger (String filePath) {
        this.filePath = filePath;
    }

    public void log (String text) throws IOException {
        Files.write(Paths.get(filePath), text.getBytes());
    }

    public String getFilePath() {
        try {
            return Files.readString(Paths.get("config.txt"));
        }
        catch (Exception ex) {
            return null;
        }
    }
}