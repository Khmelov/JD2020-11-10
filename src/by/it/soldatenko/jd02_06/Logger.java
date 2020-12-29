package by.it.soldatenko.jd02_06;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class Logger {
    private  static volatile Logger logger;
    private final String logname="log.txt";
    private Logger(){

    }
    static  Logger getLogger(){
        Logger local = logger;
        if (logger==null){
            synchronized (Logger.class){
                local=logger;
                if (local==null){
                    local= logger= new Logger();
                }
            }
        }return  local;
    }
    void log(String message){
        try
            (PrintWriter printWriter = new PrintWriter(new FileWriter(dir(), true)))
        {printWriter.println(message);
        } catch (IOException e) {
//            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    private synchronized String dir() {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String cldir = Logger.class.getName().replace(Logger.class.getSimpleName(), "").replace(".", File.separator);
        return path + cldir +logname ;
    }
}
