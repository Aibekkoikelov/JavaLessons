package mycode.hyperskill.localdate;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Scanner;

public class FirstAndLastDays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LocalDate dateOne = LocalDate.of(sc.nextInt(), sc.nextInt(), 1);
        System.out.println(dateOne + " " + dateOne.plusMonths(1).minusDays(1));
    }
}
