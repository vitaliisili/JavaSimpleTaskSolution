
/*
 * Task: Check if the positive number is prime if yes return "true" if not return "false"
 * */

public class CheckIfNumberIsPrime {

    public static boolean isPrime(int num) {
        if (num < 2) {
            return true;
        }
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int primeNumber = 29;
        int notPrimeNumber = 9;
        System.out.println(isPrime(primeNumber)); // true
        System.out.println(isPrime(notPrimeNumber)); // false
    }
}
