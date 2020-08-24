package mycode.hyperskill.localdatetime;

import java.time.LocalDate;
import java.util.Scanner;

public class NewYearOrNot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        LocalDate date = LocalDate.parse(str[0]);
        int days = Integer.parseInt(str[1]);
        LocalDate newdate = date.plusDays(days);
        System.out.println(date.getYear() != newdate.getYear());
    }
}
