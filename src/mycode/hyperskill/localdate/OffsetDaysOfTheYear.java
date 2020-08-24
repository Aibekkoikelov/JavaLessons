package mycode.hyperskill.localdate;

import java.time.LocalDate;
import java.util.Scanner;

public class OffsetDaysOfTheYear {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LocalDate date = LocalDate.parse(sc.nextLine());
        int offset = sc.nextInt();
        int year = date.getYear();

        while (date.getYear() == year) {
            System.out.println(date);
            date = date.plusDays(offset);
        }
    }
}
