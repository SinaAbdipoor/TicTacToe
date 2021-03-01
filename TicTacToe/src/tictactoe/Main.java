package tictactoe;

/**
 * This project is the implementation of Tic-Tac-Toe. It's a free software, and
 * you're allowed to use, copy, or modify it however you want except for
 * submitting it as your own. The AI bot of this project is based on Q-Learning
 * (Reinforcement Learning).
 *
 * @author sinaa
 * @version 1.2
 */
class Main {

    /**
     * This is the starting point of this project. It first prints some stuff,
     * and then gathers the players and initiates the game.
     *
     * @param args No argument is needed
     */
    public static void main(String[] args) {
        throw new UnsupportedOperationException("The game is not ready yet.");
        printStuff();
    }

    private static void printStuff() {
        System.out.println("Welcome to Tic-Tac-Toe!");
        System.out.println("\t\t\t\t\tX | O | X\n\t\t\t\t\t---------");
        System.out.println("\t\t\t\t\t  |   | O\n\t\t\t\t\t---------");
        System.out.println("\t\t\t\t\tX |   |");
        System.out.println("This is a passion project done in my free time to "
                + "demonstrate the power of Java and AI to my SSK3101 students."
                + "\nFeel free to expand, edit, or use this code "
                + "EXCEPT FOR SUBMITTING IT AS YOUR ASSIGNMENT.\nEnjoy!\n------"
                + "------------------------------------------------------------"
                + "--------------------------------------------");
    }
}
