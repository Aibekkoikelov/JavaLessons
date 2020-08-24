package mycode.hyperskill.localdatetime;

import java.time.LocalDateTime;
import java.util.Scanner;

public class AddDaysSubstractHours {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        LocalDateTime date = LocalDateTime.parse(str[0]).withSecond(0);
        int days = Integer.parseInt(str[1]);
        int hours = Integer.parseInt(str[2]);
        System.out.println(date.plusDays(days).minusHours(hours));
    }

}
