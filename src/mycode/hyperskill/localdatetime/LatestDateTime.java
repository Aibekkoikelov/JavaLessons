package mycode.hyperskill.localdatetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class LatestDateTime {
    public static void main(String[] args) {
        LocalDateTime ldt = LocalDateTime.MIN;
        Scanner sc = new Scanner(System.in);
        int dates = sc.nextInt();
        for (int i = 1; i <= dates; i++) {
            LocalDateTime current = LocalDateTime.parse(sc.next());
            if (ldt.isBefore(current)) {
                ldt = current;
            }
        }
        System.out.println(ldt);
    }
}
