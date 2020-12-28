package by.it.rydzeuski.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public enum Language {
    INSTANCE;
    ResourceBundle bundle;

    Language() {
        setLocale(Locale.getDefault());
    }


    final void setLocale(Locale locale) {
        String BASE = "by.it.rydzeuski.jd02_04.resource.language";
        bundle = ResourceBundle.getBundle(BASE,locale);
    }
    String get(String key){
       return bundle.getString(key);
    }
}
