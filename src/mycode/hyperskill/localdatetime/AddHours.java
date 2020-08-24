package mycode.hyperskill.localdatetime;

import java.time.LocalDateTime;
import java.util.Scanner;

public class AddHours {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        LocalDateTime dt = LocalDateTime.parse(sc.nextLine()).plusHours(11);
//        System.out.println(dt.toLocalDate());
        System.out.println(LocalDateTime.parse(new Scanner(System.in).nextLine()).plusHours(11).toLocalDate());
    }
}
