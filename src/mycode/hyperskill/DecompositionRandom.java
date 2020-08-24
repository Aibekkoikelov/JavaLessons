package mycode.hyperskill;

import java.util.Scanner;

public class DecompositionRandom {
    static int[] arr = new int[1000];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        decomp(n, 1, 0);
    }

    static void decomp(int n, int k, int i) {

        if ( n < 0 ) return;
        if ( n == 0 ) {
            for (int j = 0; j < i; j++) System.out.print(arr[j] + " ");
            System.out.println();
        }
        else {
            if ( n >= k) {
                arr[i] = k;
                decomp(n - k, k, i + 1);
            }
            if ( k < n) decomp(n, k + 1, i);
        }
    }
}



