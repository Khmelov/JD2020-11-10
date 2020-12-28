package by.it.leshchenko.jd02_06;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class Logger {
    private static volatile Logger logger;

    private final String logName = "log.txt";

    private Logger() {
    }

    static Logger getLogger() {
        Logger localLogger = logger;
        if (localLogger == null) {
            synchronized (Logger.class) {
                localLogger = logger;
                if (localLogger == null) {
                    logger = localLogger = new Logger();
                }
            }
        }
        return localLogger;
    }

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
        return userDir + File.separator + "src" + File.separator + classDir + logName;
    }
}