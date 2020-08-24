package mycode.hyperskill.multidimensionalarrays;

// Multi-dimensional array
// Fill the matrix by numbers
import java.util.*;

public class MultiDimensionalArray1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = Math.abs(i-j);
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
        }
    }
}