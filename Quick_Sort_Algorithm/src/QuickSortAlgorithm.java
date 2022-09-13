
/*
* Given an integer array, sort it using the Quicksort algorithm
* */

import java.util.Arrays;

public class QuickSortAlgorithm {

    public static void main(String[] args) {
        int[] input = {10, 32, 0, -5, 99, 11, 7, -5,-20, 1, 54,6, 7, 90, 3, 5, 78, 12, 9, 4, 33, -8, -1, 22, 6, -54};
        quickSort(input);
        System.out.println(Arrays.toString(input));
    }


    public static void quickSort(int[] unsortedArray) {
        quickSort(unsortedArray, 0, unsortedArray.length - 1);
    }

    private static void  quickSort(int[] unsortedArray, int begin, int end) {
        if (begin < end) {
            int pivot = partition(unsortedArray, begin, end);

            quickSort(unsortedArray, begin, pivot - 1);
            quickSort(unsortedArray, pivot + 1, end);
        }
    }

    private static int partition(int[] array, int start, int end) {
        int pivot = array[end];
        int lowerIndex = start;

        for (int i = start; i < end; i++) {
            if (array[i] <= pivot) {
                int temp = array[i];
                array[i] = array[lowerIndex];
                array[lowerIndex] =temp;
                lowerIndex++;
            }
        }

        int temp = array[end];
        array[end] = array[lowerIndex];
        array[lowerIndex] = temp;

        return lowerIndex;
    }

}
