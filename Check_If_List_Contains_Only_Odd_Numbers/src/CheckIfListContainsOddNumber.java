import java.util.List;

/*
* Task: Given an List of Integers, check if the list contains only odd number and return false or true;
* */
public class CheckIfListContainsOddNumber {

    public static void main(String[] args) {
        List<Integer> list = List.of(3, 5, 7, 9, 11);

        boolean firstSolution = isOnlyOddNumberFirstSolution(list);
        System.out.println("First Solution: " + firstSolution); // true

        boolean secondSolution = isOnlyOddNumberSecondSolution(list);
        System.out.println("Second Solution: " + secondSolution); // true
    }

    /*
    * return value using loop
    * */
    private static boolean isOnlyOddNumberFirstSolution(List<Integer> list) {
        boolean isOdd = true;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                isOdd = false;
                break;
            }
        }
        return isOdd;
    }

    /*
     * return value using parallel stream
     * */
    private static boolean isOnlyOddNumberSecondSolution(List<Integer> list) {
        return list.parallelStream().anyMatch(num -> num % 2 != 0);
    }
}
