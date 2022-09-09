import java.util.Arrays;

/*
 *  You are given a 2D array. An hourglass in an array is a portion shaped like this:
 *  a b c
 *    d
 *  e f g
 *  For example, if we create an hourglass using the number 1 within an array full of zeros, it may look like this:
 *  1 1 1 0 0 0
 *  0 1 0 0 0 0
 *  1 1 1 0 0 0
 *  0 0 0 0 0 0
 *  0 0 0 0 0 0
 *  0 0 0 0 0 0
 * Actually, there are many hourglasses in the array above. The three leftmost hourglasses are the following:
 *  1 1 1     1 1 0     1 0 0
 *    1         0         0
 *  1 1 1     1 1 0     1 0 0
 *  The sum of an hourglass is the sum of all the numbers within it. The sum for the hourglasses above are 7, 4, and 2, respectively.
 *  In this problem you have to print the largest sum among all the hourglasses in the array.
 * */
public class HourGlassBiggestSum {

    public static void main(String[] args) {

        int[][] input1 = {
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 3, 0, 5, 0, 0, 8, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 9, 0, 0},
                {0, 0, 0, 4, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 8, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 2, 0, 6, 0}
        };

        int[][] input2 = {
                {1, 1, 1, 2, 3, 9},
                {2, 1, 8, 3, 9, 6},
                {1, 1, 1, 2, 3, 5},
                {4, 5, 2, 4, 4, 4},
                {5, 5, 9, 2, 5, 5},
                {1, 6, 1, 2, 4, 5}
        };

        int[][] input3 = {
                {-9,-9,-9, 1, 1, 1},
                { 0,-9, 0, 4, 3, 2},
                {-9,-9,-9, 1, 2, 3},
                { 0, 0, 8, 6, 6, 0},
                { 0, 0, 0,-2, 0, 0},
                { 0, 0, 1, 2, 4, 0}
        };

        getBiggestHourglass(input1); // 17
        getBiggestHourglass(input2); // 33
        getBiggestHourglass(input3); // 28
    }

    public static void getBiggestHourglass(int[][] arr) {

        int max = Integer.MIN_VALUE;

        for (int row = 0; row <= arr.length / 2; row++) {
            for (int col = 0; col <= arr.length / 2; col++) {
                int sum = 0;
                sum += arr[row][col];
                sum += arr[row][col + 1];
                sum += arr[row][col + 2];
                sum += arr[row + 1][col + 1];
                sum += arr[row + 2][col];
                sum += arr[row + 2][col + 1];
                sum += arr[row + 2][col + 2];

                max = Math.max(sum, max);
            }
        }

        System.out.println(max);
    }
}
