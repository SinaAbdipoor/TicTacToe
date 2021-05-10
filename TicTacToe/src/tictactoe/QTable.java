package tictactoe;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class represent the q-table for the q-learning agent (refer to
 * Reinforcement Learning).
 *
 * @author sinaa
 * @version 1.0
 */
class QTable {

    private final double[][] table = new double[19683][9]; //3^9 states with 9 actions each

    /**
     * Initializes the q-table and sets 0 for all states and actions.
     */
    QTable() {
        for (int i = 0; i < 19683; i++) {
            for (int j = 0; j < 9; j++) {
                table[i][j] = 0;
            }
        }
    }

    /**
     * Returns the latest q-table
     *
     * @return Q-table
     */
    double[][] getTable() {
        return table;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 19683; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(table[i][j] + "\t");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    /**
     * Returns the row number of the q-table corresponding the current game
     * board state. It first creates a 9 digit ternary number; 0 if the slot is
     * empty, 1 if the slot is filled by the smart bot (label), and 2 if is
     * filled by the opponent. Then, transforms this number to base 10 to get
     * the row number.
     *
     * @param board The current game board
     * @param label Label of the smart bot
     * @return The row number of q-table
     */
    int getState(Board board, char label) {
        int state = 0;
        for (int i = 0; i < 9; i++) {
            if (board.getGameBoard()[i] == ' ') {
                state += 0;
            } else if (board.getGameBoard()[i] == label) {
                state += Math.pow(3, i);
            } else {
                state += (2 * Math.pow(3, i));
            }
        }
        return state;
    }

    /**
     * Saves the current q-table as a difficulty for the game.
     *
     * @param difficulty 0 -> save as a custom difficulty; 1 -> save as easy
     * difficulty; 2 -> save as normal difficulty; 3 -> save as hard difficulty;
     * 4 -> save as unbeatable difficulty
     * @throws IllegalArgumentException If the input difficulty is not between 0
     * and 4
     */
    void save(int difficulty) throws IllegalArgumentException {
        if (difficulty < 0 || difficulty > 4) {
            throw new IllegalArgumentException("Difficulty value must be between 0 and 4.");
        }
        FileWriter writer = null;
        try {
            switch (difficulty) {
                case 0:
                    writer = new FileWriter(new File("difficulty\\Custom.txt"));
                    break;
                case 1:
                    writer = new FileWriter(new File("difficulty\\Easy.txt"));
                    break;
                case 2:
                    writer = new FileWriter(new File("difficulty\\Normal.txt"));
                    break;
                case 3:
                    writer = new FileWriter(new File("difficulty\\Hard.txt"));
                    break;
                case 4:
                    writer = new FileWriter(new File("difficulty\\Unbeatable.txt"));
                    break;
            }
            for (int i = 0; i < 19683; i++) {
                for (int j = 0; j < 9; j++) {
                    writer.write(String.valueOf(table[i][j]) + "\t");
                }
                writer.write("\n");
            }
            writer.close();
        } catch (IOException ex) {
            System.err.println("ERROR in saving the difficulty.\n" + ex);
        }
    }

    /**
     * Loads the saved difficulty files in the q-table.
     *
     * @param difficulty 0 -> loads the custom difficulty; 1 -> loads the easy
     * difficulty; 2 -> loads the normal difficulty; 3 -> loads the hard
     * difficulty; 4 -> loads the unbeatable difficulty.
     * @throws IllegalArgumentException If the input difficulty is not between 0
     * and 4
     */
    void load(int difficulty) throws IllegalArgumentException {
        if (difficulty < 0 || difficulty > 4) {
            throw new IllegalArgumentException("Difficulty value must be between 0 and 4.");
        }
        Scanner reader = null;
        try {
            switch (difficulty) {
                case 0:
                    reader = new Scanner(new File("difficulty\\Custom.txt"));
                    break;
                case 1:
                    reader = new Scanner(new File("difficulty\\Easy.txt"));
                    break;
                case 2:
                    reader = new Scanner(new File("difficulty\\Normal.txt"));
                    break;
                case 3:
                    reader = new Scanner(new File("difficulty\\Hard.txt"));
                    break;
                case 4:
                    reader = new Scanner(new File("difficulty\\Unbeatable.txt"));
                    break;
            }
            for (int i = 0; i < 19683; i++) {
                for (int j = 0; j < 9; j++) {
                    table[i][j] = reader.nextDouble();
                }
            }
            reader.close();
        } catch (FileNotFoundException ex) {
            System.err.println("ERROR in loading the difficulty.\n" + ex);
        }
    }
}
