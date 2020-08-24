package mycode.hyperskill.localdatetime;

import java.time.LocalDateTime;
import java.util.Scanner;

public class PassedHours {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LocalDateTime dt = LocalDateTime.parse(sc.nextLine());
        System.out.println((dt.getDayOfYear() - 1) * 24 + dt.getHour());
    }
}