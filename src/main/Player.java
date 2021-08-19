package main;

/**
 * This abstract class represents a general Tic-Tac-Toe player.
 *
 * @author Sina
 * @version 1.0
 */
abstract class Player {

    private final String name;
    private final char label;
    private int score;

    /**
     * Creates and initializes a Tic-Tac-Toe player.
     *
     * @param name  player's name.
     * @param label player's label (X or O).
     * @throws IllegalArgumentException if the label is not X or O.
     */
    Player(String name, char label) throws IllegalArgumentException {
        this.name = name;
        label = Character.toUpperCase(label);
        if (label != 'X' && label != 'O') {
            throw new IllegalArgumentException("Player's label can only be 'X' or 'O'.");
        }
        this.label = label;
        score = 0;
    }

    /**
     * Returns the player's name.
     *
     * @return player's name.
     */
    String getName() {
        return name;
    }

    /**
     * Returns the player's label (X or O).
     *
     * @return player's label.
     */
    char getLabel() {
        return label;
    }

    /**
     * Returns the player's latest score.
     *
     * @return player's score.
     */
    int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return name + " (" + label + "), Score: " + score;
    }

    /**
     * Adds 1 point to the current score of the player.
     */
    void addScore() {
        score++;
    }

    /**
     * Gets the next action from the player.
     *
     * @param board the current game board.
     * @return the index of the slot chosen by the player (an integer between 0-8).
     */
    abstract int getMove(Board board);
}