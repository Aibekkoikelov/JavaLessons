package mycode.hyperskill.localtime;

import java.time.LocalTime;
import java.util.Scanner;

public class ReturnTimeWithoutSeconds {
    public static void main(String[] args) {
        System.out.println(LocalTime.parse(new Scanner(System.in).nextLine()).withSecond(0));
    }
}
