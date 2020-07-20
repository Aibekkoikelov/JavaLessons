package MyCode.JavaRush;

import java.lang.reflect.Array;
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
        if (a[2] >= b[2]) {
            if ((a[1] > b[1] && a[0] >= b[0]) || (a[1] >= b[1] && a[0] > b[0])) {
                System.out.println("Box 1 > Box 2");
            } else {
                System.out.println("Incomparable");
            }
        } else if (a[2] <= b[2]) {
            if ((a[1] < b[1] && a[0] <= b[0]) || (a[1] <= b[1] && a[0] < b[0])) {
                System.out.println("Box 1 < Box 2");
            } else {
                System.out.println("Incomparable");
            }
        }
        else if (a[0] == b[0] && a[1] == b[1] && a[2] == b[2]) {
            System.out.println("Box 1 = Box 2");
        }
        else System.out.println("Incomparable");
    }
}


