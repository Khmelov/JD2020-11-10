package by.it.rydzeuski.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public class Runner {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        Locale locale = new Locale("ru", "RU");
        String lang ="by.it.rydzeuski.jd02_05.resourses";
        ResourceBundle bundle = ResourceBundle.getBundle(lang,locale);
        String s = bundle.getString("messeges.welcome");
        System.out.println(s);

    }
}
