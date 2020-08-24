package mycode.hyperskill.localdatetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class DatesInRange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LocalDateTime dateOne = LocalDateTime.parse(sc.nextLine());
        LocalDateTime dateTwo = LocalDateTime.parse(sc.nextLine());
        if (dateOne.isAfter(dateTwo)) {
            LocalDateTime tempDate = dateOne;
            dateOne = dateTwo;
            dateTwo = tempDate;
        }
        int count = 0;
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            LocalDateTime date = LocalDateTime.parse(sc.next());
            if (!date.isBefore(dateOne) && date.isBefore(dateTwo)) {
                count++;
            }
        }
        System.out.println(count);
    }
}