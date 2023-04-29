import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class TicTacToeGame {
    private static final int BOARD_SIZE = 10;
    private char[] board;
    private char playerLetter;
    private char computerLetter;
    private Random random;

    public TicTacToeGame(char playerLetter) {
        this.board = new char[BOARD_SIZE];
        Arrays.fill(board, ' ');

        this.playerLetter = playerLetter;
        this.computerLetter = (playerLetter == 'X') ? 'O' : 'X';
        this.random = new Random();
    }

    public void displayBoard() {
        System.out.println(board[1] + " | " + board[2] + " | " + board[3]);
        System.out.println("---------");
        System.out.println(board[4] + " | " + board[5] + " | " + board[6]);
        System.out.println("---------");
        System.out.println(board[7] + " | " + board[8] + " | " + board[9]);
    }

    public boolean isCellFree(int index) {
        return board[index] == ' ';
    }

    public void makeMove(int index, char letter) {
        if (isCellFree(index)) {
            board[index] = letter;
        } else {
            System.out.println("The cell is not empty. Please choose another cell.");
        }
    }

    public void toss() {
        int tossResult = random.nextInt(2);
        String result = (tossResult == 0) ? "Heads" : "Tails";
        System.out.println("Toss result: " + result);
        if (tossResult == 0) {
            System.out.println("You play first.");
        } else {
            System.out.println("Computer plays first.");
            int computerIndex = random.nextInt(9) + 1;
            makeMove(computerIndex, computerLetter);
            System.out.println("Computer has played at cell " + computerIndex);
            displayBoard();
        }
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        char humanPlayer = 'X';
        char computerPlayer = 'O';
        char currentPlayer = (random.nextInt(2) == 0) ? humanPlayer : computerPlayer;

        while (true) {
            System.out.println("Current board:");
            displayBoard();

            if (currentPlayer == humanPlayer) {
                System.out.print("Enter your move (1-9): ");
                int move = scanner.nextInt();
                if (isValidMove(move)) {
                    board[move - 1] = humanPlayer;
                    if (hasWon(humanPlayer)) {
                        System.out.println("Congratulations! You win!");
                        break;
                    } else if (isTie()) {
                        System.out.println("It's a tie!");
                        break;
                    }
                    currentPlayer = computerPlayer;
                } else {
                    System.out.println("Invalid move, try again.");
                }
            } else {
                int move = random.nextInt(9) + 1;
                if (isValidMove(move)) {
                    board[move - 1] = computerPlayer;
                    if (hasWon(computerPlayer)) {
                        System.out.println("Sorry, you lose!");
                        break;
                    } else if (isTie()) {
                        System.out.println("It's a tie!");
                        break;
                    }
                    currentPlayer = humanPlayer;
                }
            }
        }
        scanner.close();
    }

    private boolean isValidMove(int move) {
        return move >= 1 && move <= 9 && board[move - 1] == ' ';
    }

    private boolean hasWon(char player) {
        return (board[0] == player && board[1] == player && board[2] == player) ||
                (board[3] == player && board[4] == player && board[5] == player) ||
                (board[6] == player && board[7] == player && board[8] == player) ||
                (board[0] == player && board[3] == player && board[6] == player) ||
                (board[1] == player && board[4] == player && board[7] == player) ||
                (board[2] == player && board[5] == player && board[8] == player) ||
                (board[0] == player && board[4] == player && board[8] == player) ||
                (board[2] == player && board[4] == player && board[6] == player);
    }

    private boolean isTie() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (board[i] == ' ') {
                return false;
            }
        }
        return true;
    }
}