package mycode.hyperskill;
// Iterating over arrays
// Boxes  (hard)  problem

import java.util.*;

public class Main5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[3];
        int[] b = new int[3];
        for (int i = 0; i < 3; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < 3; i++) {
            b[i] = sc.nextInt();
        }
        Arrays.sort(a);
        Arrays.sort(b);

        if (a[0] == b[0] && a[1] == b[1] && a[2] == b[2]) {
            System.out.println("Box 1 = Box 2");
        } else if (a[0] <= b[0] && a[1] <= b[1] && a[2] <= b[2]) {
            System.out.println("Box 1 < Box 2");
        } else if (a[0] >= b[0] && a[1] >= b[1] && a[2] >= b[2]) {
            System.out.println("Box 1 > Box 2");
        } else {
            System.out.println("Incomparable");
        }
    }
}
