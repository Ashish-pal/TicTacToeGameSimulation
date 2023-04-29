import java.util.Arrays;

public class TicTacToeGame {
    private char[] board;
    private char playerLetter;
    private char computerLetter;

    public TicTacToeGame(char playerLetter) {
        board = new char[10];
        Arrays.fill(board, ' ');
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
}