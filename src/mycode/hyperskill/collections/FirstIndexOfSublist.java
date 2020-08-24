package mycode.hyperskill.collections;

import java.util.*;

public class FirstIndexOfSublist {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> lstOne = Arrays.asList(sc.nextLine().split(" "));
        List<String> lstTwo = Arrays.asList(sc.nextLine().split(" "));
        System.out.println(Collections.indexOfSubList(lstOne, lstTwo) + " " + Collections.lastIndexOfSubList(lstOne, lstTwo));
    }
}
