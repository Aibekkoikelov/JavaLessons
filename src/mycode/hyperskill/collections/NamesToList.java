package mycode.hyperskill.collections;

import java.util.*;

public class NamesToList {
    public static void main(String[] args) {
        List<String> list = Arrays.asList(new Scanner(System.in).nextLine().split(" "));
//        for (String companie : line.split(" ")) {
//            list.add(companie);
//        }
        System.out.println(list);
    }
}
