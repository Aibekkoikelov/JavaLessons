package mycode.hyperskill.multidimensionalarrays;

//  Multi-dimensional array
//  Maximum element in a matrix

import java.util.Scanner;

public class MultiDimensionalArray7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        int k = 0;
        int l = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.useDelimiter(",|\\s+").nextInt();
                if (arr[i][j] > max) {
                    max = arr[i][j];
                    k = i;
                    l = j;
                }
            }
        }
        System.out.println(k + " " + l);
    }
}
