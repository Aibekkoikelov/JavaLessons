package mycode.hyperskill.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class RotatingTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        sc.nextLine();
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            list.add(sc.nextLine());
        }
        Collections.sort(list, Collections.reverseOrder());
        int n = sc.nextInt();
        Collections.rotate(list, n);
        for (String lines : list) {
            System.out.println(lines);
        }
    }
}
