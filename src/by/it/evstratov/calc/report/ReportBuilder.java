package by.it.evstratov.calc.report;

import by.it.evstratov.calc.CalcException;

abstract public class ReportBuilder {

    Report report;
    void createReport(){
        report = Report.getInstance();
    }
    Report getReport(){
        return report;
    }
    public abstract void writeError(CalcException e);

}
