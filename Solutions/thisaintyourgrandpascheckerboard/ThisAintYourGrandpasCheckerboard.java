import java.util.Scanner;

public class ThisAintYourGrandpasCheckerboard {

    /**
     * Checks if the board is valid.
     * @param board The board to check.
     * @return Whether the board is valid.
     */
    private static boolean isBoardValid(char[][] board) {
        for (var i = 0; i < board.length; ++i) {
            if (isLineInvalid(board, i, true) || isLineInvalid(board, i, false)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if a line is invalid.
     * @param board The board.
     * @param line The line to check.
     * @param isRow Whether we're checking a row or column.
     * @return {@code true} if the line is valid.
     */
    private static boolean isLineInvalid(char[][] board, int line, boolean isRow) {
        var row = 0;
        var col = line;
        if (isRow) {
            row = line;
            col = 0;
        }

        var lastTile = '\0';
        var consecutive = 0;
        var numWhite = 0;

        for (var i = 0; i < board.length; ++i) {
            final var current = board[row][col];
            if (current != lastTile) {
                lastTile = current;
                consecutive = 1;
            } else {
                consecutive++;
                if (consecutive >= 3) {
                    return true;
                }
            }

            if (current == 'W') {
                numWhite++;
            }

            if (isRow) {
                col++;
            } else {
                row++;
            }
        }

        return numWhite != board.length / 2;
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var size = sc.nextInt();
            final var board = new char[size][size];

            for (var i = 0; i < size; ++i) {
                final var line = sc.next();
                System.arraycopy(line.toCharArray(), 0, board[i], 0, size);
            }

            final var valid = isBoardValid(board);
            System.out.println(valid ? 1 : 0);
        }
    }

}
