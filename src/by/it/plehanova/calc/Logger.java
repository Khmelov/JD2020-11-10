package by.it.plehanova.calc;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

enum Logger {
    INSTANCE;
    private final String fileName = "log.txt";

    void log(String message) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(getPath(), true))) {
            writer.println(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private String getPath() {
        String src = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String path = Logger.class.getPackageName()
                .replace(".", File.separator)
                .concat(File.separator)
                .concat("reports")
                .concat(File.separator);
        return src + path + fileName;
    }
}
