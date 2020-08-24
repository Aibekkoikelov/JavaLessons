package mycode.hyperskill.stringbuilder;

import java.util.Scanner;

public class ConcatStrings {

    public static String concatenateStringsWithoutDigits(String[] strings) {
        String str = "";
        for (String i : strings) {
           str = str + i.replaceAll("[0-9]","");
        }
        return str;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split("\\s+");
        String result = concatenateStringsWithoutDigits(strings);
        System.out.println(result);
    }
}

