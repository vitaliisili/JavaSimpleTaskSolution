/*
 * Return random int number in custom range ex: 10 and 15 (15 not included)
 * */
public class RandomNumber {

    public static void main(String[] args) {
        System.out.println(getRandomNumberInRange(10, 15));
        System.out.println(getRandomNumberInRange(47, 58));
    }

    private static int getRandomNumberInRange(int start, int end) {
        if (start >= end) {
            throw new IllegalArgumentException("start can't be bigger than end");
        }
        return (int) (Math.random() * (end - start)) + start;
    }
}
