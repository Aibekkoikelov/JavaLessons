package MyCode.HyperSkill.MultiDimensionalArrays;

import java.util.Scanner;

public class MultiDimensionalArray9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        int count = 0;
        int row = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int k = sc.nextInt();

        for (int i = 0; i < n && count != k; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    count++;
                }
                if (count == k) {
                    row = i + 1;
                    break;
                }
                count = 0;
            }
            count = 0;
        }
        System.out.println(row);

    }
}
