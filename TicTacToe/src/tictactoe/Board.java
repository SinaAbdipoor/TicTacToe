package tictactoe;

import java.util.ArrayList;

/**
 * This class represents the Tic-Tac-Toe's game board.
 *
 * @author sinaa
 * @version 1.1
 */
class Board {

    private final char[] gameBoard;

    /**
     * This constructor creates and initializes an empty game board.
     */
    Board() {
        gameBoard = new char[9];
        for (int i = 0; i < gameBoard.length; i++) {
            gameBoard[i] = ' ';
        }
    }

    @Override
    public String toString() {
        return " " + gameBoard[0] + " | " + gameBoard[1] + " | " + gameBoard[2]
                + "\n-----------\n "
                + gameBoard[3] + " | " + gameBoard[4] + " | " + gameBoard[5]
                + "\n-----------\n "
                + gameBoard[6] + " | " + gameBoard[7] + " | " + gameBoard[8];
    }

    /**
     * Returns all the indexes of the empty slots.
     *
     * @return Empty slots indexes
     */
    ArrayList<Integer> getEmptySlots() {
        ArrayList<Integer> index = new ArrayList<>();
        for (int i = 0; i < gameBoard.length; i++) {
            if (gameBoard[i] == ' ') {
                index.add(i);
            }
        }
        return index;
    }

    /**
     * Fills one of the chosen slot (if available) with the player's label.
     *
     * @param index The index of the chosen slot
     * @param label The label of the player
     * @throws IllegalArgumentException If the slot is not empty
     */
    void chooseSlot(int index, char label) throws IllegalArgumentException {
        if (gameBoard[index] != ' ') {
            throw new IllegalArgumentException("This slot is already taken.");
        }
        gameBoard[index] = label;
    }

    /**
     * Returns the current game status.
     *
     * @return -1 if the game is not over yet, 0 if it's a draw, 1 if 'X' has
     * won, and 2 if 'O' has won
     */
    int gameStatus() {
        //Checking for a row winner
        for (int i = 0; i < gameBoard.length; i += 3) {
            if (gameBoard[i] == gameBoard[i + 1] && gameBoard[i + 1] == gameBoard[i + 2]) {
                if (gameBoard[i] == 'X') {
                    return 1;
                }
                if (gameBoard[i] == 'O') {
                    return 2;
                }
            }
        }
        //Checking for a column winner
        for (int i = 0; i < 3; i++) {
            if (gameBoard[i] == gameBoard[i + 3] && gameBoard[i + 3] == gameBoard[i + 6]) {
                if (gameBoard[i] == 'X') {
                    return 1;
                }
                if (gameBoard[i] == 'O') {
                    return 2;
                }
            }
        }
        //Checking for a diagonal winner
        if ((gameBoard[0] == gameBoard[4] && gameBoard[4] == gameBoard[8])
                || (gameBoard[6] == gameBoard[4] && gameBoard[4] == gameBoard[2])) {
            if (gameBoard[4] == 'X') {
                return 1;
            }
            if (gameBoard[4] == 'O') {
                return 2;
            }
        }
        //Check to see if there is any empty slot left -> game not over
        for (int i = 0; i < gameBoard.length; i++) {
            if (gameBoard[i] == ' ') {
                return -1;
            }
        }
        //Otherwise, it's a draw
        return 0;
    }
}
