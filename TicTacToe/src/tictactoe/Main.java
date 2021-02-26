package tictactoe;

/**
 * This is the main class where everything starts. It prints a few stuff and
 * then starts the game.
 *
 * @author sinaa
 * @version 1.0
 */
class Main {

    public static void main(String[] args) {
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
