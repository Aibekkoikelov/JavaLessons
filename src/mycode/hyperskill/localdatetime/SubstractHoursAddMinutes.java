package mycode.hyperskill.localdatetime;

import java.time.LocalDateTime;
import java.util.Scanner;

public class SubstractHoursAddMinutes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LocalDateTime dt = LocalDateTime.parse(sc.nextLine());
        int hours = sc.nextInt();
        int minutes = sc.nextInt();
        System.out.println(dt.plusMinutes(minutes).minusHours(hours));
    }
}
