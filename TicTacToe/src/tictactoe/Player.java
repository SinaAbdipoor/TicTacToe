package tictactoe;

/**
 * This abstract class represents a general Tic-Tac-Toe player.
 *
 * @author sinaa
 * @version 1.0
 */
abstract class Player {

    private final String name;
    private final char label; //X or O
    private int score;  //Player's score

    /**
     * Constructor to create a player with the given name and label
     *
     * @param name Player's name
     * @param label Player's label
     * @throws IllegalArgumentException If the label is not 'X' or 'O'
     */
    Player(String name, char label) throws IllegalArgumentException {
        this.name = name;
        if (label != 'X' || label != 'O') {
            throw new IllegalArgumentException("Lable can only be 'X' or 'O'");
        }
        this.label = label;
        score = 0;
    }

    /**
     * Returns player's name
     *
     * @return Player name
     */
    String getName() {
        return name;
    }

    /**
     * Returns player's label
     *
     * @return Player label (X or O)
     */
    char getLabel() {
        return label;
    }

    /**
     * Returns the current score of the player
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
     * Adds one point to the player's score
     */
    void addPoint() {
        score += 1;
    }

    /**
     * Returns the next move made by the player based on the current game board
     *
     * @param board The current status of the game board
     * @return The chosen slot of the game board
     */
    abstract int nextMove(Board board);
}
