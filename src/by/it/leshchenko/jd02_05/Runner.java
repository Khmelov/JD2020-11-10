package by.it.leshchenko.jd02_05;

import java.util.Locale;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        CurrentDate date = new CurrentDate();

        final Language lang = Language.INSTANCE;
        Locale.setDefault(Locale.ENGLISH);
        if (args.length==2) {
            lang.setLocale(new Locale(args[0], args[1]));
        }
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            if (s.equals("end")) {
                break;
            }
            switch (s) {
                case "ru":
                    lang.setLocale(new Locale("ru", "RU"));
                    break;
                case "be":
                    lang.setLocale(new Locale("be", "BY"));
                    break;
                case "en":
                    lang.setLocale(Locale.ENGLISH);
                    break;
                default:
                    System.out.println("Unknown locale. Used \"en\" ");
                    lang.setLocale(Locale.ENGLISH);
            }
            System.out.println(lang.get(Messages.WELCOME));
            System.out.println(lang.get(Messages.QUESTION));
            System.out.println(lang.get(User.FIRST_NAME));
            System.out.println(lang.get(User.LAST_NAME));
            System.out.println(date.get(lang.getLocale()));
        }
    }
}
