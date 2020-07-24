package MyCode.HyperSkill.MultiDimensionalArrays;

//  Multi-dimensional array
//  Cinema

import java.util.Scanner;

public class MultiDimensionalArray9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        int count = 1;
        int row = 0;


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int k = sc.nextInt();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m-1; j++) {
                    if (arr[i][j] == 0 && arr[i][j+1] == 0) {
                        count++;
                    } else {
                        count = 1;
                    }
                    if (count == k) {
                        row = i + 1;
                        break;
                    }
                }
                count = 1;
            }
        System.out.println(row);
    }
}
