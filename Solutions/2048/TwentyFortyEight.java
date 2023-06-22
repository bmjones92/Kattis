import java.util.Scanner;

/**
 * Solution to the "2048" problem on Kattis.
 * @author Brendan Jones
 */
public class TwentyFortyEight {

    /**
     * The number of rows and columns on the board.
     */
    private static final int BOARD_SIZE = 4;

    /**
     * The current board state.
     */
    private static final int[][] tiles = new int[BOARD_SIZE][BOARD_SIZE];

    /**
     * Which tiles have merged.
     */
    private static final boolean[][] merged = new boolean[BOARD_SIZE][BOARD_SIZE];

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            // Initialize the board state.
            for (var row = 0; row < BOARD_SIZE; ++row) {
                for (var col = 0; col < BOARD_SIZE; ++col) {
                    tiles[row][col] = sc.nextInt();
                }
            }

            final var direction = sc.nextInt();

            // Rotate the board to simplify the movement code.
            rotateBoard(direction);

            // Move all the tiles on the board.
            for (var row = 0; row < BOARD_SIZE; ++row) {
                for (var col = 1; col < BOARD_SIZE; ++col) {
                    if (tiles[row][col] == 0) {
                        continue;
                    }
                    moveTile(row, col);
                }
            }

            // Undo the rotation to return the board to its original orientation.
            rotateBoard((4 - direction) % 4);

            // Generate the output string.
            final var b = new StringBuilder();
            for (var row = 0; row < BOARD_SIZE; ++row) {
                for (var col = 0; col < BOARD_SIZE; ++col) {
                    b.append(tiles[row][col]).append(' ');
                }
                b.append('\n');
            }

            System.out.println(b);
        }
    }

    /**
     * Moves the tile at the specified position.
     * @param row The row.
     * @param col The column.
     */
    private static void moveTile(int row, int col) {
        for (var dest = col - 1; dest >= 0; --dest) {
            if (tiles[row][dest] == 0) {
                continue;
            }

            if (tiles[row][dest] == tiles[row][col] && !merged[row][dest]) {
                merged[row][dest] = true;
                tiles[row][dest] *= 2;
                tiles[row][col] = 0;
            } else if (dest + 1 != col) {
                tiles[row][dest + 1] = tiles[row][col];
                tiles[row][col] = 0;
            }

            return;
        }

        tiles[row][0] = tiles[row][col];
        tiles[row][col] = 0;
    }

    /**
     * Rotate the orientation of the board.
     * @param direction The direction to rotate.
     */
    private static void rotateBoard(int direction) {
        while(direction-- != 0) {
            for (var x = 0; x < BOARD_SIZE / 2; ++x) {
                for (var y = x; y < BOARD_SIZE - x - 1; ++y) {
                    final var temp = tiles[x][y];

                    tiles[x][y] = tiles[y][BOARD_SIZE-1-x];
                    tiles[y][BOARD_SIZE-1-x] = tiles[BOARD_SIZE-1-x][BOARD_SIZE-1-y];
                    tiles[BOARD_SIZE-1-x][BOARD_SIZE-1-y] = tiles[BOARD_SIZE-1-y][x];
                    tiles[BOARD_SIZE-1-y][x] = temp;
                }
            }
        }
    }

}

