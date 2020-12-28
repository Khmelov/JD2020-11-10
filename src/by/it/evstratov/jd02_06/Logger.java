package by.it.evstratov.jd02_06;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class Logger {

    static private volatile Logger logger;
    private Logger(){}
    private final String logName = "log.txt";

    static Logger getLogger(){
        Logger local = logger;
        if(local == null){
         synchronized (Logger.class){
             local = logger;
             if(local == null){
                 local = logger = new Logger();
             }

         }
        }
        return local;
    }

    void log(String message) {

        try(PrintWriter printWriter = new PrintWriter(new FileWriter(getPath(), true))){
            printWriter.write(message+"\n");
        }catch (IOException e){
            throw  new RuntimeException(e);
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
