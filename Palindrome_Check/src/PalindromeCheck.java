import java.util.Locale;

/*
* Task: Given a String, check if the string is palindrome if yes return true if not return false
* */
public class PalindromeCheck {

    public static void main(String[] args) {
        String input = "kartrak";

        boolean firstSolution = isPalindromeFirstSolution(input);
        System.out.println("First Solution: " + firstSolution); // true

        boolean secondSolution = isPalindromeSecondSolution(input);
        System.out.println("Second Solution: " + secondSolution); // true
    }

    /*
    * Use StringBuffer class
    * */
    private static boolean isPalindromeFirstSolution(String input) {
        return new StringBuffer(input).reverse().toString().equals(input);
    }

    /*
    * Use loop
    * */
    private static boolean isPalindromeSecondSolution(String input) {
        boolean isPalindrome = true;
        for (int i = 0; i < input.length() / 2; i++) {
            if (input.charAt(i) != input.charAt(input.length() - i - 1)) {
                isPalindrome = false;
                break;
            }
        }
        return isPalindrome;
    }

}
