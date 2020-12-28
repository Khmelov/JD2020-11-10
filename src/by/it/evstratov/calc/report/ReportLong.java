package by.it.evstratov.calc.report;

import by.it.evstratov.calc.CalcException;

public class ReportLong extends ReportBuilder{

    @Override
    public void writeError(CalcException e) {
        for (StackTraceElement stackTraceElement : e.getStackTrace()) {
            report.write(stackTraceElement + "\n");
        }
    }
}
