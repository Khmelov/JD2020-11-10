package by.it.soldatenko.jd01_06;

public class TaskC1 {
    public static void main(String[] args) {
        String[] str = Poem.text.split("\n");
        String space = " ";
        //        System.out.println(space.indexOf(str[0].charAt(0)));
        int maxLenght = 0;
        for (String value : str) {//определяю максимальну длинну строки maxLength
            if (value.length() > maxLenght) {
                maxLenght = value.length();
            }
        }
        for (String s : str) {
            int count = 0;
            if (maxLenght > s.length()) {
                for (int j = 1; j < s.length(); j++) {
                    if (space.indexOf(s.charAt(j)) == 0) {//определяем количесво пробелов встроке
                        count++;
                    }
                }

            }
            StringBuilder sb = new StringBuilder(s);
            count = 0;

            while (count < (maxLenght - s.length())) {
                for (int j = 0; j < sb.length() - 1; j = j + 1) {
                    if (sb.charAt(j + 1) == ' ' && sb.charAt(j) != ' ') {
                        if (count < (maxLenght - s.length())) {
                            sb.insert(j + 2, " ");
                            count++;
                        }


                    }

                }
            }


//                    }
//                j=j+1;
//                }
            System.out.println(sb);


        }

    }}