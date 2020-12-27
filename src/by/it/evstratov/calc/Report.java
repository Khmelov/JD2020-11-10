package by.it.evstratov.calc;

public class Report {

    public static class SingletonHolder {
        public static final Report HOLDER_INSTANCE = new Report();
    }

    public static Report getInstance() {
        writeReport("**************REPORT**************");
        writeReport("Start session: " + Time.getTime(ConsoleRunner.lang.getLocale()));
        return SingletonHolder.HOLDER_INSTANCE;
    }

    private static final StringBuilder report = new StringBuilder();

    public static void writeReport(String str){
        report.append(str).append("\n");
    }

    public static void printReport(){
        System.out.println(report);
    }

}
