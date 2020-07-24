package MyCode.HyperSkill.MultiDimensionalArrays;

//  Multi-dimensional array
//  Sum of neighbors

import java.util.Arrays;
import java.util.Scanner;

public class MultiDimensionalArray10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = "";

        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            if (str.equals("end")) {
                break;
            } else
                input += str + "$";
        }
        String[] strArr = input.split("\\$");

        int n = strArr.length;
        int m = strArr[0].split(" ").length;
        int[][] intArr = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] nums = strArr[i].split(" ");
            int[] ints = new int[nums.length];
            for (int j = 0; j < nums.length; j++) {
                ints[j] = Integer.parseInt(nums[j]);
            }
            intArr[i] = ints;
        }



        int newElem = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                newElem = intArr[i][(j - 1 + m) % m] +
                intArr[i][(j + 1 + m) % m] +
                intArr[(i - 1 + n) % n][j] +
                intArr[(i + 1 + n) % n][j];
                System.out.print(newElem + " ");
            }
            System.out.println();
        }
    }
}










