package main;

import java.util.Scanner;

/**
 * This is the main class. It prints some stuff, gets the game mode, and starts the game.
 *
 * @author Sina
 * @version 0.3
 */
public class Main {

    /**
     * This is the main method, the starting point of the project. It prints some stuff, gathers the required
     * parameters, and starts the game.
     *
     * @param args is not needed.
     */
    public static void main(String[] args) {
        // Printing the initial information about the project.
        printStuff();
        // Creating the appropriate players based on the input game mode.
        switch (getGameMode()) {
            case 1:
                System.out.println("Selected game mode: 1) Play against a friend.");
                break;
            case 2:
                System.out.println("Selected game mode: 2) Play against the stupid bot.");
                break;
            case 3:
                throw new UnsupportedOperationException("Not supported yet.");
            case 4:
                throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    /**
     * This method just prints some initial stuff.
     */
    private static void printStuff() {
        System.out.println("-----------------------------------------------------------------------------------------" +
                "----------------------------------------------------------------------------------------------------");
        System.out.println("Welcome to Tic-Tac-Toe!\n");
        System.out.println("X | O | X\n---------");
        System.out.println("  |   | O\n---------");
        System.out.println("X |   |");
        System.out.println("\nThis is a passion project done in my free time. This object-oriented java " +
                "implementation of the Tic-Tac-Toe includes different game modes and an AI bot.\nThe main purpose of " +
                "this project is to show to my SSK3101 students what can be achieved with just a bit of java " +
                "programming and AI.\nThe AI has 4 different levels of difficulty and is based on Reinforcement " +
                "Learning (RL).");
        System.out.println("\nFeel free to play around, copy, and edit this code. However, YOU ARE NOT ALLOWED TO " +
                "REUSE THIS CODE WITHOUT REFERENCE OR SUBMIT IT AS YOUR OWN.");
        System.out.println("By: Sina Abdipoor\nhttps://sites.google.com/view/sina-abdipoor");
        System.out.println("-----------------------------------------------------------------------------------------" +
                "----------------------------------------------------------------------------------------------------");
    }

    /**
     * Gets the game mode as an input from user.
     *
     * @return the game mode.
     */
    private static int getGameMode() {
        int gameMode;
        Scanner scanner = new Scanner(System.in);
        System.out.println("To start the game, please choose one of the options below:\n1) Play against a friend;" +
                "\n2) Play against the stupid bot;\n3) Play against the smart bot;\n4) Train the bot (ADMINS ONLY).");
        do {
            System.out.print("Please select the game mode (a number between 1 - 4): ");
            // Making sure the input is a number.
            while (!scanner.hasNextInt()) {
                System.out.print("That's not a number! Try again: ");
                scanner.next();
            }
            gameMode = scanner.nextInt();
            // Keep asking while the input is out of bound.
        } while (gameMode < 1 || gameMode > 4);
        return gameMode;
    }
}