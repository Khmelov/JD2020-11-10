package by.it.kglushchenko.jd02_05;

import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

public class Runner {
    public static void main(String[] args) {
        Language lang = Language.INSTANCE;
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG, lang.getLocale());
        Locale locale;
        //Locale.setDefault(Locale.ENGLISH);
        if (args.length == 2) {
            locale = new Locale(args[0], args[1]);
        } else {
            locale = new Locale("be", "BY");
        }
        Locale.setDefault(locale);
        lang.setLocale(locale);
        LocalDate now = LocalDate.now();


        System.out.println(lang.get(Messages.WELCOME));
        System.out.println(lang.get(Messages.QUESTION));
        System.out.println(lang.get(User.FIRST_NAME));
        System.out.println(lang.get(User.LAST_NAME));
        System.out.println(lang.get(dateFormat.format(date)));
    }
}
