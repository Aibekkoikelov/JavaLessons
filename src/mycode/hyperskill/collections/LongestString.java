package mycode.hyperskill.collections;

import java.util.*;


public class LongestString {

    static void changeList(List<String> list) {
        int strSize = 0;
        String temp = "";
        for (String str : list) {
            if (str.length() > strSize) {
                strSize = str.length();
                temp = str;
            }
        }
        Collections.fill(list, temp);
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        List<String> lst = Arrays.asList(s.split(" "));
        changeList(lst);
        lst.forEach(e -> System.out.print(e + " "));
    }
}

