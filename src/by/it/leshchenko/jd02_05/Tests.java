package by.it.leshchenko.jd02_05;

import java.util.Arrays;

public class Tests {

    public static void main(String[] args) {
        int[] a = {5, 5};
        int b = 1;
        a[b] = b = 0;
        System.out.println(Arrays.toString(a));
    }
}
