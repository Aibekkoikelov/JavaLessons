package mycode.hyperskill.localdate;

import java.time.LocalDate;
import java.time.Year;
import java.util.Scanner;

public class NumbersToDays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Year year = Year.of(sc.nextInt());
        int day1 = sc.nextInt();
        int day2 = sc.nextInt();
        int day3 = sc.nextInt();
        System.out.println(year.atDay(day1));
        System.out.println(year.atDay(day2));
        System.out.println(year.atDay(day3));
    }
}

