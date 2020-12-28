package by.it.evstratov.calc;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class Time {

    static public String getTime(Locale locale) {
        DateFormat dateFormat = DateFormat.getTimeInstance(DateFormat.SHORT, locale);
        String time = dateFormat.format(new Date());
        return time;
    }
}
