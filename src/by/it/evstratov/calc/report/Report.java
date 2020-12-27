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

    public void writeReport(String str){
        result.append(str).append("\n");
    }

    public void printReport(){
        System.out.println(result);
    }

    public void endReport(){
        result.append("\n");
        writeReport("End session: " + Time.getTime(ConsoleRunner.lang.getLocale()));
        printReport();
    }

    public void startReport(){
        writeReport("**************REPORT**************");
        writeReport("Start session: " + Time.getTime(ConsoleRunner.lang.getLocale()));
        result.append("\n");
    }



}
