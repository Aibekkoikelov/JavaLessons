package mycode.hyperskill.multidimensionalarrays;

// Multi-dimensional array
// Pretty looking pattern

import java.util.*;

public class MultiDimensionalArray3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] arr = new char[4][4];

        for (int i = 0; i < 4; i++) {
            arr[i] = sc.nextLine().toCharArray();
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (arr[i][j] == arr[i + 1][j]
                        && arr[i][j] == arr[i + 1][j + 1]
                        && arr[i][j] == arr[i][j + 1]) {
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println("YES");
    }
}