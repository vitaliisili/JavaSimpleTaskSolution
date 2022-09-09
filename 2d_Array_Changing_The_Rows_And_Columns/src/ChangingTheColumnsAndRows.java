
/*
*
* Write a Java program to print an array after changing the rows and columns of a given two-dimensional array.
* Original Array:
* 10 20 30
* 40 50 60
* After changing the rows and columns of the said array:
* 10 40
* 20 50
* 30 60
* */
public class ChangingTheColumnsAndRows {

    public static void main(String[] args) {
        int[][] input = {
                {10, 20, 30},
                {40, 50, 60}
        };

        transform(input); // 10 40
                          // 20 50
                          // 30 60
    }

    public static void transform(int[][] array) {

        int[][] transformed = new int[array[0].length][array.length];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                transformed[j][i] = array[i][j];
            }
        }

        for (int[] row: transformed) {
            for (int number: row) {
                System.out.print(number + " ");
            }
            System.out.println();
        }
    }
}
