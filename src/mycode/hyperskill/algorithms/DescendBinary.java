package mycode.hyperskill.algorithms;

import java.util.Scanner;

public class DescendBinary {

    /* Modify this method */
    public static int binarySearch(int elem, int[] array) {
        int left = 0;
        int right = array.length - 1;
        int mid = -1;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (elem == array[mid] && elem < array[mid - 1]) {
                return mid;
            } else if (elem >= array[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int elem = sc.nextInt();
        sc.nextLine();
        String[] line = sc.nextLine().split(" ");
        int[] array = new int[line.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(line[i]);
        }
        System.out.println(binarySearch(elem, array));
    }
}