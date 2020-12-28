package by.it.plehanova.calc.builder;

import by.it.plehanova.calc.CalcException;

import java.text.DateFormat;
import java.util.Date;

public class ReportShort extends ReportBuilder {

    DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);

    @Override
    public void buildLog(CalcException e) {
        report.logExeption(e.getMessage());
    }

    @Override
    public void buildHead() {
        report.writeHeadline("-----This is short report-----");
    }

    @Override
    public void buildDate() {
        report.writeDate(df);
    }

}
