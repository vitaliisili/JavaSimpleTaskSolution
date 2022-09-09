/*
*  Let's play a game on an array! You're standing at index 0 of an n-element array named input.
*  From some index i (where 0 <= i < n), you can perform one of the following moves:
*  Move Backward: If cell i - 1 exists and contains a 0, you can walk back to cell i - 1.
*  Move Forward:
*  If cell i + 1 contains a zero, you can walk to cell i + 1.
*  If cell i + leap contains a zero, you can jump to cell i + leap.
*  If you're standing in cell n - 1 or the value of i + leap >= n,
*  you can walk or jump off the end of the array and win the game.
*  In other words, you can move from index i to index i + 1, i -1, or i + leap as long as the destination
*  index is a cell containing a 0. If the destination index is greater than n - 1, you win the game.
* */
public class ArrayGame {
    public static void main(String[] args) {
        //        int[] input = {0,1,0,1,0,1};
//        System.out.println(canWin(2, input)); // true

//        int[] input = {0,0,1,1,0,0,1,1,0,0};
//        System.out.println(canWin(6, input)); // false

//        int[] input = {0,0,1,1,0,0,1,1,0,0};
//        System.out.println(canWin(3, input)); // true

//        int[] input = {0,0,0,0,1,0,1,1,0,1};
//        System.out.println(canWin(3, input)); // true

//        int[] input = {0,1,0};
//        System.out.println(canWin(1, input)); // false

        int[] input = { 0, 1, 1, 0, 0, 1, 1, 0, 1 };
//        System.out.println(canWin(4, input)); // true
        System.out.println(canWin(4, input, 0)); // true
    }

    /*
    * First Solution Work fast
    * */
    public static boolean canWin(int leap, int[] game, int i) {
        if (i < 0 || game[i] == 1)
            return false;
        if (i + 1 >= game.length || i + leap >= game.length)
            return true;

        game[i] = 1; //flag

        return canWin(leap, game, i + leap)
                || canWin(leap, game, i + 1)
                || canWin(leap, game, i - 1);
    }


    /*
    *Second Solution Work slow
    * */
    public static boolean canWin(int leap, int[] game) {
        boolean win = false;
        int iteration = 0;
        int lastPosition = 0;
        int i = 0;

        while(true) {
            iteration++;

            if (iteration > 1 && (i - 1) < 0) {
                break;
            }

            if(((leap + i) >= game.length) && game[i] == 0) {
                win = true;
                break;
            }

            if (game[i + leap] == 0) {
                i = leap + i;
                continue;
            }

            if( game[i + 1] == 0 && (i + 1) > lastPosition) {
                lastPosition = i;
                i++;
                continue;
            }

            if (iteration != 1 && game[i - 1] == 0) {
                i--;
            }else if(game[i + leap] != 0){
                break;
            }
        }
        return win;
    }
}
