import java.util.Arrays;

/*
* From a given array of natural numbers, return the distance between the two closest numbers
* */

public class FindToClosestNumberInArray {

    // Returns the distance between the two closest numbers first solution not recommended !!!
    static int distClosestNumbersFirstSolution(int[] numbers) {
        int closest = Integer.MAX_VALUE;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                int dif = Math.abs(numbers[i] - numbers[j]);
                if (dif != 0 && dif < closest) {
                    closest = dif;
                }
            }
        }
        return closest;
    }

    // Returns the distance between the two closest numbers second solution recommended !!!
    static int distClosestNumbersSecondSolution(int[] numbers) {
        Arrays.sort(numbers);
        int closest = Math.abs(numbers[1] - numbers[0]);
        for (int i = 2; i < numbers.length; i++) {
            int current = Math.abs(numbers[i] - numbers[i - 1]);
            closest = Math.min(current, closest);
        }
        return closest;
    }

    public static void main(String[] args) {
        int[] testArray = {3, 9, 50, 155, 99, 13, 98, 4534565}; // test data
        int firstSolution = distClosestNumbersFirstSolution(testArray);
        int secondSolution = distClosestNumbersSecondSolution(testArray);
        System.out.println("first result: " + firstSolution); // Expected result is 1 (the 2 closest numbers are 98 and 99)
        System.out.println("second result: " + secondSolution); // Expected result is 1 (the 2 closest numbers are 98 and 99)
    }
}
