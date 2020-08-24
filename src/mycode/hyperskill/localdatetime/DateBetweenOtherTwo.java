package mycode.hyperskill.localdatetime;

import java.time.LocalDate;
import java.util.Scanner;

public class DateBetweenOtherTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LocalDate t1 = LocalDate.parse(sc.next());
        LocalDate t2 = LocalDate.parse(sc.next());
        LocalDate t3 = LocalDate.parse(sc.next());
        System.out.println(t1.isAfter(t2) && t1.isBefore(t3) || t1.isBefore(t2) && t1.isAfter(t3));
    }
}