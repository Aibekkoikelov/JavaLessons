package mycode.hyperskill.collections;

import java.util.*;

public class MultipleSwaps {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>(Arrays.asList(sc.nextLine().split(" ")));
        int swaps = sc.nextInt();
        int[][] lines = new int[swaps][2];
        for (int i = 0; i < swaps; i++) {
            Collections.swap(list,sc.nextInt(), sc.nextInt());
        }
        for (String number : list) {
            System.out.print(number + " ");
        }
    }
}
