package MyCode.HyperSkill;

// Multi-dimensional array
// Symmetric matrix

import java.util.*;

public class Main7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] != arr[j][i]) {
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println("YES");
    }
}
