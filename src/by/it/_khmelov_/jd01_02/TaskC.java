package by.it._khmelov_.jd01_02;

import java.util.Arrays;
import java.util.Scanner;

public class TaskC {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        int[][] array = step1(i);
        System.out.println("step1: " + Arrays.deepToString(array));
        int sum = step2(array);
        System.out.println("step2: sum=" + sum);
        int[][] res = step3(array);
        System.out.println("step3: " + Arrays.deepToString(res));
    }

    static int[][] step1(int n) {
        int[][] res = new int[n][n];
        boolean okMax;
        boolean okMin;
        do {
            okMax = false;
            okMin = false;
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] = -n + (int) (Math.random() * (2 * n + 1));
                    if (res[i][j] == n)
                        okMax = true;
                    if (res[i][j] == -n)
                        okMin = true;
                }
            }
        } while (!okMax || !okMin);
        return res;
    }


    static int step2(int[][] arr) {
        int total = 0;
        for (int[] row : arr) {
            int sumInOneRow = 0;
            int positiveCount = 0;
            for (int element : row) {
                if (element > 0) {
                    positiveCount++;
                } else if (positiveCount == 1) {
                    sumInOneRow += element;
                }

                if (positiveCount == 2) {
                    total += sumInOneRow;
                    break;
                }
            }
        }
        return total;
    }

    static int[][] step3(int[][] array) {
        //findMax
        int max = Integer.MIN_VALUE;
        for (int[] row : array) {
            for (int e : row) {
                if (max < e) max = e;
            }
        }

        //checkSkips
        boolean[] skipCol = new boolean[array[0].length];
        boolean[] skipRow = new boolean[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == max) {
                    skipCol[j] = true;
                    skipRow[i] = true;
                }
            }
        }

        //getSize for result
        int rowCount = 0;
        for (boolean skip : skipRow) if (!skip) rowCount++;

        int colCount = 0;
        for (boolean skip : skipCol) if (!skip) colCount++;

        //createResult
        int[][] result = new int[rowCount][colCount];

        for (int i = 0, ir = 0; i < array.length; i++) {
            if (!skipRow[i]) {
                for (int j = 0, jr = 0; j < array[i].length; j++) {
                    if (!skipCol[j]) {
                        result[ir][jr++] = array[i][j];
                    }
                }
                ir++;
            }
        }
        return result;
    }
}
