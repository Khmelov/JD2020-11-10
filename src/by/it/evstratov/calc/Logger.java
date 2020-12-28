package by.it.evstratov.calc;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public enum Logger {

    INSTANCE;

    void log(String message) {
        try(PrintWriter printWriter = new PrintWriter(new FileWriter(getPath(), true))){
            printWriter.write(Time.getTime(ConsoleRunner.lang.getLocale()) + " : " + message+"\n");
        }catch (IOException e){
            throw  new RuntimeException(e);
        }

    }

    private synchronized String getPath() {
        String src = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String path = Logger.class.getName()
                .replace(Logger.class.getSimpleName(), "")
                .replace(".", File.separator);
        String logName = "log.txt";
        return src + path + logName;
    }

}
