import java.util.Scanner;

/**
 * Solution to the "Who wins?" problem on Kattis.
 * @author Brendan Jones
 */
public class VemVinner {

    /**
     * The size of the tic-tac-toe board.
     */
    private static final int BOARD_SIZE = 3;

    /**
     * The score to give a cell with an `X`.
     */
    private static final int SCORE_X = -1;

    /**
     * The score to give a cell with an `O`.
     */
    private static final int SCORE_O = 1;

    /**
     * Converts a cell string to a numerical score.
     * @param cell The cell to convert to a score.
     * @return The score.
     */
    private static int toScore(String cell) {
        final var ch = cell.charAt(0);
        return ch == 'X' ? SCORE_X : ch == 'O' ? SCORE_O : 0;
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            // Track a "score" for every row, column, and diagonal on the board. These scores can be checked to see if
            // they form a winning set of cells.
            final var rows = new int[BOARD_SIZE];
            final var cols = new int[BOARD_SIZE];
            var majorDiagonal = 0;
            var minorDiagonal = 0;

            // Read the current state of the board.
            for (var row = 0; row < BOARD_SIZE; row++) {
                for (var col = 0; col < BOARD_SIZE; col++) {
                    final var score = toScore(sc.next());
                    rows[row] += score;
                    cols[col] += score;
                    if (row == col) {
                        majorDiagonal += score;
                    }
                    if (row + col == BOARD_SIZE - 1) {
                        minorDiagonal += score;
                    }
                }
            }

            // Find the highest and lowest scores out of all diagonals, rows, and columns.
            var minScore = Math.min(majorDiagonal, minorDiagonal);
            var maxScore = Math.max(majorDiagonal, minorDiagonal);
            for (var i = 0; i < BOARD_SIZE; i++) {
                minScore = Math.min(minScore, Math.min(rows[i], cols[i]));
                maxScore = Math.max(maxScore, Math.max(rows[i], cols[i]));
            }

            // There is guaranteed to be at most one winner per test case. The winner can be determined by checking the
            // minimum and maximum scores.
            if (minScore == SCORE_X * BOARD_SIZE) {
                System.out.println("Johan har vunnit");
            } else if (maxScore == SCORE_O * BOARD_SIZE) {
                System.out.println("Abdullah har vunnit");
            } else {
                System.out.println("ingen har vunnit");
            }
        }
    }

}
