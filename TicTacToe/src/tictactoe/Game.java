package tictactoe;

import java.util.Random;

/**
 * This class represents the Tic-Tac-Toe game. It implements the game with the
 * given players.
 *
 * @author sinaa
 * @version 1.1
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
     * @param printInfo Determines if the board and game info should be printed
     * or not (set false for training. Otherwise, set true)
     * @return
     */
    Player run(boolean printInfo) {
        roundNo++;
        System.out.println(this);
        if (printInfo) {
            System.out.println("Randomly choosing who should start the game...");
        }
        while (board.gameStatus() == -1) { //While game is not over
            if (printInfo) {
                System.out.println(board);
            }
            Player playingPlayer = whoseTurn();
            int playerMove = playingPlayer.getMove(board);
            if (printInfo) {
                System.out.println(playingPlayer.getName() + '('
                        + playingPlayer.getLabel() + ") chose "
                        + (playerMove + 1) + '.');
            }
            board.chooseSlot(playerMove, playingPlayer.getLabel());
        }
        if (printInfo) {
            System.out.println(board);
        }
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

    /**
     * Returns the final results of the game.
     *
     * @return Summary string
     */
    String summary() {
        String winner;
        if (player1.getScore() > player2.getScore()) {
            winner = "So {" + player1 + "} is the winner.";
        } else if (player1.getScore() < player2.getScore()) {
            winner = "So {" + player2 + "} is the winner.";
        } else {
            winner = "So it's a draw!";
        }
        return "Final results:\nTotal number of rounds played: " + roundNo
                + "\n" + player1 + "\n" + player2 + "\nNumber of draws: "
                + (roundNo - player1.getScore() - player2.getScore()) + "\n"
                + winner;
    }
}
