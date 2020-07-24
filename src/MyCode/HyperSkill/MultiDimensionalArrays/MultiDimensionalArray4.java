package MyCode.HyperSkill.MultiDimensionalArrays;

//  Multi-dimensional array
//  Swap the columns

import java.util.Scanner;

public class MultiDimensionalArray4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int k = sc.nextInt();
        int l = sc.nextInt();

        int temp;

        for (int i = 0; i < n; i++) {
            temp = arr[i][k];
            arr[i][k] = arr[i][l];
            arr[i][l] = temp;
            }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
