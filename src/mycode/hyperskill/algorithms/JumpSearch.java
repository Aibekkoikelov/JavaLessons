package mycode.hyperskill.algorithms;

import java.util.Scanner;

public class JumpSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] str = sc.nextLine().split(" ");
        int[] array = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            array[i] = Integer.parseInt(str[i]);
        }
        int target = sc.nextInt();

        jumpSearch(array, target, n);
    }


    public static void jumpSearch(int[] array, int target, int n) {

        int jumpLength = (int)Math.sqrt(n);
        int leftBorder = 0;
        int currentRight = 0;

        /* Finding a block where the element may be present */
        while (currentRight < n - 1) {
            currentRight = Math.min(n, leftBorder + jumpLength) - 1;

            if (array[currentRight] >= target) {
                System.out.println(leftBorder + " " + currentRight);
                return;
            }
            leftBorder = currentRight + 1;
        }
        System.out.println("-1");
    }
}