package mycode.hyperskill.string;

import java.util.Scanner;

public class EuphoniousWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        String str = sc.nextLine();
        str = str.replaceAll("[aeiouy]", "1");
        str = str.replaceAll("[bcdfghjklmnpqrstvwxz]", "0");
        String[] newStr1 = str.split("0");
        String[] newStr2 = str.split("1");
        int n = 0;
        int m = 0;

        for (String s : newStr1) {
            if (s.length() >= 3) {
                n += s.length() % 2 + s.length() / 2 - 1;
            }
        }

        for (String s : newStr2) {
            if (s.length() >= 3) {
                m += s.length() % 2 + s.length() / 2 - 1;
            }
        }

        System.out.println(m + n);
    }
}

