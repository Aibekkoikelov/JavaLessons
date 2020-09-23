package mycode.hyperskill.collections;

import java.util.ArrayList;
import java.util.*;

public class template {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(100, 200, 300, 1, 1, 2, 3);
        LinkedHashSet<Integer> hashSet = new LinkedHashSet<>(list);
        ArrayList<Integer> newList = new ArrayList<>(hashSet);
        for (int i : newList) {
            System.out.print(i + " ");
        }
    }
}
