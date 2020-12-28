package by.it.soldatenko.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public enum Language {

    ISTANCE;
    ResourceBundle bundle;

   final void setLocale(Locale locale){

       String BASE= Language.class.getName().replace(Language.class.getSimpleName(), "")+"resources.language";
       bundle=ResourceBundle.getBundle(BASE, locale);
    }
    String get(String key){
        return bundle.getString(key);
    }


}
