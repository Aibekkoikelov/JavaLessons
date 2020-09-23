package mycode.hyperskill.algorithms;

import java.util.Scanner;

public class CountComparsions {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] str = sc.nextLine().split(" ");
        int target = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(str[i]);
        }
        System.out.println(jumpSearch(array, target, n));
    }

    public static int jumpSearch(int[] array, int target, int n) {
        int count = 0;
        int jumpLength = (int) Math.sqrt(n);
        int leftBorder = 0;
        int currentRight = 0;

        if (array[currentRight] == target) {
            count++;
            return count;
        }
        /* Finding a block where the element may be present */
        while (currentRight < n - 1) {
            count++;
            currentRight = Math.min(n - 1, leftBorder + jumpLength);

            if (array[currentRight] >= target) {
                break;
            }
            leftBorder = currentRight;

            if ((currentRight == array.length - 1) && target > array[currentRight]) {
                count++;
            }
        }
        for (int i = currentRight; i > leftBorder; i--) {
            count++;
            if (array[i] <= target) {
                return count;
            }
        }

        return count;
    }
}

