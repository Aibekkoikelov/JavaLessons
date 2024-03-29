package mycode.hyperskill.multidimensionalarrays;

// Multi-dimensional array
// Symmetric matrix

import java.util.*;

public class MultiDimensionalArray2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean symmetric = true;
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] != arr[j][i]) {
                    symmetric = false;
                }
            }
        }
        if (symmetric) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}