
/*
* Task: Reverse string
* */

public class ReverseString {

    // First solution revers char array
    public static String reverseStringFirstSolution(String str) {
        if (str == null) {
            throw new IllegalArgumentException("String can't be null");
        }
        String[] charStr = str.split("");
        StringBuilder reversedString = new StringBuilder();
        for (int i = charStr.length - 1; i >= 0; i--) {
            reversedString.append(charStr[i]);
        }
        return reversedString.toString();
    }

    // Second solution using reverse method from StringBuilder class
    public static String reverseStringSecondSolution(String str) {
        if (str == null) {
            throw new IllegalArgumentException("String can't be null");
        }
        return new StringBuilder(str).reverse().toString();
    }

    public static void main(String[] args) {
        String exampleString = "This is java !";
        String firstSolution = reverseStringFirstSolution(exampleString); // Result must be "! avaj si sihT"
        String secondSolution = reverseStringSecondSolution(exampleString); // Result must be "! avaj si sihT"
        System.out.println("First Solution: " + firstSolution);
        System.out.println("Second Solution: " + secondSolution);
    }
}
