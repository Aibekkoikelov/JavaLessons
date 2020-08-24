package mycode.hyperskill;

import java.util.*;

public class RandOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int n = scanner.nextInt();
        int k = scanner.nextInt();

//        int[] line = new int[];
        int index = 0;
        int max = 0;

        for (; a <= b; a++) {
            int j = 1;
            Random rnd = new Random(a);
            while (j <= n) {
                if (rnd.nextInt() > max && rnd.nextInt() < k) {
                    max = rnd.nextInt();
                }
                j++;
            }

        }
        System.out.println(index);
        System.out.println(max);
    }
}
