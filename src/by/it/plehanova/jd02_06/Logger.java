package by.it.plehanova.jd02_06;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class Logger {
    private static volatile Logger logger;
    private final String fileName = "log.txt";

    private Logger() {

    }

    static Logger getLogger() {
        Logger log = logger;
        if (log == null) {
            synchronized (Logger.class) {
                log = logger;
                if (log == null) {
                    log = new Logger();
                }
            }
        }
        return log;
    }

    void log(String message){
        try(PrintWriter writer = new PrintWriter(new FileWriter(getPath(),true))) {
            writer.println(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private synchronized String getPath() {
        String src = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String path = Logger.class.getPackageName()
                .replace(".", File.separator)
                .concat(File.separator);
        return src + path + fileName;
    }
}
