package main;

import java.util.Random;

/**
 * This class represents a random playing bot for the Tic-Tac-Toe game.
 *
 * @author Sina
 * @version 1.0
 */
class RandomBot extends Player {

    /**
     * Creates and initializes a Tic-Tac-Toe player.
     *
     * @param label player's label (X or O).
     * @throws IllegalArgumentException if the label is not X or O.
     */
    RandomBot(char label) throws IllegalArgumentException {
        super("StupidBot", label);
    }

    @Override
    int getMove(Board board) {
        int size = board.getEmptySlots().size();
        return board.getEmptySlots().get(new Random().nextInt(size));
    }
}