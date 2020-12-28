package by.it.plehanova.jd02_05;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Language language = Language.INSTANCE;
        Locale.setDefault(Locale.ENGLISH);
        Date date = new Date();
        Scanner scanner = new Scanner(System.in);
/*        if (args.length == 2) {
            language.setLocale(new Locale(args[0], args[1]));
        }*/

        while (!scanner.hasNext("end")) {
            String lang = scanner.next();

            if (lang.equals("ru")) {
                language.setLocale(new Locale("ru", "RU"));

            } else if (lang.equals("be")) {
                language.setLocale(new Locale("be", "BY"));

            } else if (lang.equals("en")) {
                language.setLocale(new Locale("en", "UK"));

            } else {
                language.setLocale(Locale.getDefault());
            }
            DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG, language.getLocale());
            System.out.printf("%s, %s %s!\n", language.get(Messages.HELLO), language.get(User.FIRST_NAME), language.get(User.LAST_NAME));
            System.out.println(language.get(Messages.QUESTION));
            System.out.println(dateFormat.format(date));
        }

    }
}
