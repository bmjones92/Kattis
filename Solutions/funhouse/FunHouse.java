import java.util.Scanner;

/**
 * Solution to the "Fun House" problem on Kattis.
 * @author Brendan Jones
 */
public class FunHouse {

    /**
     * Character for a wall tile.
     */
    private static final char TILE_WALL = 'x';

    /**
     * Character for a forward leaning mirror tile.
     */
    private static final char TILE_MIRROR_FWD = '/';

    /**
     * Character for a backward leaning mirror tile.
     */
    private static final char TILE_MIRROR_BCK = '\\';

    /**
     * Character for the entrance tile.
     */
    private static final char TILE_ENTRANCE = '*';

    /**
     * Character for the exit tile.
     */
    private static final char TILE_EXIT = '&';

    /**
     * Different cardinal directions.
     */
    private enum Direction {
        North(0, -1),
        East(1, 0),
        South(0, 1),
        West(-1, 0);

        private final int dX;

        private final int dY;

        Direction(int dX, int dY) {
            this.dX = dX;
            this.dY = dY;
        }

    }

    /**
     * Processes a single test case.
     * @param sc The input scanner.
     * @param id The id of the test case.
     * @return
     */
    private static boolean processTestCase(Scanner sc, int id) {
        final var numCols = sc.nextInt();
        final var numRows = sc.nextInt();

        if (numCols == 0 && numRows == 0) {
            return false;
        }

        var currentX = 0;
        var currentY = 0;
        Direction currentDir = null;

        final var room = new char[numRows][numCols];
        for (var row = 0; row < numRows; ++row) {
            final var line = sc.next();
            for (var col = 0; col < numCols; ++col) {
                final var tile = line.charAt(col);
                if (tile == TILE_ENTRANCE) {
                    currentX = col;
                    currentY = row;
                    if (col == 0) {
                        currentDir = Direction.East;
                    } else if (col == numCols - 1) {
                        currentDir = Direction.West;
                    } else if (row == 0) {
                        currentDir = Direction.South;
                    } else if (row == numRows - 1) {
                        currentDir = Direction.North;
                    }
                }
                room[row][col] = tile;
            }
        }

        for (var tile = room[currentY][currentX]; tile != TILE_WALL; tile = room[currentY][currentX]) {
            if (tile == TILE_MIRROR_FWD) {
                // Rotate the current direction counterclockwise.
                switch (currentDir) {
                    case East:
                        currentDir = Direction.North;
                        break;
                    case North:
                        currentDir = Direction.East;
                        break;
                    case South:
                        currentDir = Direction.West;
                        break;
                    case West:
                        currentDir = Direction.South;
                        break;
                }
            } else if (tile == TILE_MIRROR_BCK) {
                // Rotate the current direction clockwise.
                switch (currentDir) {
                    case East:
                        currentDir = Direction.South;
                        break;
                    case North:
                        currentDir = Direction.West;
                        break;
                    case South:
                        currentDir = Direction.East;
                        break;
                    case West:
                        currentDir = Direction.North;
                        break;
                }
            }
            currentX += currentDir.dX;
            currentY += currentDir.dY;
        }

        room[currentY][currentX] = TILE_EXIT;

        final var b = new StringBuilder("HOUSE ").append(id).append('\n');
        for (var row = 0; row < numRows; ++row) {
            for (var col = 0; col < numCols; ++col) {
                b.append(room[row][col]);
            }
            b.append('\n');
        }
        System.out.print(b);

        return true;
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            var id = 1;
            while (processTestCase(sc, id++));
        }
    }

}