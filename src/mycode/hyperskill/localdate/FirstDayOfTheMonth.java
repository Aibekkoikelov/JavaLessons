package mycode.hyperskill.localdate;

import java.time.LocalDate;
import java.time.Year;
import java.util.Scanner;

public class FirstDayOfTheMonth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        int dayOfTheYear = sc.nextInt();
        LocalDate date = LocalDate.ofYearDay(year, dayOfTheYear);
        System.out.println(date.getDayOfMonth() == 1);
    }
}
