import java.util.Scanner;

public class TicTacToeMain {
    public static void main(String[] args) {
        System.out.println("Welcome to Tic Tac Toe Game Simulation");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to play as X or O?");
        char playerLetter = scanner.nextLine().charAt(0);
        TicTacToeGame game = new TicTacToeGame(playerLetter);
        game.displayBoard();
        game.showBoard();
        game.play();
    }
}