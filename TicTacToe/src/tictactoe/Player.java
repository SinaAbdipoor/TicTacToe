package tictactoe;

/**
 * This abstract class represents a general Tic-Tac-Toe player.
 *
 * @author sinaa
 * @version 1.1
 */
abstract class Player {

    private final String name;
    private final char label; //X or O
    private int score;  //Player's score

    /**
     * This constructor creates a player with the given name and label.
     *
     * @param name Player's name
     * @param label Player's label
     * @throws IllegalArgumentException If the label is not 'X' or 'O'
     */
    Player(String name, char label) throws IllegalArgumentException {
        this.name = name;
        label = Character.toUpperCase(label);
        if (label != 'X' && label != 'O') {
            throw new IllegalArgumentException("Lable can only be 'X' or 'O'.");
        }
        this.label = label;
        score = 0;
    }

    /**
     * Returns the player's name.
     *
     * @return Player name
     */
    String getName() {
        return name;
    }

    /**
     * Returns the player's label.
     *
     * @return Player label (X or O)
     */
    char getLabel() {
        return label;
    }

    /**
     * Returns the current score of the player.
     *
     * @return Player score
     */
    int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Player{" + "name=" + name + ", label=" + label
                + ", score=" + score + '}';
    }

    /**
     * Adds one point to the player's score.
     */
    void addPoint() {
        score += 1;
    }

    /**
     * The player chooses one of the available slots and returns the index.
     *
     * @param board The current game board
     * @return The index of the chosen slot
     */
    abstract int getMove(Board board);
}
