package mycode.hyperskill.multidimensionalarrays;

//  Multi-dimensional array
//  Spiral

import java.util.Scanner;

public class MultiDimensionalArray6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        int left = 0;
        int right = n-1;
        int top = 0;
        int bottom = n-1;
        int k = 0;
        int m = n;

        while (left <= right && bottom >= top) {

        for (int j = left; j <= right; j++) {
            arr[top][j] = k + 1;
            k++;
        }
        for (int i = top+1; i <= bottom; i++) {
            arr[i][right] = k + 1;
            k++;
        }
        for (int j = right-1; j >= left; j--) {
            arr[bottom][j] = k+1;
            k++;
        }
        for (int i = bottom-1; i > top; i--) {
                arr[i][left] = k+1;
                k++;
        }
        top++;
        bottom--;
        right--;
        left++;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}