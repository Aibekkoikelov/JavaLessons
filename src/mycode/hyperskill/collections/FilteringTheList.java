package mycode.hyperskill.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FilteringTheList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int value = sc.nextInt();
        sc.nextLine();
        String lineOne = sc.nextLine();
        String lineTwo = sc.nextLine();

        List<Integer> lineOneList = new ArrayList<>();
        List<Integer> lineTwoList = new ArrayList<>();

        for (String digit : lineOne.split(" ")) {
            lineOneList.add(Integer.parseInt(digit));
        }
        int countOne = Collections.frequency(lineOneList, value);

        for (String digit : lineTwo.split(" ")) {
            lineTwoList.add(Integer.parseInt(digit));
        }
        int countTwo = Collections.frequency(lineTwoList, value);

        System.out.println(countOne == countTwo);



//        System.out.println(lineOneList);
//        System.out.println(lineTwoList);
    }
}
