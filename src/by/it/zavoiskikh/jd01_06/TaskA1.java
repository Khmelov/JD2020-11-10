package by.it.zavoiskikh.jd01_06;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class TaskA1 {
    public static void main(String[] args) {
        StringBuilder dynText = new StringBuilder (Poem.text);
        Pattern pattern = Pattern.compile("[a-яA-яёЁ]+");
        Matcher matcher = pattern.matcher (dynText);
        while (matcher.find()) {
            System.out.println (matcher.group ());
        }
    }
}
