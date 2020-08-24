package mycode.hyperskill;

import java.math.BigInteger;
import java.util.Scanner;

public class SmallestValue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger a = sc.nextBigInteger();
        BigInteger result = BigInteger.ONE;
        for (int i = 1;; i++){
            result = result.multiply(BigInteger.valueOf(i));
            if (result.compareTo(a) >= 0) {
                System.out.println(i);
                break;
            }
        }
    }
}

