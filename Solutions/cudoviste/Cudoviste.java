import java.util.Scanner;

/**
 * Solution to the "Cudoviste" problem on Kattis.
 * @author Brendan Jones
 */
public class Cudoviste {

    /**
     * Indicates a free spot on the map.
     */
    private static final char MAP_FREE = '.';

    /**
     * Indicates are car on the map.
     */
    private static final char MAP_CAR = 'X';

    /**
     * Indicates a building on the map.
     */
    private static final char MAP_BUILDING = '#';

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var numRows = sc.nextInt();
            final var numCols = sc.nextInt();

            final var map = new char[numRows][numCols];
            for (var row = 0; row < numRows; ++row) {
                final var line = sc.next();
                for (var col = 0; col < numCols; ++col) {
                    map[row][col] = line.charAt(col);
                }
            }

            final var counts = new int[5];
            for (var row = 0; row < numRows - 1; ++row) {
                for (var col = 0; col < numCols - 1; ++col) {
                    final var crushed = getNumCrushed(row, col, map);
                    if (crushed != -1) {
                        counts[crushed]++;
                    }
                }
            }

            for (var count : counts) {
                System.out.println(count);
            }
        }
    }

    private static int getNumCrushed(int row, int col, char[][] map) {
        var numCrushed = 0;
        for (var y = row; y < row + 2; ++y) {
            for (var x = col; x < col + 2; ++x) {
                switch (map[y][x]) {
                    case MAP_FREE:
                        break;
                    case MAP_CAR:
                        ++numCrushed;
                        break;
                    case MAP_BUILDING:
                        return -1;
                }
            }
        }
        return numCrushed;
    }

}

