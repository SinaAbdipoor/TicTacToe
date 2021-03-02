package tictactoe;

import java.util.Random;

/**
 * This class represents the Tic-Tac-Toe game. It implements the game with the
 * given players.
 *
 * @author sinaa
 * @version 1.0
 */
class Game {

    private final Player player1, player2;
    private final Board board;
    private int roundNo;
    private boolean turn; //If true, it's player1's turn. Otherwise, it's player2's turn

    /**
     * Initializes the game with the given players and creates an empty game
     * board.
     *
     * @param player1 Player 1 of the game
     * @param player2 Player 2 of the game
     * @throws IllegalArgumentException If both players have the same label
     */
    Game(Player player1, Player player2) throws IllegalArgumentException {
        if (player1.getLabel() == player2.getLabel()) {
            throw new IllegalArgumentException("Players have the same label.");
        }
        this.player1 = player1;
        this.player2 = player2;
        board = new Board();
        roundNo = 0;
        turn = new Random().nextBoolean();
    }

    /**
     * Returns the player 1.
     *
     * @return Player1
     */
    Player getPlayer1() {
        return player1;
    }

    /**
     * Returns the player 2.
     *
     * @return Player2
     */
    Player getPlayer2() {
        return player2;
    }

    /**
     * Returns the game board.
     *
     * @return Board
     */
    Board getBoard() {
        return board;
    }

    /**
     * Returns the current round number.
     *
     * @return Round number
     */
    int getRoundNo() {
        return roundNo;
    }

    @Override
    public String toString() {
        return "Game status: Round #" + roundNo + " _ Player1 {" + player1
                + "}, Player2 {" + player2 + '}';
    }

    Player whoseTurn() {
        turn = !turn;
        if (turn) {
            return player1;
        }
        return player2;
    }

    /**
     * Runs one full round of the game and returns the winner.
     *
     * @return The winning player, null if it's a draw
     */
    Player run() {
        System.out.println(this);
        System.out.println("Randomly choosing who should start the game...");
        while (board.gameStatus() == -1) { //While game is not over
            System.out.println(board);
            Player playingPlayer = whoseTurn();
            int playerMove = playingPlayer.getMove(board);
            System.out.println(playingPlayer.getName() + '(' + playingPlayer.getLabel()
                    + ") chose " + (playerMove + 1) + '.');
            board.chooseSlot(playerMove, playingPlayer.getLabel());
        }
        System.out.println(board);
        if (board.gameStatus() == 1) { //If 'X' is the winner, return the corresponding player
            if (player1.getLabel() == 'X') {
                return player1;
            }
            return player2;
        }
        if (board.gameStatus() == 2) { //If 'O' is the winner, return the corresponding player
            if (player1.getLabel() == 'O') {
                return player1;
            }
            return player2;
        }
        return null; //It's a draw, so return null
    }

    /**
     * Resets the game by resetting the players turn and the game board for the
     * next round to start.
     */
    void reset() {
        board.reset();
        turn = new Random().nextBoolean();
    }
}
