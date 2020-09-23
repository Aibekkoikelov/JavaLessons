package mycode.hyperskill.sorting;

import java.util.Arrays;
import java.util.Scanner;

public class PartialSorting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();

        selectionSort(arr, k);

    }

    public static void selectionSort(int[] array, int k) {
        for (int i = 0; i < k; i++) {
            int index = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] > array[index]) {
                    index = j;
                }
            }

            int max = array[index];
            array[index] = array[i];
            array[i] = max;
            System.out.print(array[i] + " ");
        }
    }
}