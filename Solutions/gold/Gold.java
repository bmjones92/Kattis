import java.awt.Point;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Solution to the "Getting Gold" problem on Kattis.
 * @author Brendan Jones
 */
public class Gold {

    private enum Tile {
        Ground('.'),
        Wall('#'),
        Gold('G'),
        Trap('T'),
        Player('P');

        private final char ch;

        Tile(char ch) {
            this.ch = ch;
        }

        public static Tile getTile(char ch) {
            for(final var type : Tile.values()) {
                if (type.ch == ch) {
                    return type;
                }
            }
            return null;
        }
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            final var numCols = sc.nextInt();
            final var numRows = sc.nextInt();

            final var queue = new LinkedList<Point>();

            final var visited = new boolean[numRows][numCols];
            final var tiles = new Tile[numRows][numCols];
            for (var row = 0; row < numRows; ++row) {
                final var line = sc.next();
                for (var col = 0; col < numCols; ++col) {
                    tiles[row][col] = Tile.getTile(line.charAt(col));
                    if (tiles[row][col] == Tile.Player) {
                        queue.add(new Point(col, row));
                        visited[row][col] = true;
                    }
                }
            }

            var numGoldFound = 0;
            while (!queue.isEmpty()) {
                final var pos = queue.poll();

                var row = pos.y;
                var col = pos.x;

                // Tile contains gold, so pick it up.
                if (tiles[row][col] == Tile.Gold) {
                    ++numGoldFound;
                }

                // Mark the tile as "visited".
                tiles[row][col] = Tile.Wall;

                // Trap nearby, so back out.
                if (tiles[row][col - 1] == Tile.Trap || tiles[row][col + 1] == Tile.Trap || tiles[row - 1][col] == Tile.Trap || tiles[row + 1][col] == Tile.Trap) {
                    continue;
                }

                // Check the tile to the west.
                if (!visited[row][col - 1] && tiles[row][col - 1] != Tile.Wall) {
                    queue.add(new Point(col - 1, row));
                    visited[row][col - 1] = true;
                }

                // Check the tile to the east.
                if (!visited[row][col + 1] && tiles[row][col + 1] != Tile.Wall) {
                    queue.add(new Point(col + 1, row));
                    visited[row][col + 1] = true;
                }

                // Check the tile to the north.
                if (!visited[row - 1][col] && tiles[row - 1][col] != Tile.Wall) {
                    queue.add(new Point(col, row - 1));
                    visited[row - 1][col] = true;
                }

                // Check the tile to the south.
                if (!visited[row + 1][col] && tiles[row + 1][col] != Tile.Wall) {
                    queue.add(new Point(col, row + 1));
                    visited[row + 1][col] = true;
                }
            }

            System.out.println(numGoldFound);
        }
    }

}

