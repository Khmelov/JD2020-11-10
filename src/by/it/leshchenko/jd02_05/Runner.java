package by.it.leshchenko.jd02_05;

import by.it.leshchenko.jd02_05.txt.Messages;
import by.it.leshchenko.jd02_05.txt.User;

import java.util.Locale;

public class Runner {
    public static void main(String[] args) {
        final Language lang = Language.INSTANCE;
        Locale.setDefault(Locale.ENGLISH);
        if (args.length==2) {
            lang.setLocale(new Locale(args[0], args[1]));
        }
//        final Locale locale = new Locale("de");
        System.out.println(lang.get(Messages.WELCOME));
        System.out.println(lang.get(Messages.QUESTION));
        System.out.println(lang.get(User.FIRST_NAME));
        System.out.println(lang.get(User.LAST_NAME));
    }
}
