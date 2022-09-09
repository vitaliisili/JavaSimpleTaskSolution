
/*
* Print sum of each row and column in 2d array
* */
public class SumOfRowAndColumn {

    public static void main(String[] args) {
        int[][] input = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };

        printSumOfArrayColAndRow(input);

    }

    public static void printSumOfArrayColAndRow(int[][] array) {

        int[] colSum = new int[array[0].length];

        for (int i = 0; i < array.length; i++) {
            int rowSum = 0;
            for (int j = 0; j < array[i].length; j++) {
                rowSum += array[i][j];
                colSum[j] += array[i][j];
            }
            System.out.println("Sum of row " + (i + 1) + " = " + rowSum);
        }

        for (int i = 0; i < colSum.length; i++) {
            System.out.println("Sum of column " + (i + 1) + " = " + colSum[i]);
        }

    }
}
