
/*
 * Given a number n > 0, return n-th Fibonacci Number.
 * */
public class FibonacciSeries {

    /*
     * Fibonacci number using loop
     */
    public static long fibonacciNumberFirstSolution(int n) {
        if (n > 0 && n <= 2) {
            return 1;
        }

        long first = 0;
        long second = 1;
        long temp = 0;

        for (int i = 2; i <= n; i++) {
            temp = first + second;
            first = second;
            second = temp;
        }
        return temp;
    }

    /*
     * Fibonacci number using recursion
     */
    public static long fibonacciNumberSecondSolution(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacciNumberFirstSolution(n - 1) + fibonacciNumberSecondSolution(n - 2);
    }


    /*
     * Fibonacci number using formula "Fn = {[(√5 + 1)/2] ^ n} / √5"
     */
    public static long fibonacciNumberThirdSolution(int n) {
        double phi = (1 + Math.sqrt(5)) / 2;
        return Math.round(Math.pow(phi, n) / Math.sqrt(5));
    }

    public static void main(String[] args) {
        long firstSolution = fibonacciNumberFirstSolution(9); // 34
        System.out.println("First Solution: " + firstSolution);

        long secondSolution = fibonacciNumberSecondSolution(9); // 34
        System.out.println("Second Solution: " + secondSolution);

        long thirdSolution = fibonacciNumberThirdSolution(9); // 34
        System.out.println("Third Solution: " + thirdSolution);
    }
}
