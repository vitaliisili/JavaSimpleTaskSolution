import java.util.Arrays;

/*
* Bubble sort algorithm O(n ^ 2)
* */
public class BubbleSortAlgorithm {

    public static void main(String[] args) {
        int[] input = {10, 32, 0, -5, 99, 11, 7, -5, -20, 1, 54, 6, 7, 90, 3, 5, 78, 12, 9, 4, 33, -8, -1, 22, 6, -54};

        bubbleSort(input);
        System.out.println(Arrays.toString(input));
    }

    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j + 1] < array[j]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
}
