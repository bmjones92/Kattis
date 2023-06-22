import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Solution for the "Block Crusher" problem on Kattis.
 * @author Brendan Jones
 */
public class BlockCrusher {

    private enum Dir {
        North(0, -1),
        NorthEast(1, -1),
        East(1, 0),
        SouthEast(1, 1),
        South(0, 1),
        SouthWest(-1, 1),
        West(-1, 0),
        NorthWest(-1, -1);

        private final int dX;

        private final int dY;

        Dir(int dX, int dY) {
            this.dX = dX;
            this.dY = dY;
        }
    }

    private static class Block {

        private final int strength;

        private final int row;

        private final int col;

        private int cost;

        private boolean isFractured;

        private int parentRow;

        private int parentCol;

        private Block(int strength, int col, int row) {
            this.strength = strength;
            this.row = row;
            this.col = col;
            this.cost = Integer.MAX_VALUE;
            this.isFractured = false;
            this.parentRow = -1;
            this.parentCol = -1;
        }

    }

    private static boolean processTestCase(Scanner sc) {
        final var numRows = sc.nextInt();
        final var numCols = sc.nextInt();

        if (numRows == 0 && numCols == 0) {
            return false;
        }

        final var blocks = new Block[numRows][numCols];

        // Read the blocks in.
        for (var row = 0; row < numRows; ++row) {
            final var line = sc.next();
            for (var col = 0; col < numCols; ++col) {
                final var block = new Block(line.charAt(col) - '0', col, row);
                if (row == 0) {
                    block.cost = block.strength;
                }
                blocks[row][col] = block;
            }
        }

        // Run Dijkstra's algorithm starting from every block on the top row.
        for (var col = 0; col < numCols; ++col) {
            dijkstra(blocks, col);
        }

        // Find the destination block with could be reached most cheaply.
        var cheapestCol = 0;
        for (var col = 1; col < numCols; ++col) {
            if (blocks[numRows - 1][col].cost < blocks[numRows - 1][cheapestCol].cost) {
                cheapestCol = col;
            }
        }

        // Create the fracture line.
        createFractureLine(blocks, cheapestCol, numRows - 1);

        // Print the board with the fracture line.
        printBoard(blocks);

        return true;
    }

    private static void dijkstra(Block[][] blocks, int startCol) {
        final var queue = new PriorityQueue<Block>(Comparator.comparingInt(a -> a.cost));
        queue.add(blocks[0][startCol]); // Add the starting block to the queue.

        // Add all other blocks to the queue (except first and last rows).
        for (var row = 1; row < blocks.length - 1; ++row) {
            queue.addAll(Arrays.asList(blocks[row]));
        }

        while (!queue.isEmpty()) {
            final var current = queue.poll();

            for (final var dir : Dir.values()) {
                final var dest = getBlock(blocks, current.col + dir.dX, current.row + dir.dY);
                if (dest != null) {
                    final var newCost = current.cost + dest.strength;
                    if (newCost < dest.cost) {
                        final var wasRemoved = queue.remove(dest);

                        dest.cost = newCost;
                        dest.parentCol = current.col;
                        dest.parentRow = current.row;

                        // Reinsert into the priority queue if it was there previously.
                        if (wasRemoved) {
                            queue.add(dest);
                        }
                    }
                }
            }
        }
    }

    private static Block getBlock(Block[][] blocks, int col, int row) {
        // Ignore the top source blocks.
        if (row < 1 || col < 0 || row >= blocks.length || col >= blocks[row].length) {
            return null;
        }
        return blocks[row][col];
    }

    private static void createFractureLine(Block[][] blocks, int srcCol, int srcRow) {
        while (srcCol != -1 && srcRow != -1) {
            final var block = blocks[srcRow][srcCol];

            block.isFractured = true;
            srcCol = block.parentCol;
            srcRow = block.parentRow;
        }
    }

    private static void printBoard(Block[][] blocks) {
        final var b = new StringBuilder();
        for (final var row : blocks) {
            for (final var block : row) {
                if (block.isFractured) {
                    b.append(' ');
                } else {
                    b.append(block.strength);
                }
            }
            b.append('\n');
        }

        System.out.println(b);
    }

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            while (processTestCase(sc));
        }
    }

}
