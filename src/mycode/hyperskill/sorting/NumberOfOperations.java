package mycode.hyperskill.sorting;

import java.util.Arrays;
import java.util.Scanner;

public class NumberOfOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[k];
        int[] iterations = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                arr[j] = sc.nextInt();
            }
            iterations[i] = selectionSort(arr, k);
        }

        System.out.println(Arrays.toString(iterations));

    }

    public static int selectionSort(int[] array, int k) {
        int count = 0;
        for (int i = 0; i < k; i++) {
            int index = i;
            for (int j = i + 1; j < k; j++) {
                if (array[j] < array[index]) {
                    index = j;
                }
            }

            int max = array[index];
            array[index] = array[i];
            array[i] = max;
            count++;
        }
        return count;
    }
}