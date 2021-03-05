package tictactoe;

import java.util.Scanner;

/**
 * This class represents a human player in the Tic-Tac-Toe game.
 *
 * @author sinaa
 * @version 1.0
 */
class HumanPlayer extends Player {

    /**
     * Constructs a human player with the provided name and label.
     *
     * @param name Player's name
     * @param label Player's label
     * @throws IllegalArgumentException If the label is not 'X' or 'O'
     */
    HumanPlayer(String name, char label) throws IllegalArgumentException {
        super(name, label);
    }

    @Override
    int getMove(Board board) {
        int index;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print(this.getName() + '(' + this.getLabel() + "), please"
                    + " choose one of the EMPTY slots (1-9) as your next move: ");
            //Making sure the input is a number
            while (!sc.hasNextInt()) {
                System.out.print("That's not a number! Try again: ");
                sc.next();
            }
            index = sc.nextInt() - 1;
            //Making sure the input is empty and in range
        } while (!board.getEmptySlots().contains(index));
        return index;
    }
}
