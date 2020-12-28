package by.it.rydzeuski.jd02_06;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {
    private static volatile Logger logger;
    private final String logName = "log.txt";

    private Logger() {
    }

    static Logger getLogger() {
        Logger local = logger;
        if (local == null) {
            synchronized (Logger.class) {
                local = logger;
                if (local == null) {
                    local = logger = new Logger();
                }
            }
        }
        return local;

    }

    void log(String massage) {
        try (
                PrintWriter writer = new PrintWriter(new FileWriter(getPath(), true));
        ) {
            writer.println(massage);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private synchronized String getPath() {
        String src = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String path = Logger.class.getName()
                .replace(Logger.class.getSimpleName(), "")
                .replace(".", File.separator);

        return src + path + logName;
    }
}
