package mycode.hyperskill.sorting;

public class SortingNumbers {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 6, 5, 4 };


            System.out.println(selectionSort(arr));;
    }

    public static int selectionSort(int[] array) {
        int count = 0;
        for (int i = 0; i < array.length - 1; i++) {
            int index = i; // the index of the found min

            /* Iterating over the unsorted subarray to find the min */
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] > array[index]) {
                    index = j;
                }
            }
            count++;
            /* Exchanging the found min and the current element */
            int min = array[index];
            array[index] = array[i];
            array[i] = min;
        }

        return count;
    }
}
