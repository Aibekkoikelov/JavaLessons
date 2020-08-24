package mycode.hyperskill.localdate;

import java.time.LocalDate;
import java.util.Scanner;

public class TwoWeeksAfter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(LocalDate.parse(sc.nextLine()).plusDays(14));
    }
}
