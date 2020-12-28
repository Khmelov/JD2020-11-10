package by.it.leshchenko.calc;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

enum Logger {
    INSTANCE;

    void log(String message) {
        try (final PrintWriter writer = new PrintWriter(new FileWriter(getPath(), true))) {
            writer.println(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private synchronized String getPath() {
        String userDir = System.getProperty("user.dir");
        String classDir = Logger.class.getName()
                .replace(Logger.class.getSimpleName(), "")
                .replace(".", File.separator);
        String logName = "log.txt";
        return userDir + File.separator + "src" + File.separator + classDir + logName;
    }
}