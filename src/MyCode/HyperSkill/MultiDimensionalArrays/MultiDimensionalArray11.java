package MyCode.HyperSkill.MultiDimensionalArrays;

//  Multi-dimensional array
//  Check sudoku

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MultiDimensionalArray11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        double n = m * m;
        int[][] arr = new int[m * m][m * m];
        boolean crossed = false;
        double sum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int j = 0; j < n; j++) {
            sum = 0;
             for (int i = 0; i < n; i++) {
                sum = sum + arr[i][j];
            }
            if (sum != n * ((n + 1) / 2))
                crossed = true;
            break;
        }

        for (int i = 0; i < n && !crossed; i++) {
            sum = 0;
            for (int j = 0; j < n; j++) {
                sum = sum + arr[i][j];
            }
            if (sum != n * ((n + 1) / 2))
                crossed = true;
            break;
        }



        int k = 0;
        while (k < n) {
            for (int i = 0; i < n && !crossed; i++) {
                for (int j = k + 1; j < n; j++) {
                    if (arr[i][j] == arr[i][k]) {
                        crossed = true;
                        break;
                    }
                }
            }
            k++;
        }
        k = 0;
        while (k < n) {
            for (int i = 0; i < n && !crossed; i++) {
                for (int j = k + 1; j < n; j++) {
                    if (arr[j][i] == arr[j][k]) {
                        crossed = true;
                        break;
                    }
                }
            }
            k++;
        }

//        int sum = 0;
//        i = 0;
//        int j = 0;
//        wholeloop:
//        for (int k = 0; k <= n; k++) {
//                for (int s = i * m; s < i * m + m; i++) {
//                    for (int d = i * m; d < i * m + m; i++) {
//                        sum = sum + arr[s][d];
//                        }
//                }
//            if (sum != n * ((n + 1) / 2)) {
//                crossed = true;
//                break wholeloop;
//            } else {
//                sum = 0;
//            }
//        }
        if (crossed) {
            System.out.println("NO");
        } else
            System.out.println("YES");
    }
}

