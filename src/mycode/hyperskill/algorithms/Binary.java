package mycode.hyperskill.algorithms;

import java.util.Scanner;

public class Binary {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int[] sortedArray = new int[n];
            for (int i = 0; i < n; i++) {
                sortedArray[i] = sc.nextInt();
            }
            int m = sc.nextInt();
            int[] array = new int[m];
            for (int i = 0; i < m; i++) {
                array[i] = sc.nextInt();
            }
            for (int i : array) {
                System.out.print(binarySearch(sortedArray, i) + " ");
            }
        }

        public static int binarySearch(int[] array, int elem) {
            int left = 0;
            int right = array.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2; // the index of the middle element
                if (elem == array[mid]) {
                    return mid + 1; // the element is found, return its index
                } else if (elem < array[mid]) {
                    right = mid - 1; // go to the left subarray
                } else {
                    left = mid + 1;  // go the the right subarray
                }
            }
            return -1; // the element is not found
        }
    }