package by.it.soldatenko.jd02_06;

import java.util.Calendar;

public class Runner {

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                Logger.getLogger().log("Test "+Calendar.getInstance().getTime() );
            }).start();

        }

    }
}
