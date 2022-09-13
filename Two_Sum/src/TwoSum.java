import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
* Given an array of integers and an integer target, return indexes of the two numbers such that they add up to target
* */
public class TwoSum {

    public static void main(String[] args) {
        int[] input = {2, 7, 11, 15, 43, 2, 66, 4, 76 ,3, 2, 6, 8};
        int target = 51;
        System.out.println(Arrays.toString(twoSum(input, target))); // [4, 12]
        System.out.println(Arrays.toString(twoSumFast(input, target))); // [4, 12]
    }


    /*
    *  First Solution
    *  Time Complexity is O(n ^ 2)
    * */
    public static int[] twoSum(int[] array, int target) {

        for (int i = 0; i < array.length; i++) {

            if (array[i] > target) {
                continue;
            }

            for (int j = i + 1; j < array.length; j++) {
                if (array[j] + array[i] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[0];
    }

    /*
    *  Second Solution
    *  Time Complexity is O(n)
    * */
    public static int[] twoSumFast(int[] array, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < array.length; i++) {

            if (array[i] > target ) {
                continue;
            }

            if (map.containsKey(array[i])) {
                return new int[]{map.get(array[i]), i};
            }else {
                map.put(target - array[i], i);
            }
        }

        return new int[0];
    }
}
