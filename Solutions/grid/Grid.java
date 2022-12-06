import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * Solution to the "Grid" problem on Kattis.
 * @author Brendan Jones
 */
public class Grid {

    private static class Cell {

        /**
         * The value in this cell.
         */
        private final int value;

        /**
         * The x coordinate.
         */
        private final int x;

        /**
         * The y coordinate.
         */
        private final int y;

        /**
         * The shortest known distance to this cell.
         */
        private int distance = Integer.MAX_VALUE;

        Cell(int value, int x, int y) {
            this.value = value;
            this.x = x;
            this.y = y;
        }

    }

    private static final int[][] DIRS = {
        { 0, -1 },
        { 1,  0 },
        { 0,  1 },
        { -1, 0 },
    };

    /**
     * Calculates the shortest path to each of the tiles starting from the top left tile.
     * @param map The map to calculate the shortest path of.
     */
    private static void calculateShortestPath(Cell[][] map) {
        // Starting tile has distance of 0 from the start.
        map[0][0].distance = 0;

        final var stack = new ArrayDeque<Cell>();
        stack.add(map[0][0]);

        while(!stack.isEmpty()) {
            final var current = stack.poll();

            final var nextDist = current.distance + 1;
            for (final var dir : DIRS) {
                final var nX = current.x + dir[0] * current.value;
                final var nY = current.y + dir[1] * current.value;
                if (!isInBounds(map, nX, nY)) {
                    continue;
                }

                final var neighbor = map[nY][nX];
                if (neighbor.distance > nextDist) {
                    neighbor.distance = nextDist;
                    stack.add(neighbor);
                }
            }
        }
    }

    /**
     * Checks whether the coordinate is inside the bounds of the map.
     * @param map The map.
     * @param x The x coordinate.
     * @param y The y coordinate.
     * @return True if the coordinate is within the bounds of the map, otherwise false.
     */
    private static boolean isInBounds(Cell[][] map, int x, int y) {
        return x >= 0 && y >= 0 && x < map[0].length && y < map.length;
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var height = sc.nextInt();
            final var width = sc.nextInt();

            final var map = new Cell[height][width];
            for (var y = 0; y < height; ++y) {
                final var row = sc.next();
                for (var x = 0; x < width; ++x) {
                    map[y][x] = new Cell(row.charAt(x) - '0', x, y);
                }
            }
            calculateShortestPath(map);

            var dist = map[height - 1][width - 1].distance;
            if (dist == Integer.MAX_VALUE) {
                dist = -1; // Can't reach the destination.
            }

            System.out.println(dist);
        }
    }

}

