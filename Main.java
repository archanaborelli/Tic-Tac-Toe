import java.util.Scanner;

public class Main {
    private char[][] board;
    private char currentPlayer;

    public  Main() {
        board = new char[3][3];
        currentPlayer = 'X';
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    private void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    private boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isWinner() {
        return checkRows() || checkColumns() || checkDiagonals();
    }

    private boolean checkRows() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != '-' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumns() {
        for (int i = 0; i < 3; i++) {
            if (board[0][i] != '-' && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonals() {
        return (board[0][0] != '-' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) ||
               (board[0][2] != '-' && board[0][2] == board[1][1] && board[1][1] == board[2][0]);
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    private boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-';
    }

    private void makeMove(int row, int col) {
        board[row][col] = currentPlayer;
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);

        while (!isBoardFull() && !isWinner()) {
            printBoard();
            System.out.println("Player " + currentPlayer + ", enter your move (row and column):");

            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (isValidMove(row, col)) {
                makeMove(row, col);
                if (isWinner()) {
                    printBoard();
                    System.out.println("Player " + currentPlayer + " wins!");
                } else {
                    switchPlayer();
                }
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }

        if (!isWinner()) {
            printBoard();
            System.out.println("It's a draw!");
        }

        scanner.close();
    }

    public static void main(String[] args) {
        Main game = new Main();
        game.play();
    }
}