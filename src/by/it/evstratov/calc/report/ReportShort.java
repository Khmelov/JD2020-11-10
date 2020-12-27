package by.it.evstratov.calc.report;

import by.it.evstratov.calc.CalcException;

public class ReportShort extends ReportBuilder{

    @Override
    public void writeError(CalcException e) {
        report.result.append(e.getMessage()).append("\n");
    }
}
