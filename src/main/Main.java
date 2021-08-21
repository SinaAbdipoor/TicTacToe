package main;

import java.util.Scanner;

/**
 * This is the main class. It prints some stuff, gets the game mode, and starts the game.
 *
 * @author Sina
 * @version 1.0
 */
public class Main {

    /**
     * This is the main method, the starting point of the project. It prints some stuff, gathers the required
     * parameters, and starts the game.
     *
     * @param args is not needed.
     */
    public static void main(String[] args) {
        final Game game;
        // Printing the initial information about the project.
        printStuff();
        // Creating the appropriate players based on the input game mode.
        game = createGame(getGameMode());
        // Keep running the game.
        do {
            System.out.println("---------------------------------------------------------------------------------------"
                    + "----------------------------------------------------------------------------------------------");
            Player winner = game.run();
            if (winner == null) {
                System.out.println("It's a draw!");
            }
            winner.addScore();
            System.out.println(winner.getName() + " won this round.");
        } while (cont());
        System.out.println("-----------------------------------------------------------------------------------------" +
                "------------------------------------------------------------------------------------------------------"
                + "\n" + game.summary());
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
            System.out.print("Please select the game mode (a number between 1-4): ");
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

    /**
     * Creates and initiates a game with appropriate players based on the input game mode.
     *
     * @param gameMode mode of the game determining the appropriate players.
     * @return an initiated game.
     */
    private static Game createGame(int gameMode) {
        final Player player1, player2;
        switch (gameMode) {
            case 1:
                System.out.println("Selected game mode: 1) Play against a friend.");
                System.out.println("Player 1:");
                player1 = new HumanPlayer(getPlayerName(), getPlayerLabel());
                System.out.println("Player 2:");
                player2 = new HumanPlayer(getPlayerName(), getOppositeLabel(player1.getLabel()));
                break;
            case 2:
                System.out.println("Selected game mode: 2) Play against the stupid bot.");
                System.out.println("Player 1:");
                player1 = new HumanPlayer(getPlayerName(), getPlayerLabel());
                System.out.println("Player 2: StupidBot");
                player2 = new RandomBot(getOppositeLabel(player1.getLabel()));
                break;
            case 3:
                throw new UnsupportedOperationException("Not implemented yet.");
//                break;
            case 4:
                throw new UnsupportedOperationException("Not implemented yet.");
//                break;
            default:
                player1 = null;
                player2 = null;
        }
        return new Game(player1, player2);
    }

    /**
     * Gets the player's name as an input.
     *
     * @return player's name.
     */
    private static String getPlayerName() {
        System.out.print("Please enter your name: ");
        return new Scanner(System.in).next();
    }

    /**
     * Gets the player's label (X or O).
     *
     * @return player's label (X or O).
     */
    private static char getPlayerLabel() {
        Scanner sc = new Scanner(System.in);
        char label;
        do {
            System.out.print("Please enter your label (X or O): ");
            label = Character.toUpperCase(sc.next().charAt(0));
        } while (label != 'X' && label != 'O');
        return label;
    }

    /**
     * Gives the opposite label of the input label.
     *
     * @param label the input label.
     * @return X if input label is O, O if input label is X.
     */
    private static char getOppositeLabel(char label) {
        if (label == 'X') {
            return 'O';
        }
        return 'X';
    }

    /**
     * Checks to see if a new round should start.
     *
     * @return true if player wants another round and false otherwise.
     */
    private static boolean cont() {
        System.out.print("Do you wish to continue ('y', 'n'): ");
        if (new Scanner(System.in).next().equalsIgnoreCase("y")) {
            return true;
        }
        return false;
    }
}