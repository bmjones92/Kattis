import java.util.LinkedList;
import java.util.Scanner;

/**
 * Solution to the "Wet Tiles" problem on Kattis.
 * @author Brendan Jones
 */
public class WetTiles {

    private static class Point {

        private final int x;

        private final int y;

        private Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    /**
     * Processes a single test case.
     * @param sc The input scanner.
     * @param b The output builder.
     * @return {@code true} if another test case follows this one.
     */
    private static boolean processTestCase(Scanner sc, StringBuilder b) {
        final var numCols = sc.nextInt();
        if (numCols == -1) {
            return false;
        }

        final var numRows = sc.nextInt();
        final var numMinutes = sc.nextInt();
        final var numLeaks = sc.nextInt();
        final var numWalls = sc.nextInt();

        final var tiles = new int[numRows][numCols];

        final var leaks = new LinkedList<Point>();
        for (var i = 0; i < numLeaks; i++) {
            final var leak = new Point(sc.nextInt() - 1, sc.nextInt() - 1);
            leaks.add(leak);

            tiles[leak.y][leak.x] = 1;
        }

        // Add the walls.
        for (var i = 0; i < numWalls; i++) {
            var currentX = sc.nextInt() - 1;
            var currentY = sc.nextInt() - 1;
            final var targetX = sc.nextInt() - 1;
            final var targetY = sc.nextInt() - 1;

            final var dX = Integer.signum(targetX - currentX);
            final var dY = Integer.signum(targetY - currentY);
            while (currentX != targetX || currentY != targetY) {
                tiles[currentY][currentX] = 1;
                currentX += dX;
                currentY += dY;
            }
            tiles[currentY][currentX] = 1;
        }

        // Count the number of tiles.
        var numWetTiles = numLeaks;
        for (var currentMinute = 1; currentMinute < numMinutes && !leaks.isEmpty(); currentMinute++) {
            Point leak;
            while((leak = leaks.peek()) != null && tiles[leak.y][leak.x] == currentMinute) {
                leak = leaks.poll();

                final var row = leak.y;
                final var col = leak.x;

                if (row > 0 && tiles[row - 1][col] == 0) {
                    tiles[row - 1][col] = currentMinute + 1;
                    leaks.add(new Point(col, row - 1));
                    numWetTiles++;
                }
                if (row < numRows - 1 && tiles[row + 1][col] == 0) {
                    tiles[row + 1][col] = currentMinute + 1;
                    leaks.add(new Point(col, row + 1));
                    numWetTiles++;
                }
                if (col > 0 && tiles[row][col - 1] == 0) {
                    tiles[row][col - 1] = currentMinute + 1;
                    leaks.add(new Point(col - 1, row));
                    numWetTiles++;
                }
                if (col < numCols - 1 && tiles[row][col + 1] == 0) {
                    tiles[row][col + 1] = currentMinute + 1;
                    leaks.add(new Point(col + 1, row));
                    numWetTiles++;
                }
            }
        }

        b.append(numWetTiles).append('\n');
        return true;
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var b = new StringBuilder();
            while (processTestCase(sc, b));
            System.out.print(b);
        }
    }

}

