import java.util.Scanner;

/**
 * Solution to the "Treasure Hunt" problem on Kattis.
 * @author Brendan Jones
 */
public class TreasureHunt {

    /**
     * The tile marker for treasure.
     */
    private static final char TILE_TREASURE = 'T';

    /**
     * The tile marker for North.
     */
    private static final char TILE_NORTH = 'N';

    /**
     * The tile marker for East.
     */
    private static final char TILE_EAST = 'E';

    /**
     * The tile marker for South.
     */
    private static final char TILE_SOUTH = 'S';

    /**
     * The tile marker for West.
     */
    private static final char TILE_WEST = 'W';

    /**
     * Processes a single test case.
     * @param sc The input scanner.
     */
    private static void processTestCase(Scanner sc) {
        final var numRows = sc.nextInt();
        final var numCols = sc.nextInt();

        final var map = new char[numRows][numCols];
        for (var row = 0; row < numRows; ++row) {
            final var line = sc.next();
            System.arraycopy(line.toCharArray(), 0, map[row], 0, line.length());
        }

        final var result = searchForTreasure(map, numRows, numCols);
        System.out.println(result);
    }

    /**
     * Searches the map for treasure.
     * @param map The map to search.
     * @param numRows The number of rows in the map.
     * @param numCols The number of columns in the map.
     * @return
     */
    private static String searchForTreasure(char[][] map, int numRows, int numCols) {
        var col = 0;
        var row = 0;

        final var searched = new boolean[numRows][numCols];
        searched[col][row] = true;

        var numMoves = 0;
        while (map[row][col] != TILE_TREASURE) {
            switch(map[row][col]) {
                case TILE_NORTH:
                    row--;
                    break;
                case TILE_EAST:
                    col++;
                    break;
                case TILE_SOUTH:
                    row++;
                    break;
                case TILE_WEST:
                    col--;
                    break;
            }
            numMoves++;

            // Out of bounds.
            if (col < 0 || row < 0 || col >= numCols || row >= numRows) {
                return "Out";
            }

            // Tile has already been searched.
            if (searched[row][col]) {
                return "Lost";
            }

            // Mark current tile as searched.
            searched[row][col] = true;
        }

        return String.valueOf(numMoves);
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            processTestCase(sc);
        }
    }

}

