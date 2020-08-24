package mycode.hyperskill.localdatetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class AddingNMinutes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LocalDateTime dt = LocalDateTime.parse(sc.nextLine());
        int minutes = sc.nextInt();
        LocalDateTime newDate = dt.plusMinutes(minutes);
        System.out.println(newDate.getYear() + " " + newDate.getDayOfYear() + " " + newDate.toLocalTime());

    }
}
