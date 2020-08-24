package mycode.hyperskill.string;

import java.util.Scanner;

public class Passwords {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int n = sc.nextInt();
        String str = "";

        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerAlphabet = "abcdefghijklmnopqrstuvxyz";
        String digits = "1234567890";

        if (a != 0) {
        for (int i = 0; i < a; i++) {
                str += alphabet.charAt(i % alphabet.length());
            }
        }
        if (b != 0) {
            for (int i = 0; i < b; i++) {
                str += lowerAlphabet.charAt(i % lowerAlphabet.length());;
            }
        }
        if (c != 0) {
            for (int i = 0; i < c; i++) {
                str += digits.charAt(i % digits.length());;
            }
        }
//        if (str.length() < n) {
            while (str.length() < n) {
                str += alphabet.charAt(a % alphabet.length());;
                a++;
            }
//        }
        System.out.println(str);
    }
}