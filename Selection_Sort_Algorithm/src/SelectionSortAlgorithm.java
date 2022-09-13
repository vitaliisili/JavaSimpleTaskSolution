import java.util.Arrays;

/*
* Selection sort O(n ^ 2);
* */
public class SelectionSortAlgorithm {

    public static void main(String[] args) {
        int[] input = {10, 32, 0, -5, 99, 11, 7, -5, -20, 1, 54, 6, 7, 90, 3, 5, 78, 12, 9, 4, 33, -8, -1, 22, 6, -54};

        selectionSort(input);
        System.out.println(Arrays.toString(input));
    }

    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
    }
}
