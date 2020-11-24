package by.it.terentyev.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    public static void main(String[] args) {
        String[][] arrPoem = new String[32][2];
        String sb = new String(Poem.text);
        sb = sb.replaceAll(" *[^а-яА-ЯёЁ \n]+ *"," ");
        sb = sb.trim();
        Pattern pattern = Pattern.compile(".{1,}\n");
        Matcher matcher = pattern.matcher(sb);
        int i=0;
        while (matcher.find()){
            int col=matcher.end()-matcher.start();
            arrPoem [i][1] = matcher.group();
            arrPoem[i][0]= String.valueOf(col);
            //System.out.println(col);
            //System.out.println(matcher.group()+ "ok");
            i++;
        }
        System.out.println(arrPoem[1][0]+" "+arrPoem[1][1]);
    }
}
