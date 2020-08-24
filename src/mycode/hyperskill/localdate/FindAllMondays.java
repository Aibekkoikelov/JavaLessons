package mycode.hyperskill.localdate;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;

public class FindAllMondays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        int month = sc.nextInt();
        int lengthOfMonth = LocalDate.of(year, month, 1).lengthOfMonth();
        for (int i = 1; i <= lengthOfMonth; i++) {
            if (LocalDate.of(year, month, i).getDayOfWeek().toString().equals("MONDAY")) {
                System.out.println(LocalDate.of(year, month, i));
            }
        }
    }
}
