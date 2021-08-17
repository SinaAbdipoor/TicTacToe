package main;

/**
 * This is the main class. It prints some stuff, gets the game mode, and starts the game.
 *
 * @author Sina
 * @version 0.1
 */
public class Main {

    /**
     * This is the main method, the starting point of the project. It prints some stuff, gathers the required
     * parameters, and starts the game.
     *
     * @param args is not needed.
     */
    public static void main(String[] args) {
        printStuff();
    }

    /**
     * This method just prints some initial stuff.
     */
    private static void printStuff() {
        System.out.println("-----------------------------------------------------------------------------------------" +
                "----------------------------------------------------------------------------------------------------");
        System.out.println("Welcome to Tic-Tac-Toe!");
        System.out.println("\nThis is a passion project done in my free time. This object-oriented java " +
                "implementation of the Tic-Tac-Toe includes different game modes and an AI bot.\nThe main purpose of " +
                "this project is to show to my SSK3101 students what can be achieved with just a bit of java " +
                "programming and AI.");
        System.out.println("\nFeel free to play around, copy, and edit this code. However, YOU ARE NOT ALLOWED TO " +
                "REUSE THIS CODE WITHOUT REFERENCE OR SUBMIT IT AS YOUR OWN.");
        System.out.println("By: Sina Abdipoor\nhttps://sites.google.com/view/sina-abdipoor");
        System.out.println("-----------------------------------------------------------------------------------------" +
                "----------------------------------------------------------------------------------------------------");
    }
}