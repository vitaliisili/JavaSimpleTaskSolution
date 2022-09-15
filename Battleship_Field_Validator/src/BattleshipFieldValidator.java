
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 *  Write a method that takes a field for well-known board game "Battleship" as an argument and returns true
 *  if it has a valid disposition of ships, false otherwise. Argument is guaranteed to be 10*10 two-dimension array.
 *  Elements in the array are numbers, 0 if the cell is free and 1 if occupied by ship.
 *  Battleship (also Battleships or Sea Battle) is a guessing game for two players.
 *  Each player has a 10x10 grid containing several "ships" and objective is to destroy enemy's forces
 *  by targetting individual cells on his field. The ship occupies one or more cells in the grid.
 *  Size and number of ships may differ from version to version.
 *  In this kata we will use Soviet/Russian version of the game.
 *  Before the game begins, players set up the board and place the ships accordingly to the following rules:
 *  There must be single battleship (size of 4 cells), 2 cruisers (size 3),
 *  3 destroyers (size 2) and 4 submarines (size 1). Any additional ships are not allowed, as well as missing ships.
 *  Each ship must be a straight line, except for submarines, which are just single cell.
 *  The ship cannot overlap or be in contact with any other ship, neither by edge nor by corner
 * */
public class BattleshipFieldValidator {

    public static void main(String[] args) {
        int[][] input = {
                {1, 0, 0, 0, 0, 1, 1, 0, 0, 0},
                {1, 0, 1, 0, 0, 0, 0, 0, 1, 0},
                {1, 0, 1, 0, 1, 1, 1, 0, 1, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},};

        System.out.println(fieldValidator(input));
    }

    public static Set<String> position = new HashSet<>();
    public static int battleships = 0;
    public static int cruisers = 0;
    public static int destroyers = 0;
    public static int submarines = 0;

    public static boolean fieldValidator(int[][] field) {

        position = new HashSet<>();
        battleships = 0;
        cruisers = 0;
        destroyers = 0;
        submarines = 0;

        int countRight = 0;
        int countDown = 0;

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {

                if (position.contains(i + "" + j)) continue;

                if (field[i][j] == 1) {

                    for (int k = 0; k < 4; k++) { // check right
                        if (isBorder(i, j + k + 1, field.length)) {
                            break;
                        } else if (field[i][j + k + 1] == 0) {
                            addPosition(i, j + k + 1);
                            break;
                        } else if (position.contains(i + "" + (j + k + 1))) {
                            return false;
                        } else {
                            countRight++;
                            addPosition(i, j + k + 1);
                        }
                    }

                    for (int k = 0; k < 4; k++) { // check down
                        if (isBorder(i + k + 1, j, field.length)) {
                            break;
                        } else if (field[i + k + 1][j] == 0) {
                            addPosition(i + k + 1, j);
                            break;
                        } else if (position.contains((i + k + 1) + "" + j)) {
                            return false;
                        } else {
                            countDown++;
                            addPosition(i + k + 1, j);
                        }
                    }

                    if (!isShipValid(field, i, j, countRight, countDown)) {
                        return false;
                    }

                    addShip(countRight, countDown);
                    addPosition(i, j);
                    countRight = 0;
                    countDown = 0;

                }// end main if

            }// end second loop
        }  // end first loop

        return battleships == 1 &&
                cruisers == 2 &&
                destroyers == 3 &&
                submarines == 4;
    }

    private static boolean isShipValid(int[][] field, int i, int j, int countRight, int countDown) {
        if (countRight > countDown) {
            for (int k = 0; k <= countRight; k++) {
                if (!isCornerValid(i, j + k, field)) {
                    return false;
                }
            }
        } else {
            for (int k = 0; k < countDown; k++) {
                if (!isCornerValid(i + k, j, field)) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean isCornerValid(int i, int j, int[][] field) {

        if (!isBorder(i - 1, j - 1, field.length) && field[i - 1][j - 1] == 1) { //top left
            return false;
        }

        if (!isBorder(i + 1, j - 1, field.length) && field[i + 1][j - 1] == 1) { // bottom left
            return false;
        }

        if (!isBorder(i + 1, j + 1, field.length) && field[i + 1][j + 1] == 1) { // bottom right
            return false;
        }

        if (!isBorder(i - 1, j + 1, field.length) && field[i - 1][j + 1] == 1) { // top right
            return false;
        }

        return true;
    }

    private static void addShip(int countRight, int countDown) {
        if (countRight == 0 && countDown == 0) {
            submarines++;
        }

        if (countRight == 1 || countDown == 1) {
            destroyers++;
        }

        if (countRight == 2 || countDown == 2) {
            cruisers++;
        }

        if (countRight == 3 || countDown == 3) {
            battleships++;
        }

    }

    private static boolean isBorder(int i, int j, int arrayLength) {
        if (i < 0) {
            return true;
        }

        if (j < 0) {
            return true;
        }

        if (i >= arrayLength) {
            return true;
        }

        if (j >= arrayLength) {
            return true;
        }

        return false;
    }

    private static void addPosition(int i, int j) {
        position.add(i + "" + j);
    }

}
