import java.util.Arrays;

/*
* Merge sort algorithm O(n log n)
* */
public class MergeSortAlgorithm {

    public static void main(String[] args) {
        int[] input = {10, 32, 0, -5, 99, 11, 7, -5,-20, 1, 54,6, 7, 90, 3, 5, 78, 12, 9, 4, 33, -8, -1, 22, 6, -54}; // 26
        mergeSort(input);
        System.out.println(Arrays.toString(input));
    }

    public static void mergeSort(int[] array) {
        if (array.length < 2) {
            return;
        }

        int mid = array.length / 2;
        int[] left = new int[mid];
        int[] right = new int[array.length - mid];

        System.arraycopy(array, 0, left, 0, left.length);
        System.arraycopy(array, mid, right, 0, right.length);

        mergeSort(left);
        mergeSort(right);

        merge(array, left, right);

    }

    private static void merge (int[] originalArray, int[] leftArray, int[] rightArray) {

        int i = 0, j = 0, k = 0;

        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] <= rightArray[j]) {
                originalArray[k] = leftArray[i++];
            }else {
                originalArray[k] = rightArray[j++];
            }
            k++;
        }

        while ( i < leftArray.length) {
            originalArray[k++] = leftArray[i++];
        }

        while ( j < rightArray.length) {
            originalArray[k++] = rightArray[j++];
        }
    }

}
