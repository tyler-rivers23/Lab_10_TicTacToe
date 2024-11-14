import java.util.Scanner;

public class Main {

    private static final int Row = 3;
    private static final int Col = 3;
    private static String[][] board = new String[Row][Col];
    private static final Scanner console = new Scanner(System.in);

    public static void main(String[] args) {
        boolean done = false;
        Scanner in = new Scanner(System.in);
        String player = "X";

        clearBoard();
        display();

        do {
            // Prompt player for their move
            int row, col;
            do {
                System.out.println("Getting move from " + player);
                row = SafeInput.getRangedInt(in, "Enter your row (1-3)", 1, 3) - 1;
                col = SafeInput.getRangedInt(in, "Enter your column (1-3)", 1, 3) - 1;
            } while (!isValidMove(row, col));

            // Record move and show board
            recordMove(player, row, col);
            display();

            // Check for win or tie
            if (isWin(player)) {
                System.out.println(player + " wins!");
                done = true;
            } else if (isTie()) {
                System.out.println("It's a tie!");
                done = true;
            } else {
                // Switch player
                player = player.equals("X") ? "O" : "X";
            }
        } while (!done);

        in.close();
    }

    // Clears the board by setting each cell to a space
    private static void clearBoard() {
        for (int i = 0; i < Row; i++) {
            for (int j = 0; j < Col; j++) {
                board[i][j] = " ";
            }
        }
    }

    // Displays the current state of the board
    private static void display() {
        System.out.println("  1 2 3");
        for (int i = 0; i < Row; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < Col; j++) {
                System.out.print(board[i][j]);
                if (j < Col - 1) System.out.print("|");
            }
            System.out.println();
            if (i < Row - 1) System.out.println("  -----");
        }
    }

    // Records the player's move
    private static void recordMove(String player, int row, int col) {
        board[row][col] = player;
    }

    // Checks if the move is valid (cell is empty)
    private static boolean isValidMove(int row, int col) {
        return board[row][col].equals(" ");
    }

    // Checks for any win condition for the current player
    private static boolean isWin(String player) {
        return isRowWin(player) || isColWin(player) || isDiagonalWin(player);
    }

    // Checks for a win in any row
    private static boolean isRowWin(String player) {
        for (int i = 0; i < Row; i++) {
            if (board[i][0].equals(player) && board[i][1].equals(player) && board[i][2].equals(player)) {
                return true;
            }
        }
        return false;
    }

    // Checks for a win in any column
    private static boolean isColWin(String player) {
        for (int i = 0; i < Col; i++) {
            if (board[0][i].equals(player) && board[1][i].equals(player) && board[2][i].equals(player)) {
                return true;
            }
        }
        return false;
    }

    // Checks for a win on either diagonal
    private static boolean isDiagonalWin(String player) {
        return (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)) ||
                (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player));
    }

    // Checks for a tie condition (board is full)
    private static boolean isTie() {
        for (int i = 0; i < Row; i++) {
            for (int j = 0; j < Col; j++) {
                if (board[i][j].equals(" ")) {
                    return false;
                }
            }
        }
        return true;
    }
}

