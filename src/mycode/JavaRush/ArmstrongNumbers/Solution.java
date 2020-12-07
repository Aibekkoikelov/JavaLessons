package mycode.JavaRush.ArmstrongNumbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Алгоритмы-числа
*/

public class Solution {

    private static final long[] MULTIPLIERS = new long[]{1L, 10L, 100L, 1000L, 10000L, 100000L, 1000000L, 10000000L, 100000000L, 1000000000L, 10000000000L, 100000000000L, 1000000000000L, 10000000000000L, 100000000000000L, 1000000000000000L, 10000000000000000L, 100000000000000000L, 1000000000000000000L};
    private static int numCount = 0;

    public static long[] getNumbers(long N) {
        List<Long> list = new ArrayList<>();
        long[] result = null;
        if (N < 1) {
            return result;
        }

        for (long i = 1; i < N; i++) {
            long originalNumber, remainder, res = 0;
            long p = numbers(i);
            originalNumber = i;
            for (; originalNumber != 0; originalNumber /= 10) {
                remainder = originalNumber % 10;
                res += power(remainder, p);

            }
            if (res == i) {
                list.add(i);
            }
        }
//
        int k = list.size();
        result = new long[k];

        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    //
    static long power(long x, long y) {
        long temp;
        if (y == 0) {
            return 1;
        }
        temp = power(x, y / 2);
        if (y % 2 == 0) {
            return temp * temp;
        } else {
            return x * temp * temp;
        }
    }

    private static int numbers(long n) {
        for (int i = numCount; i < MULTIPLIERS.length; i++) {
            if (n >= MULTIPLIERS[i]) {
                numCount = i + 1;
                return numCount;
            } else {
                return numCount;
            }
        }
        return numCount;
    }


    public static void main(String[] args) {
        long a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1000)));
        long b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);

        a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1000000000)));
        b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);


    }
}
