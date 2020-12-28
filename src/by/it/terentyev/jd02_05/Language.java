package by.it.terentyev.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public enum Language {
    INSTANCE;

    private final String BASE = "by.it.terentyev.jd02_05.resourses.language";
    ResourceBundle bundle;

    Language() {
    setLocale(Locale.getDefault());
    }

    final void setLocale(Locale locale){
        bundle=ResourceBundle.getBundle(BASE, locale);
    }
    String get(String key){
        return bundle.getString(key);
    }
}
