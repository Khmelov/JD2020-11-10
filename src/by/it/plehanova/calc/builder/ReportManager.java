package by.it.plehanova.calc.builder;

import by.it.plehanova.calc.CalcException;

import java.util.Date;

public class ReportManager {
    private ReportBuilder builder;

    public void setBuilder(ReportBuilder rb) {
        builder = rb;
    }

    public LogReport getReport() {
        return builder.getReport();
    }

    public void constructReport() {
        builder.createNewReport();
        builder.buildHead();;
        builder.buildDate();
    }
}
