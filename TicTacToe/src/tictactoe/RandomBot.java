package tictactoe;

import java.util.Random;

/**
 * This class represent a stupid bot who plays completely randomly.
 *
 * @author sinaa
 * @version 1.0
 */
class RandomBot extends Player {

    /**
     * Constructs a random player with the provided label.
     *
     * @param label Random Bot's label
     * @throws IllegalArgumentException If the label is not 'X' or 'O'
     */
    RandomBot(char label) throws IllegalArgumentException {
        super("Random Bot", label);
    }

    @Override
    int getMove(Board board) {
        int size = board.getEmptySlots().size();
        return board.getEmptySlots().get(new Random().nextInt(size));
    }
}
