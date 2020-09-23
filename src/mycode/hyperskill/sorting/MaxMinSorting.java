package mycode.hyperskill.sorting;

import java.util.Arrays;
import java.util.Scanner;

public class MaxMinSorting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] str = sc.nextLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        arr = rearrange(arr, n);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    static int[] rearrange(int[] arr, int n) {
        Arrays.sort(arr);

        int[] sortedArray = new int[arr.length];
        int firstIndex = 0, lastIndex = arr.length-1;

        for (int i = 0; i < arr.length; i++) {

            if((i%2) == 0) { //even indices
                sortedArray[i] = arr[lastIndex--];

            }
            else {
                sortedArray[i] = arr[firstIndex++];
            }
        }
        return sortedArray;
    }
}

