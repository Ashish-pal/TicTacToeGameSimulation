import java.util.Arrays;
import java.util.Scanner;

public class TicTacToeGame {
    private char[] board;
    private char playerLetter;
    private char computerLetter;

    public TicTacToeGame(char playerLetter) {
        board = new char[10];
        for (int i = 1; i < board.length; i++) {
            board[i] = ' ';
        }
        this.playerLetter = playerLetter;
        this.computerLetter = (playerLetter == 'X') ? 'O' : 'X';
    }

    public void displayBoard() {
        System.out.println(board[1] + " | " + board[2] + " | " + board[3]);
        System.out.println("---------");
        System.out.println(board[4] + " | " + board[5] + " | " + board[6]);
        System.out.println("---------");
        System.out.println(board[7] + " | " + board[8] + " | " + board[9]);
    }

    public void showBoard() {
        System.out.println("Valid cells to make a move:");
        for (int i = 1; i < board.length; i++) {
            if (board[i] == ' ') {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
    public void makeMove(int index, char letter) {
        if (board[index] == ' ') {
            board[index] = letter;
        } else {
            System.out.println("The cell is not empty. Please choose another cell.");
        }
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        int index;
        do {
            System.out.println("Please enter the index to make your move (1-9):");
            index = scanner.nextInt();
        } while (index < 1 || index > 9 || board[index] != ' ');
        makeMove(index, playerLetter);
        displayBoard();
    }
}