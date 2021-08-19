package main;

import java.util.Random;

/**
 * This class represents a game of Tic-Tac-Toe.
 *
 * @author Sina
 * @version 1.0
 */
class Game {

    private final Player player1, player2;
    private final Board board;
    private Player turn;                                                                                                // Keeping track of whose turn is it next to play.
    private int roundNo;

    /**
     * Initializes the game with the given players and creates an empty game board.
     *
     * @param player1 Player 1 of the game.
     * @param player2 Player 2 of the game.
     * @throws IllegalArgumentException If both players have the same label.
     */
    Game(Player player1, Player player2) throws IllegalArgumentException {
        if (player1.getLabel() == player2.getLabel()) {
            throw new IllegalArgumentException("Players have the same label.");
        }
        this.player1 = player1;
        this.player2 = player2;
        board = new Board();
        randomTurn();
        roundNo = 0;
    }

    /**
     * Returns the first player.
     *
     * @return player 1.
     */
    Player getPlayer1() {
        return player1;
    }

    /**
     * Returns the second player.
     *
     * @return player 2.
     */
    Player getPlayer2() {
        return player2;
    }

    /**
     * Returns the current status of the game board.
     *
     * @return game board.
     */
    Board getBoard() {
        return board;
    }

    /**
     * Returns the player whose turn is now.
     *
     * @return player to play next.
     */
    Player getTurn() {
        return turn;
    }

    /**
     * Returns the number of rounds the game has been played.
     *
     * @return round count.
     */
    int getRoundNo() {
        return roundNo;
    }

    @Override
    public String toString() {
        return player1 + "\tRound: " + roundNo + "\t" + player2;
    }

    /**
     * Gives the turn to the next player.
     */
    private void takeTurn() {
        if (turn == player1) {
            turn = player2;
        } else {
            turn = player1;
        }
    }

    /**
     * Randomly assigns the turn to one of the players.
     */
    private void randomTurn() {
        if (new Random().nextBoolean()) {
            turn = player1;
        } else {
            turn = player2;
        }
    }

    /**
     * Returns the final results of the game.
     *
     * @return summary string.
     */
    String summary() {
        String winner;
        if (player1.getScore() > player2.getScore()) {
            winner = "So, {" + player1 + "} is the winner.";
        } else if (player1.getScore() < player2.getScore()) {
            winner = "So, {" + player2 + "} is the winner.";
        } else {
            winner = "So, it's a draw!";
        }
        return "Final results:\nTotal number of rounds played: " + roundNo + "\n" + player1 + "\n" + player2 +
                "\nNumber of draws: " + (roundNo - player1.getScore() - player2.getScore()) + "\n" + winner;
    }

    /**
     * Runs 1 full round of the game and returns the winner.
     *
     * @return winner player.
     */
    Player run() {
        roundNo++;
        board.reset();
        System.out.println("---------------------------------------------------------------------------------------\n" +
                this + "\n---------------------------------------------------------------------------------------");
        System.out.println("Randomly choosing who should start the game...");
        randomTurn();
        while (board.gameStatus() == -1) {                                                                              //While game is not over
            System.out.println(board);
            int playerMove = turn.getMove(board);
            System.out.println(turn.getName() + '(' + turn.getLabel() + ") chose " + (playerMove + 1) + '.');
            board.chooseSlot(playerMove, turn.getLabel());
            takeTurn();
        }
        System.out.println(board);
        if (board.gameStatus() == 1) {                                                                                  //If 'X' is the winner, return the corresponding player
            if (player1.getLabel() == 'X') {
                return player1;
            }
            return player2;
        }
        if (board.gameStatus() == 2) {                                                                                  //If 'O' is the winner, return the corresponding player
            if (player1.getLabel() == 'O') {
                return player1;
            }
            return player2;
        }
        return null;                                                                                                    //It's a draw, so return null
    }
}