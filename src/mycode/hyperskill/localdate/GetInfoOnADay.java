package mycode.hyperskill.localdate;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class GetInfoOnADay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        LocalDate date = LocalDate.parse(str);
        System.out.println(date.getDayOfYear() + " " + date.getDayOfMonth());

    }
}
