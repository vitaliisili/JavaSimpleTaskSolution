import java.util.*;
import java.util.stream.Collectors;

/*
 * Task: Check if two arrays contains same elements and return list of matched elements
 * */
public class CheckSameElementsInArray {

    public static void main(String[] args) {
        Integer[] a1 = {3, 1, 3, 8};
        Integer[] a2 = {3, 2, 1, 8, 4, 3, 5, 1};

        List<Integer> result = findSameElements(a1, a2);
        System.out.println(result); // [1, 3, 8]
    }

    private static List<Integer> findSameElements(Integer[] a1, Integer[] a2) {
        Set<Integer> uniq1 = Set.copyOf(Arrays.asList(a1));
        Set<Integer> uniq2 = Set.copyOf(Arrays.asList(a2));
        return uniq1.stream()
                .filter(uniq2::contains)
                .sorted()
                .collect(Collectors.toList());
    }

}
