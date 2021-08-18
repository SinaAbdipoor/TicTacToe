package main;

import java.util.ArrayList;

/**
 * This class represents the board of the Tic-Tac-Toe game.
 *
 * @author Sina
 * @version 0.1
 */
class Board {

    private final char[] board;

    /**
     * This constructor creates and initializes an empty game board with empty slots.
     */
    Board() {
        board = new char[9];
        for (int i = 0; i < board.length; i++) {
            board[i] = ' ';
        }
    }

    /**
     * Returns the current board of the game.
     *
     * @return game board.
     */
    char[] getBoard() {
        return board;
    }

    @Override
    public String toString() {
        return " " + board[0] + " | " + board[1] + " | " + board[2]
                + "\n-----------\n "
                + board[3] + " | " + board[4] + " | " + board[5]
                + "\n-----------\n "
                + board[6] + " | " + board[7] + " | " + board[8];
    }

    /**
     * Takes one of the lots as the next move and fills it with the given label.
     *
     * @param index the index of the chosen slot (0-8).
     * @param label the label of the player making this move (X or O).
     * @throws IllegalArgumentException if the chosen slot is already taken.
     */
    void chooseSlot(int index, char label) throws IllegalArgumentException {
        if (board[index] != ' ') {
            throw new IllegalArgumentException("This slot is already taken.");
        }
        board[index] = label;
    }

    /**
     * Returns the indexes of all the empty slots on the board.
     *
     * @return empty slots.
     */
    ArrayList<Integer> getEmptySlots() {
        ArrayList<Integer> slots = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            if (board[i] == ' ') {
                slots.add(i);
            }
        }
        return slots;
    }

    /**
     * Returns the current game status.
     *
     * @return -1 if the game is not over yet, 0 if it's a draw, 1 if 'X' has
     * won, and 2 if 'O' has won.
     */
    int gameStatus() {
        // Checking for a row winner.
        for (int i = 0; i < board.length; i += 3) {
            if (board[i] == board[i + 1] && board[i + 1] == board[i + 2]) {
                if (board[i] == 'X') {
                    return 1;
                }
                if (board[i] == 'O') {
                    return 2;
                }
            }
        }
        // Checking for a column winner.
        for (int i = 0; i < 3; i++) {
            if (board[i] == board[i + 3] && board[i + 3] == board[i + 6]) {
                if (board[i] == 'X') {
                    return 1;
                }
                if (board[i] == 'O') {
                    return 2;
                }
            }
        }
        // Checking for a diagonal winner.
        if ((board[0] == board[4] && board[4] == board[8])
                || (board[2] == board[4] && board[4] == board[6])) {
            if (board[4] == 'X') {
                return 1;
            }
            if (board[4] == 'O') {
                return 2;
            }
        }
        // Check to see if there is any empty slot left -> game not over.
        for (int i = 0; i < board.length; i++) {
            if (board[i] == ' ') {
                return -1;
            }
        }
        // Otherwise, it's a draw.
        return 0;
    }

    /**
     * Resets the game board by filling all the slots with ' '.
     */
    void reset() {
        for (int i = 0; i < board.length; i++) {
            board[i] = ' ';
        }
    }
}