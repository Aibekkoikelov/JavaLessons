package mycode.hyperskill.collections;

import java.util.*;

public class FrequencyOfCharacters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(Collections.frequency(Arrays.asList(sc.nextLine().split(" ")), sc.next()));
    }
}
