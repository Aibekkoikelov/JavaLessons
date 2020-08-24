package mycode.hyperskill.localdatetime;

import java.time.LocalTime;
import java.util.Scanner;

public class IntersectionOfTimeRanges {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LocalTime t1 = LocalTime.parse(sc.next());
        LocalTime t2 = LocalTime.parse(sc.next());
        LocalTime t3 = LocalTime.parse(sc.next());
        LocalTime t4 = LocalTime.parse(sc.next());
        boolean isTrue = false;
        if ((t4.isAfter(t1) || t4.equals(t1)) && (t3.isBefore(t2) || t3.equals(t2))) {
            isTrue = true;
        }
        System.out.println(isTrue);
    }
}
