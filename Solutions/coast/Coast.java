import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Coast {

    /**
     * The bit that contains the tile's EAST flag.
     */
    private static final int MASK_EAST = (1 << 2);

    /**
     * The bit that contains the tile's SOUTH flag.
     */
    private static final int MASK_SOUTH = (1 << 3);

    /**
     * The bit that contains the tile's WEST flag.
     */
    private static final int MASK_WEST = (1 << 4);

    /**
     * The bit that contains the tile's NORTH flag.
     */
    private static final int MASK_NORTH = (1 << 5);

    /**
     * The mask for the tile's TYPE value.
     */
    private static final int MASK_TYPE = 1;

    /**
     * The mask for the tile's CHECKED flag.
     */
    private static final int MASK_CHECKED = (1 << 1);

    /**
     * The value representing the land tile type.
     */
    private static final int TYPE_LAND = 1;

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            // Read the dimensions of the map in. Note that the map is assumed to be surrounded by water, we add a
            // 1-tile border around the entire thing so land tiles on the border of the loaded map are calculated
            // correctly.
            final var numRows = sc.nextInt() + 2;
            final var numCols = sc.nextInt() + 2;

            // Read the tile types in.
            final var tiles = new int[numRows][numCols];
            for (var row = 0; row < numRows - 2; ++row) {
                final var line = sc.next();
                for (var col = 0; col < numCols - 2; ++col) {
                    tiles[row + 1][col + 1] = line.charAt(col) - '0';
                }
            }

            var coastLength = 0L;

            // Check the northern and southern borders.
            for (var col = 0; col < numCols; ++col) {
                coastLength += checkTiles(tiles, numCols, numRows, col, 0);
                coastLength += checkTiles(tiles, numCols, numRows, col, numRows - 1);
            }

            // Check the eastern and western borders.
            for (var row = 0; row < numRows; ++row) {
                coastLength += checkTiles(tiles, numCols, numRows, 0, row);
                coastLength += checkTiles(tiles, numCols, numRows, numCols - 1, row);
            }

            System.out.println(coastLength);
        }
    }

    private static long checkTiles(int[][] tiles, int numCols, int numRows, int startCol, int startRow) {
        // Mask has already been processed.
        if ((tiles[startRow][startCol] & MASK_CHECKED) == MASK_CHECKED) {
            return 0L;
        }

        // Tile is a land tile.
        if ((tiles[startRow][startCol] & MASK_TYPE) == TYPE_LAND) {
            return 0L;
        }

        // Initialize the queue with the starting tile.
        final var queue = new LinkedList<Point>();
        queue.add(new Point(startCol, startRow));

        var coastLength = 0L;

        while (!queue.isEmpty()) {
            final var pos = queue.poll();

            // Check the neighbor to the WEST.
            if (pos.x > 0) {
                var neighbor = tiles[pos.y][pos.x - 1];

                if ((neighbor & MASK_TYPE) == TYPE_LAND) {
                    //Set the edge bit and increment the coast length.
                    if ((neighbor & MASK_EAST) != MASK_EAST) {
                        neighbor |= MASK_EAST;
                        ++coastLength;
                    }
                } else {
                    // Mark the water tile as checked and enqueue it.
                    if ((neighbor & MASK_CHECKED) != MASK_CHECKED) {
                        neighbor |= MASK_CHECKED;
                        queue.add(new Point(pos.x - 1, pos.y));
                    }
                }

                // Update the neighbor tile's mask.
                tiles[pos.y][pos.x - 1] = neighbor;
            }

            // Check the neighbor to the EAST.
            if (pos.x < numCols - 1) {
                var neighbor = tiles[pos.y][pos.x + 1];

                if ((neighbor & MASK_TYPE) == TYPE_LAND) {
                    // Set the edge bit and increment the coast length.
                    if ((neighbor & MASK_WEST) != MASK_WEST) {
                        neighbor |= MASK_WEST;
                        ++coastLength;
                    }
                } else {
                    // Mark the water tile as checked and enqueue it.
                    if ((neighbor & MASK_CHECKED) != MASK_CHECKED) {
                        neighbor |= MASK_CHECKED;
                        queue.add(new Point(pos.x + 1, pos.y));
                    }
                }

                // Update the neighbor tile's mask.
                tiles[pos.y][pos.x + 1] = neighbor;
            }

            // Check the neighbor to the NORTH.
            if (pos.y > 0) {
                var neighbor = tiles[pos.y - 1][pos.x];

                if ((neighbor & MASK_TYPE) == TYPE_LAND) {
                    // Set the edge bit and increment the coast length.
                    if((neighbor & MASK_SOUTH) != MASK_SOUTH) {
                        neighbor |= MASK_SOUTH;
                        ++coastLength;
                    }
                } else {
                    // Mark the water tile as checked and enqueue it.
                    if ((neighbor & MASK_CHECKED) != MASK_CHECKED) {
                        neighbor |= MASK_CHECKED;
                        queue.add(new Point(pos.x, pos.y - 1));
                    }
                }

                // Update the neighbor tile's mask.
                tiles[pos.y - 1][pos.x] = neighbor;
            }

            // Check the neighbor to the SOUTH.
            if (pos.y < numRows - 1) {
                var neighbor = tiles[pos.y + 1][pos.x];

                if ((neighbor & MASK_TYPE) == TYPE_LAND) {
                    // Set the edge bit and increment the coast length.
                    if ((neighbor & MASK_NORTH) != MASK_NORTH) {
                        neighbor |= MASK_NORTH;
                        ++coastLength;
                    }
                } else {
                    // Mark the water tile as checked and enqueue it.
                    if ((neighbor & MASK_CHECKED) != MASK_CHECKED) {
                        neighbor |= MASK_CHECKED;
                        queue.add(new Point(pos.x, pos.y + 1));
                    }
                }

                // Update the neighbor tile's mask.
                tiles[pos.y + 1][pos.x] = neighbor;
            }
        }

        // Return the total tile length.
        return coastLength;
    }


}

