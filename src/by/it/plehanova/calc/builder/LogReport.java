package by.it.plehanova.calc.builder;

import by.it.plehanova.calc.CalcException;

import java.text.DateFormat;
import java.util.Date;

public class LogReport {
    public static class Logger {
        public static final LogReport HOLDER = new LogReport();
    }

    public static LogReport getInstance() {
        return Logger.HOLDER;
    }

    private static final DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
    private static final StringBuilder sb = new StringBuilder();
    private static final Date date = new Date();

    public void writeHeadline(String head) {
        sb.append("\t").append(head).append("\n");
    }

    public void logExeption(String message) {
        sb.append(message).append("\n\n");
    }

    public void writeDate(DateFormat df) {
        sb.append("\t").append(df.format(date)).append("\n\n");
    }

    public void print() {
        System.out.println(sb);
    }

}
