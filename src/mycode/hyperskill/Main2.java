package mycode.hyperskill;
// Iterating over arrays
// The longest ascending sequence (hard)  problem

import java.util.*;

class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] arr = new int[len];
        int count = 1;
        int maxCount = 0;

        for (int i = 0; i < len; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 1; i < len; i++) {
            if (arr[i] > arr[i - 1]) {
                count++;
            } else if (count >= maxCount) {
                maxCount = count;
                count = 1;
            } else count = 1;
                continue;
        }
        System.out.println(maxCount);
    }
}