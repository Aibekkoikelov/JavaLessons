package mycode.hyperskill.localtime;

import java.time.LocalTime;
import java.util.Scanner;

public class SecondsBetweenTwoTimePoints {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LocalTime timeOne = LocalTime.parse(sc.nextLine());
        LocalTime timeTwo = LocalTime.parse(sc.nextLine());
        System.out.println(Math.abs(timeOne.toSecondOfDay() - timeTwo.toSecondOfDay()));
    }
}
