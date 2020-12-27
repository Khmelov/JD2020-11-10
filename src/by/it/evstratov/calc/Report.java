package by.it.evstratov.calc;

public class Report {



    public static class SingletonHolder {
        public static final Report HOLDER_INSTANCE = new Report();
    }

    public static Report getInstance() {
        return SingletonHolder.HOLDER_INSTANCE;
    }

    private final StringBuilder report = new StringBuilder();

    public void writeReport(String str){
        report.append(str).append("\n");
    }

    public void printReport(){
        System.out.println(report);
    }

    public void endReport(){
        writeReport("End session: " + Time.getTime(ConsoleRunner.lang.getLocale()));
        printReport();
    }

    public void startReport(){
        writeReport("**************REPORT**************");
        writeReport("Start session: " + Time.getTime(ConsoleRunner.lang.getLocale()));
    }

}
