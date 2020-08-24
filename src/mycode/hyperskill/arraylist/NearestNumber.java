package mycode.hyperskill.arraylist;

import java.util.*;
import java.util.Scanner;

public class NearestNumber {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strList = str.split(" ");
        for (String i: strList) {
            list.add(Integer.parseInt(i));
        }

        int n = sc.nextInt();
        int min = Integer.MAX_VALUE;
        for (int i : list) {
            if (Math.abs(n - i) < min) {
                min = Math.abs(n - i);
            }
        }
        ArrayList<Integer> newList = new ArrayList<>();
        for (int i : list) {
            if (Math.abs(n - i) == min) {
                newList.add(i);
            }
        }
        Collections.sort(newList);
        for (int i : newList) {
            System.out.print(i + " ");
        }
    }
}
