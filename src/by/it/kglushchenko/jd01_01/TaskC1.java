package by.it.kglushchenko.jd01_01;

/* Нужно написать программу, которая вводит два числа с клавиатуры
и выводит их сумму на экран в виде

Ввод (это вы вводите с клавиатуры):
34 26

Вывод (это должно появиться в консоли, обратите внимание на пробелы и слово Sum:
Sum = 60

*/
import java.util.Scanner;

class TaskC1 {

    public static void main(String[] args){
        int a, b, c;
        Scanner num = new Scanner (System.in);
        a = num.nextInt();
        b = num.nextInt();
        c = a + b;

        System.out.println("Sum = "+ c);
    }



}
