package mycode.hyperskill.localdate;

import java.time.LocalDate;
import java.util.Scanner;

public class LastDayOfTheMonth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        int dayOfTheYear = sc.nextInt() + 1;
        LocalDate date = LocalDate.ofYearDay(year, dayOfTheYear);
        System.out.println(date.getDayOfMonth() == 1);
    }
}