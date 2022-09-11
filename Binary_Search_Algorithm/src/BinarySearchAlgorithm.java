import java.util.Arrays;

/*
* Given a sorted array of n integers and a target value, determine if the target exists in the array in logarithmic
* time using the binary search algorithm. If target exists in the array, print the index of it.
* */
public class BinarySearchAlgorithm {

    public static void main(String[] args) {
        int[] nums = {2, 3, 5, 7, 8, 10, 12, 15, 18, 20};
        int target = 12;
        if (binarySearch(nums, target ) < 0) {
            System.out.println("Element not found");
        }else {
            System.out.println("Element found at index " + binarySearch(nums, target)); // 6
        }

    }

    private static int binarySearch(int[] nums, int target) {
       int start = 0;
       int end = nums.length - 1;

       while (start <= end) {

           int mid = (start + end) / 2;

           if (target == nums[mid]) {
               return mid;
           }else if (target < nums[mid]) {
               end = mid - 1;
           }else {
               start = mid + 1;
           }
       }

        return -1;
    }
}
