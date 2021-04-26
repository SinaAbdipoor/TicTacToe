package tictactoe;

import java.util.Scanner;

/**
 * This project is the implementation of Tic-Tac-Toe. It's a free software, and
 * you're allowed to use, copy, or modify it however you want, except for
 * submitting it as your own. The AI bot of this project is based on Q-Learning
 * (Reinforcement Learning).
 *
 * @author sinaa
 * @version 1.2
 */
class Main {

    public static void main(String[] args) {
        final Game game;
        final Player player1;
        final Player player2;
        printStuff();
        switch (getGameMode()) {
            case 1:
                System.out.println("Player 1:");
                player1 = new HumanPlayer(getPlayerName(), getPlayerLabel());
                System.out.println("Player 2:");
                player2 = new HumanPlayer(getPlayerName(), getOppositeLabel(player1.getLabel()));
                game = new Game(player1, player2);
                do {
                    runGame(game, true);
                } while (cont());
                System.out.println("-------------------------------------------"
                        + "----------------------------------------------------"
                        + "---------------\n" + game.summary());
                break;
            case 2:
                System.out.println("Player 1:");
                player1 = new HumanPlayer(getPlayerName(), getPlayerLabel());
                player2 = new RandomBot(getOppositeLabel(player1.getLabel()));
                System.out.println("Player 2: " + player2.getName() + '('
                        + player2.getLabel() + ')');
                game = new Game(player1, player2);
                do {
                    runGame(game, true);
                } while (cont());
                System.out.println("-------------------------------------------"
                        + "----------------------------------------------------"
                        + "---------------\n" + game.summary());
                break;
            case 3:
                throw new UnsupportedOperationException("Will be available soon.");
            case 4:
                throw new UnsupportedOperationException("Will be available soon.");
        }
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

    private static int getGameMode() {
        int gameMode;
        Scanner sc = new Scanner(System.in);
        System.out.println("To start the game, please choose one of the options"
                + " below:\n1) Play against a friend\n2) Play against the "
                + "stupid bot\n3) Play against the smart bot\n4) Train the bot "
                + "(ADMINS ONLY)");
        do {
            System.out.print("Please select the game mode: ");
            //Making sure the input is a number
            while (!sc.hasNextInt()) {
                System.out.print("That's not a number! Try again: ");
                sc.next();
            }
            gameMode = sc.nextInt();
        } while (gameMode < 1 || gameMode > 4);
        return gameMode;
    }

    private static String getPlayerName() {
        System.out.print("Please enter your name: ");
        return new Scanner(System.in).next();
    }

    private static char getPlayerLabel() {
        Scanner sc = new Scanner(System.in);
        char label;
        do {
            System.out.print("Please enter your label (X or O): ");
            label = Character.toUpperCase(sc.next().charAt(0));
        } while (label != 'X' && label != 'O');
        return label;
    }

    private static char getOppositeLabel(char label) {
        if (label == 'X') {
            return 'O';
        }
        return 'X';
    }

    private static boolean cont() {
        System.out.print("Do you wish to continue ('y', 'n'): ");
        if (new Scanner(System.in).next().equalsIgnoreCase("y")) {
            return true;
        }
        return false;
    }

    private static Player runGame(Game game, boolean printInfo) {
        System.out.println("---------------------------------------------------"
                + "-----------------------------------------------------------");
        game.reset();
        Player winner = game.run(printInfo);
        if (winner == null) {
            System.out.println("It's a draw!");
            return winner;
        }
        winner.addPoint();
        System.out.println(winner.getName() + " won this round.");
        return winner;
    }
}
