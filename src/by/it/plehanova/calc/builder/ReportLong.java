package by.it.plehanova.calc.builder;

import by.it.plehanova.calc.CalcException;

import java.text.DateFormat;

public class ReportLong extends ReportBuilder {
    private DateFormat df = DateFormat.getDateInstance(DateFormat.LONG);

    @Override
    public void buildLog(CalcException e) {
        for (StackTraceElement element : e.getStackTrace()) {
            report.logExeption(element.toString());
        }
    }

    @Override
    public void buildHead() {
        report.writeHeadline("-----This is full report-----");
    }

    @Override
    public void buildDate() {
        report.writeDate(df);
    }
}
