
/*
 * Task: Check if the positive number is prime if yes return "Prime" if not return "Not Prime"
 * */

import java.math.BigInteger;

public class CheckIfNumberIsPrime {

    public static void main(String[] args) {
        int input = 29;
        System.out.println(isPrimeFirstSolution(input)); // Prime
        System.out.println(isPrimeSecondSolution(input)); // Prime
    }

    public static String isPrimeFirstSolution(int num) {
        if (num < 2) {
            return "Prime";
        }
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return "Not Prime";
            }
        }
        return "Prime";
    }

    /*
    * Return Prime using BigInteger class
    * */
    public static String isPrimeSecondSolution(int num) {
        BigInteger bigInteger = new BigInteger(String.valueOf(num));
        return bigInteger.isProbablePrime(1) ? "Prime" : "Not Prime";
    }
}
