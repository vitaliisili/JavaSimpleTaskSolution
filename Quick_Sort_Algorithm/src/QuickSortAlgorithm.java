
/*
* Given an integer array, sort it using the Quicksort algorithm
* */

import java.util.Arrays;

public class QuickSortAlgorithm {

    public static void main(String[] args) {
        int[] input = {10, 32, 0, -5, 99, 11, 7, -5, -20, 1, 54, 6, 7, 90, 3, 5, 78, 12, 9, 4, 33, -8, -1, 22, 6, -54};
        quickSort(input, 0, input.length - 1);

        System.out.println(Arrays.toString(input));
    }

    private static void quickSort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }

        int pivot = partition(array, start, end);

        quickSort(array, start, pivot - 1);
        quickSort(array, pivot + 1, end);
    }

    public static int partition(int[] array, int start, int end) {
        int pivot = array[end];
        int pIndex = start;

        for (int i = start; i < end; i++) {
            if (array[i] <= pivot) {
                int temp = array[i];
                array[i] = array[pIndex];
                array[pIndex] = temp;
                pIndex++;
            }
        }

        int temp = array[end];
        array[end] = array[pIndex];
        array[pIndex] = temp;

        return pIndex;
    }

}
