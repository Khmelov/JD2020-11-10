package by.it.leshchenko.jd01_05;

import static java.lang.Math.*;

public class TaskA {
    public static void main(String[] args) {
        double a = 756.13;
        double x = 0.3;
        double part1 = cos(pow(x * x + PI / 6, 5));
        double part2 = sqrt(x * pow(a, 3));
        double part3 = log((a - 1.12 * x) / 4);
        double z = part1 - part2 - part3;
        System.out.println(z);
    }
}
