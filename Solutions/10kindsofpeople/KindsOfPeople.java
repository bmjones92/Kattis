import java.util.Scanner;
import java.util.Stack;
import java.util.function.Consumer;

import static java.util.Objects.requireNonNull;

/**
 * Solution for the "10 Kinds of People" problem on Kattis.
 * @author Brendan Jones
 */
public class KindsOfPeople {

    /**
     * Represents a position of a Cell on the Board.
     */
    private static class Position {

        /**
         * The column.
         */
        private final int col;

        /**
         * The row.
         */
        private final int row;

        /**
         * Creates a new Position instance.
         * @param col The column.
         * @param row The row.
         */
        private Position(int col, int row) {
            this.col = col;
            this.row = row;
        }

        /**
         * Generates a new coordinate by moving this coordinate by the specified amount.
         * @param deltaCol How far to move the column.
         * @param deltaRow How far to move the row.
         * @return The new coordinate.
         */
        public Position move(int deltaCol, int deltaRow) {
            return new Position(col + deltaCol, row + deltaRow);
        }

        /**
         * Reads a Position from a Scanner.
         * @param sc The Scanner.
         * @return The newly read Position.
         */
        public static Position from(Scanner sc) {
            final var row = sc.nextInt() - 1;
            final var col = sc.nextInt() - 1;
            return new Position(col, row);
        }

    }

    /**
     * Represents a cell on the Board.
     */
    private static class Cell {

        /**
         * The position on the Board.
         */
        private final Position pos;

        /**
         * Whether is a "Decimal" or "Binary" cell.
         */
        private final boolean isDecimal;

        /**
         * This Cell's region. A value of 0 indicates the region is unknown and must be calculated.
         */
        private int region = 0;

        /**
         * Creates a new Cell instance.
         * @param pos The position on the Board.
         * @param isDecimal Whether this is a "Decimal" or "Binary" cell.
         */
        private Cell(Position pos, boolean isDecimal) {
            this.pos = requireNonNull(pos);
            this.isDecimal = isDecimal;
        }

        /**
         * Gets whether the region is known.
         * @return Whether the region is known.
         */
        private boolean isRegionUnknown() {
            return region == 0;
        }

    }

    /**
     * Represents a grid of cells that can be flooded.
     */
    private static class Board {

        /**
         * The number of rows on the board.
         */
        private final int numRows;

        /**
         * The number of columns on the board.
         */
        private final int numCols;

        /**
         * The cells that make up the board.
         */
        private final Cell[][] cells;

        /**
         * The region to use for the next fill operation.
         */
        private int nextRegion = 1;

        /**
         * Creates a new Board instance and seeds it with data read from the Scanner.
         * @param sc The Scanner.
         */
        private Board(Scanner sc) {
            this.numRows = sc.nextInt();
            this.numCols = sc.nextInt();
            this.cells = new Cell[numRows][numCols];

            for (var row = 0; row < numRows; row++) {
                final var line = sc.next();
                for (var col = 0; col < numCols; col++) {
                    final var pos = new Position(col, row);
                    cells[row][col] = new Cell(pos,line.charAt(col) == '1');
                }
            }
        }

        /**
         * Gets the cell at the specified position.
         * @param pos The position to check.
         * @return The requested cell, or {@code null} if the position is not located on the board.
         */
        private Cell get(Position pos) {
            if (pos.col < 0 || pos.row < 0 || pos.col >= numCols || pos.row >= numRows) {
                return null;
            }
            return cells[pos.row][pos.col];
        }

        /**
         * Performs a <a href="https://en.wikipedia.org/wiki/Flood_fill">flood fill</a> on the board starting at the
         * specified position.
         * @param startPos The starting position.
         */
        private void fill(Position startPos) {
            // Keep a reference to the starting cell to quickly access its type.
            final var startCell = get(startPos);
            if (startCell == null) {
                return;
            }

            final var stack = new Stack<Cell>();

            // Attempts to flood the cell at the specified position. Cells will only be pushed to the stack if they
            // don't already have a region.
            final Consumer<Position> floodCell = pos -> {
                final var cell = get(pos);
                if (cell != null && cell.isRegionUnknown() && cell.isDecimal == startCell.isDecimal) {
                    stack.push(cell);
                    cell.region = nextRegion;
                }
            };

            // Attempt to flood the starting cell to seed the algorithm.
            floodCell.accept(startPos);

            while (!stack.isEmpty()) {
                final var cell = stack.pop();

                // Attempt to flood the four neighboring cells.
                floodCell.accept(cell.pos.move(-1, 0));
                floodCell.accept(cell.pos.move(1, 0));
                floodCell.accept(cell.pos.move(0, -1));
                floodCell.accept(cell.pos.move(0, 1));
            }

            // Region is flooded, so move on to the next one :)
            nextRegion++;
        }
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var board = new Board(sc);

            final var numTests = sc.nextInt();
            for (var i = 0; i < numTests; i++) {
                final var start = requireNonNull(board.get(Position.from(sc)));
                final var end = requireNonNull(board.get(Position.from(sc)));

                // If the types or region differ, then the points are guaranteed to be incompatible.
                if (start.isDecimal != end.isDecimal || start.region != end.region) {
                    System.out.println("neither");
                    continue;
                }

                // Only need to flood one of the points to determine if they're connected.
                if (start.isRegionUnknown()) {
                    board.fill(start.pos);
                }

                if (start.region == end.region) {
                    if (start.isDecimal) {
                        System.out.println("decimal");
                    } else {
                        System.out.println("binary");
                    }
                } else {
                    System.out.println("neither");
                }
            }
        }
    }

}
