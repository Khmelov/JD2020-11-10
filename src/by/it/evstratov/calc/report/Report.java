package by.it.evstratov.calc.report;

import by.it.evstratov.calc.ConsoleRunner;
import by.it.evstratov.calc.Time;

public class Report {

    public static class SingletonHolder {
        public static final Report HOLDER_INSTANCE = new Report();
    }

    public static Report getInstance() {
        return SingletonHolder.HOLDER_INSTANCE;
    }

    final StringBuilder result = new StringBuilder();

    public void write(String str){
        result.append(str);
    }

    void printReport(){
        System.out.println(result);
    }

    public void endReport(){
        write("\n" + "End session: " + Time.getTime(ConsoleRunner.lang.getLocale()));
        printReport();
    }

    public void startReport(){
        write("**************REPORT**************" + "\n");
        write("Start session: " + Time.getTime(ConsoleRunner.lang.getLocale()) + "\n" + "\n");
    }



}
