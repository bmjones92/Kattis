import java.util.Scanner;

/**
 * Solution to the "Peg" problem on Kattis.
 * @author Brendan Jones
 */
public class Peg {

    /**
     * The size of the board.
     */
    private static final int BOARD_SIZE = 7;

    /**
     * Deltas for each of the four cardinal directions.
     */
    private static final int[][] DIRECTIONS = {
            {  1,  0 }, // Right
            { -1,  0 }, // Left
            {  0,  1 }, // Down
            {  0, -1 }  // Up
    };

    private enum TileType {
        Invalid, Piece, Empty
    }

    private static boolean isValid(int col, int row) {
        return (col >= 0 && row >= 0 && col < BOARD_SIZE && row < BOARD_SIZE);
    }

    private static boolean checkMove(TileType[][] board, int col, int row, int dX, int dY) {
        // Move is out of bounds.
        if (!isValid(col + (2 * dX), row + (2 * dY))) {
            return false;
        }

        for (var i = 0; i < 2; ++i) {
            col += dX;
            row += dY;
            if (board[row][col] != TileType.Piece) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var board = new TileType[BOARD_SIZE][BOARD_SIZE];

            // Load the board state.
            for (var row = 0; row < BOARD_SIZE; ++row) {
                final var line = sc.nextLine();
                for (var col = 0; col < BOARD_SIZE; ++col) {
                    final var ch = line.charAt(col);
                    switch (ch) {
                        case ' ':
                            board[row][col] = TileType.Invalid;
                            break;
                        case 'o':
                            board[row][col] = TileType.Piece;
                            break;
                        case '.':
                            board[row][col] = TileType.Empty;
                            break;
                    }
                }
            }

            var totalMoves = 0;

            // Check for all moves.
            for (var row = 0; row < BOARD_SIZE; ++row) {
                for (var col = 0; col < BOARD_SIZE; ++col) {
                    if (board[row][col] != TileType.Empty) {
                        continue;
                    }

                    for (final var dir : DIRECTIONS) {
                        if (checkMove(board, col, row, dir[0], dir[1])) {
                            ++totalMoves;
                        }
                    }
                }
            }

            System.out.println(totalMoves);
        }
    }

}

