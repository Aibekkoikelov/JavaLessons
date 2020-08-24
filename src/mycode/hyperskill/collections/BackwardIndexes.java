package mycode.hyperskill.collections;

import java.util.*;
import java.util.stream.Collectors;

public class BackwardIndexes {

    public static <T> T getElementByIndex(List<T> lst, int index) {
        int n = lst.size();
        if (index >= 0) {
            return lst.get(index);
        } else {
            return lst.get(index + n);
        }
    }

    /* Do not change code below */
    public static void main(String[] args) {

        final Scanner scanner = new Scanner(System.in);

        final List<String> values = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        final int index = Integer.parseInt(scanner.nextLine());

        try {
            String element = getElementByIndex(values, index);
            System.out.println(element);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Exception");
        }
    }
}