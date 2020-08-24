package mycode.hyperskill.localdatetime;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class WholeHoursBetweeTwoDates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LocalDateTime dateOne = LocalDateTime.parse(sc.nextLine());
        LocalDateTime dateTwo = LocalDateTime.parse(sc.nextLine());
        int hrs1 = (dateOne.getDayOfYear() - 1) * 24 + dateOne.getHour();
        int hrs2 = (dateTwo.getDayOfYear() - 1) * 24 + dateTwo.getHour();
        System.out.println(dateOne.until(dateTwo, ChronoUnit.HOURS));
    }
}
