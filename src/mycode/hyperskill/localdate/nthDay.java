package mycode.hyperskill.localdate;

import java.time.LocalDate;
import java.util.Scanner;

public class nthDay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        int month = sc.nextInt();
        int day = sc.nextInt();
        LocalDate date = LocalDate.of(year, month, 1).plusMonths(1).minusDays(1);
        System.out.println(date.minusDays(day));
        System.out.println(LocalDate.parse("2017-09-21"));
    }
}
