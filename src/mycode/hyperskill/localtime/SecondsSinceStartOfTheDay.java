package mycode.hyperskill.localtime;

import java.time.LocalTime;
import java.util.Scanner;

public class SecondsSinceStartOfTheDay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(LocalTime.ofSecondOfDay(sc.nextInt()));
    }
}
