package mycode.hyperskill.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;
import java.util.stream.Collectors;

class CollectionUtils2 {

    public static Collection<Integer> pow2(Collection<Integer> numbers) {
        Collection<Integer> sqrnumbers = new ArrayList<>();
        for (int o : numbers) {
            sqrnumbers.add(o * o);
        }
        return sqrnumbers;
    }
}

/* Please, do not modify this I/O code */
public class SquaresList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Collection<Integer> numbers = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        Collection<Integer> result = CollectionUtils2.pow2(numbers);

        System.out.println(result.stream()
                .map(Object::toString)
                .collect(Collectors.joining(" ")));
    }
}
