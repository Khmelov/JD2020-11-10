package by.it.plehanova.calc.builder;

import by.it.plehanova.calc.CalcException;

public abstract class ReportBuilder {
    LogReport report;

    LogReport getReport() {
        return report;
    }

    public void createNewReport() {
        report = LogReport.getInstance();
    }


    public abstract void buildLog(CalcException e);

    public abstract void buildHead();

    public abstract void buildDate();

}
