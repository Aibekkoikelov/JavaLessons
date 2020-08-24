package mycode.hyperskill;

import java.math.BigInteger;
import java.util.Scanner;

public class DoubleFactorial {

    public static BigInteger calcDoubleFactorial(int n) {
        BigInteger fact = BigInteger.ONE;

        for (int i = n; i > 0; i = i - 2) {
            fact = fact.multiply(BigInteger.valueOf(i));
        }
        return fact;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println(calcDoubleFactorial(n));
    }
}

