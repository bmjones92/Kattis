import java.util.Scanner;

/**
 * Solutions to the "Sheba's Amoebas" problem on Kattis.
 * @author Brendan Jones
 */
public class Amoebas {

    /**
     * Removes an amoeba from the board.
     * @param board The board.
     * @param row The row of the target cell.
     * @param col The column of the target cell.
     */
    private static void removeAmoeba(boolean[][] board, int row, int col) {
        if (row < 0 || col < 0 || row >= board.length || col >= board[row].length || !board[row][col]) {
            return;
        }

        board[row][col] = false;

        // Flood fill and recursively remove surrounding cells belonging to the same amoeba.
        for (var dY = -1; dY <= 1; dY++) {
            for (var dX = -1; dX <= 1; dX++) {
                removeAmoeba(board, row + dY, col + dX);
            }
        }
    }

    /**
     * Process a single test case.
     * @param sc The input scanner.
     */
    private static void processTestCase(Scanner sc) {
        final var numRows = sc.nextInt();
        final var numCols = sc.nextInt();

        final var board = new boolean[numRows][numCols];
        for (var row = 0; row < numRows; row++) {
            final var line = sc.next();
            for (var col = 0; col < numCols; col++) {
                board[row][col] = line.charAt(col) == '#';
            }
        }

        var numAmoebas = 0;
        for (var row = 0; row < numRows; row++) {
            for (var col = 0; col < numCols; col++) {
                if (board[row][col]) {
                    removeAmoeba(board, row, col);
                    numAmoebas++;
                }
            }
        }

        System.out.println(numAmoebas);
    }

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            processTestCase(sc);
        }
    }

}