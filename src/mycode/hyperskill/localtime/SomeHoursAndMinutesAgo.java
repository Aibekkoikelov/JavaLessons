package mycode.hyperskill.localtime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

public class SomeHoursAndMinutesAgo {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String str = sc.nextLine();
//        int h = sc.nextInt();
//        int m = sc.nextInt();
//        System.out.println(m + " " + h);
//        System.out.println(time.);
//        System.out.println(Arrays.toString(str));
//        int hours = Integer.parseInt(str[0]);
//        int minutes = Integer.parseInt(str[1]);
//        int hours = str.charAt(0) - 48;
//        int minutes = str.charAt(2) - 48;
//        System.out.println( LocalTime.parse(str).withSecond(0).minusHours(h).minusMinutes(m));
        System.out.println(LocalDateTime.of(2020, 12, 31, 23, 59, 59).minusYears(1));
        System.out.println(LocalDateTime.of(LocalDate.of(2019, 12, 31), LocalTime.MAX));
        System.out.println(LocalDateTime.parse("2019-12-31T23:59").withSecond(59));
        System.out.println(LocalDateTime.parse("2017-12-31T23:59").withYear(2019));
        System.out.println(LocalDateTime.of(2020, 1, 1, 0, 1, 1).minusSeconds(61));
        System.out.println(LocalDateTime.of(LocalDate.of(2020, 1, 1), LocalTime.MIDNIGHT).minusSeconds(1));



    }
}
