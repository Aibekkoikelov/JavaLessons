package mycode.hyperskill.multidimensionalarrays;

//  Multi-dimensional array
//  The star figure

import java.util.Scanner;

public class MultiDimensionalArray5 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        char[][] arr = new char[n][n];

//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                arr[i][j] = sc.next().charAt(0);
//            }
//        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j || i + j == n - 1 || j == n / 2 || i == n / 2) {
                    System.out.print("* ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }
}
