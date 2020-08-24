package mycode.hyperskill.localdatetime;

import java.time.LocalTime;
import java.util.Scanner;

public class Stores {
    public static void main(String[] args) {
        LocalTime currentTime = LocalTime.of(20, 00);
        Scanner sc = new Scanner(System.in);
        int lines = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < lines; i++) {
            String name = sc.next();
            if (currentTime.isBefore(LocalTime.parse(sc.next()))) {
                System.out.println(name);
            }
        }
    }
}
