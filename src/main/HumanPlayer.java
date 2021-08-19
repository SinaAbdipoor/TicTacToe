package main;

import java.util.Scanner;

/**
 * This class represents a human player playing Tic-Tac-Toe.
 *
 * @author Sina
 * @version 1.0
 */
class HumanPlayer extends Player {

    /**
     * Creates and initializes a Tic-Tac-Toe human player.
     *
     * @param name  player's name.
     * @param label player's label (X or O).
     * @throws IllegalArgumentException if the label is not X or O.
     */
    HumanPlayer(String name, char label) throws IllegalArgumentException {
        super(name, label);
    }

    @Override
    int getMove(Board board) {
        int index;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print(this.getName() + '(' + this.getLabel() + "), please choose one of the EMPTY slots (1-9) " +
                    "as your next move: ");
            // Making sure the input is a number.
            while (!scanner.hasNextInt()) {
                System.out.print("That's not a number! Try again: ");
                scanner.next();
            }
            index = scanner.nextInt() - 1;
            // Making sure the input is empty and in range.
        } while (!board.getEmptySlots().contains(index));
        return index;
    }
}