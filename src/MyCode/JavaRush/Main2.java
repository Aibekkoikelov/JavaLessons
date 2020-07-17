package MyCode.JavaRush;

import java.util.*;

class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] a = new int[len];
        int[] b = new int[len];

        for (int i = 0; i < len; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < len; i++) {
            b[i] = sc.nextInt();
        }
        double tax[] = new double[len];

        int max = 0;
        for (int i = 0; i < len-2; i++) {
            tax[i] = a[i] * b[i];
            if (tax[i] / 100 > tax[i+1] / 100) {
               max = i;
            } else max = i+1;

        }

        System.out.println(max);
//        System.out.println((a[0]*b[0]) / 100 +" "+ (a[1]*b[1]) / 100);
    }
}

