package mycode.hyperskill.basicalgorithms;

import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        boolean index = false;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] str = sc.nextLine().split(" ");
        int[] intLine = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            intLine[i] = Integer.parseInt(str[i]);
            if (intLine[i] == i) {
                index = true;
            }
        }
        System.out.println(index);
    }
}