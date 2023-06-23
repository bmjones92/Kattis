import java.util.Scanner;

/**
 * Solution to the "Tetris" problem on Kattis.
 * @author Brendan Jones
 */
public class Tetris {

    /**
     * Stores the height of the lowest block on each column in the piece at each orientation relative to the first.
     * Note: The first orientation is as depicted in the picture, and the rest of the orientations
     * are each rotated 90 degrees clockwise from the previous orientation.
     */
    private static final int[][][] PIECES = {
            // Piece 1: I
            {
                    { 0 },
                    { 0, 0, 0, 0 }
            },

            // Piece 2: O
            {
                    { 0, 0 },
            },

            // Piece 3: S
            {
                    { 0, 0, 1 },
                    { 0, -1 }
            },

            // Piece 4: Z
            {
                    { 0, -1, -1 },
                    { 0, 1 }
            },

            // Piece 5: T
            {
                    { 0, 0, 0 },
                    { 0, 1 },
                    { 0, -1, 0 },
                    { 0, -1 }
            },

            // Piece 6: L
            {
                    { 0, 0, 0 },
                    { 0, 0 },
                    { 0, 1, 1 },
                    { 0, -2 }
            },

            // Piece 7: J
            {
                    { 0, 0, 0 },
                    { 0, 2 },
                    { 0, 0, -1 },
                    { 0, 0 }
            }
    };

    private static boolean isValid(int[] columns, int[] piece, int startCol) {
        // Not enough room for the piece starting at this orientation.
        if (columns.length - startCol < piece.length) {
            return false;
        }

        final var startHeight = columns[startCol];
        for (var i = 0; i < piece.length; ++i) {
            if (columns[startCol + i] - startHeight != piece[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var columns = new int[sc.nextInt()];
            final var piece = PIECES[sc.nextInt() - 1];

            // The current height of each tile on the board.
            for (var i = 0; i < columns.length; ++i) {
                columns[i] = sc.nextInt();
            }

            var numSolutions = 0;
            for (var i = 0; i < columns.length; ++i) {
                for (final var value : piece) {
                    if (isValid(columns, value, i)) {
                        numSolutions++;
                    }
                }
            }

            System.out.println(numSolutions);
        }
    }
}