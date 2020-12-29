package by.it.leshchenko.jd02_05;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import static java.text.DateFormat.*;

public class CurrentDate {
    String get(Locale locale) {
        DateFormat f = getDateInstance(SHORT, locale);
        return f.format(new Date());
    }
}
