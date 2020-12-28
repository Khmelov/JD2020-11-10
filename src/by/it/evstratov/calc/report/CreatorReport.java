package by.it.evstratov.calc.report;

public class CreatorReport {

    private ReportBuilder reportBuilder;

    public Report getReport(){
        return reportBuilder.getReport();
    }
    public void setReportBuilder(ReportBuilder rb){
        reportBuilder = rb;
    }
    public void constructorReport(){
        reportBuilder.createReport();
    }

}
