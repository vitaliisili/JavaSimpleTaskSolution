
/*
*  For better understanding, please follow the numbers of the next array consecutively:

* array = [[1,2,3],
           [8,9,4],
           [7,6,5]]
* snail(array) #=> [1,2,3,4,5,6,7,8,9]
* NOTE: The idea is not sort the elements from the lowest value to the highest;
* the idea is to traverse the 2-d array in a clockwise snailshell pattern.
* NOTE 2: The 0x0 (empty matrix) is represented as en empty array inside an array [[]].
* */

import java.util.Arrays;

public class Snail {

    public static void main(String[] args) {
        int[][] input = {
                {1,  2,  3,  4,  5},
                {16, 17, 18, 19, 6},
                {15, 24, 25, 20, 7},
                {14, 23, 22, 21, 8},
                {13, 12, 11, 10, 9}
        };

        int[][] g = new int[0][0];
        System.out.println(Arrays.toString(snail(input)));
    }

    public static int[] snail(int[][] array) {
        if (array[0].length == 0) {
            return new int[0];
        }

        int k = 0;
        int length = array.length;

        int[] path = new int[length * length];

        for (int l = 0; l < (array.length / 2) + 1; l++) {
            int j = l, i = l;

            if (array.length % 2 != 0 && ((array.length / 2) + 1) - 1 == l) {
                for (int m = 0; m < length; m++) {
                    path[k++] = array[i][j++];
                }
            }else {
                for (int m = 0; m < length - 1; m++) {
                    path[k++] = array[i][j++];
                }
            }

            for (int m = 0; m < length - 1; m++) {
                path[k++] = array[i++][j];
            }

            for (int m = 0; m < length - 1; m++) {
                path[k++] = array[i][j--];
            }

            for (int m = 0; m < length - 1; m++) {
                path[k++] = array[i--][j];
            }

            length = length - 2;
        }

        return path;
    }
}
