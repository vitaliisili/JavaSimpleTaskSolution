import java.util.Arrays;

/*
*  We define the following:
*  A subarray of an n-element array is an array composed from a contiguous block of the original array's elements.
*  For example, if array = [1,2,3], then the subarrays are [1], [2], [3], [1, 2], [2, 3], and [1, 2, 3].
*  Something like [1, 3] would not be a subarray as it's not a contiguous subsection of the original array.
*  The sum of an array is the total sum of its elements.
*  An array's sum is negative if the total sum of its elements is negative.
*  An array's sum is positive if the total sum of its elements is positive.
*  Given an array of  integers, find and print its number of negative subarrays on a new line.
* */
public class NegativeSubarray {

    public static void main(String[] args) {
        int[] input = {1, -2, 4, -5, 1};

        negativeSubarrays(input); // 9
    }

    public static void negativeSubarrays(int[] input) {
        int count = 0;

        for (int i = 0; i < input.length; i++) {
            int sum = 0;
            for (int j = i; j < input.length; j++) {
                sum += input[j];
                if (sum < 0) count++;
            }
        }
        System.out.println(count);
    }
}
