package by.it.terentyev.jd01_04;

import by.it.terentyev.jd01_03.InOut;

import java.util.Arrays;
import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите колличество людей: ");
        int n = sc.nextInt();
        String[] lastNames = new String[n];
        for (int i = 0; i < n; i++) {
            lastNames[i]= sc.next();
        }
        int[][] zarplata=new int[n][4];
       //int[] zarplataTmp=new int[4];
       // for (int i = 0; i < n; i++) {
            System.out.println("Введите зарплату для "+lastNames[1]);
            String zarplataLine = sc.next();
            //String zarplataLine = "80 2 3 4";
            //double[] array= String.line;
            String[] strArray = zarplataLine.trim().split(" ");
           // double[] result=new double[strArray.length];
        System.out.println(Arrays.toString(strArray));
            //int[] result=new int[zarplataLine.length];

           //String zarplataTmp [] = zarplataLine.trim().split(" ");
//        for (int i = 0; i <= n; i++) {
//            zarplata [1][i] = Integer.parseInt(strArray[i]);
//
//        }
//        System.out.println(Arrays.deepToString(zarplata));
           //zarplata [1][] = int[strArray.length];
           // String[] strArray = zarplataLine.trim().split(" ");
           // double[] result=new double[strArray.length];
        }


    }
//}
