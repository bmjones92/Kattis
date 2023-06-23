import java.util.*;

/**
 * Solution to the "The Maze Makers" problem on Kattis.
 * @author Brendan Jones
 */
public class MazeMakers {

    /**
     * Represents a two-dimensional coordinate.
     */
    private static class Vec2 {

        /**
         * The x coordinate.
         */
        private final int x;

        /**
         * The y coordinate.
         */
        private final int y;

        /**
         * Creates a new Vector2.
         * @param x The x coordinate.
         * @param y The y coordinate.
         */
        private Vec2(int x, int y) {
            this.x = x;
            this.y = y;
        }

        /**
         * Moves one unit in the specified direction. This will allocate a new Vec2 instance.
         * @param dir The direction to move.
         * @return The new Vec2 coordinate.
         */
        public Vec2 move(Direction dir) {
            return new Vec2(x + dir.delta.x, y + dir.delta.y);
        }

        @Override
        public int hashCode() {
            return (x << 16) | y;
        }

        @Override
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (o instanceof Vec2) {
                return hashCode() == o.hashCode();
            }
            return false;
        }
    }

    /**
     * Represents a direction.
     */
    private enum Direction {
        West(new Vec2(-1, 0)),
        South(new Vec2(0, 1)),
        East(new Vec2(1, 0)),
        North(new Vec2(0, -1));

        /**
         * The delta offset of the direction. Useful for navigating the maze.
         */
        private final Vec2 delta;

        /**
         * Creates a new Direction instance.
         * @param delta The delta offset.
         */
        Direction(Vec2 delta) {
            this.delta = delta;
        }

        /**
         * Creates a set of Directions from a mask.
         * @param mask The bitmask.
         * @return The set of directions extracted from the mask.
         */
        public static EnumSet<Direction> fromMask(int mask) {
            final var set = EnumSet.noneOf(Direction.class);

            for (final var dir : Direction.values()) {
                final var bit = 1 << dir.ordinal();
                if ((mask & bit) != 0) {
                    set.add(dir);
                }
            }
            return set;
        }

        public Direction opposite() {
            switch (this) {
                case East:
                    return West;
                case West:
                    return East;
                case North:
                    return South;
                case South:
                    return North;
                default:
                    throw new RuntimeException("Unexpected direction: " + this);
            }
        }
    }

    /**
     * Creates a new cell.
     */
    private static class Cell {

        /**
         * The cell position.
         */
        private final Vec2 position;

        /**
         * The walls of this cell.
         */
        private final EnumSet<Direction> walls;

        /**
         * Creates a new Cell instance.
         * @param position The position of the cell.
         * @param walls The bitmask of the walls.
         */
        private Cell(Vec2 position, char walls) {
            this.position = position;
            this.walls = Direction.fromMask(Integer.parseInt(String.valueOf(walls), 16));
        }

        /**
         * Checks whether the cell has the specified wall.
         * @param direction The direction of the wall.
         * @return {@code true} if the wall exists.
         */
        private boolean hasWall(Direction direction) {
            return walls.contains(direction);
        }

        @Override
        public int hashCode() {
            // This isn't semantically correct since it ignores walls. However, within the context of the problem,
            // this will always uniquely identify a cell.
            return Objects.hash(position);
        }

        @Override
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (o instanceof Cell) {
                return hashCode() == o.hashCode();
            }
            return false;
        }

    }

    /**
     * The different validation results for a maze.
     */
    private enum MazeResult {

        NoSolution("NO SOLUTION"),
        UnreachableCell("UNREACHABLE CELL"),
        MultiplePaths("MULTIPLE PATHS"),
        OK("MAZE OK");

        /**
         * The validation message.
         */
        private final String message;

        /**
         * Creates a new maze result.
         * @param message The validation message.
         */
        MazeResult(String message) {
            this.message = message;
        }
    }

    /**
     * Performs validation on a maze.
     */
    private static class MazeValidator {

        /**
         * The size of the maze.
         */
        private final Vec2 size;

        /**
         * The cells of the maze.
         */
        private final Cell[][] cells;

        /**
         * Creates a new Maze validator.
         * @param cells The maze cells.
         */
        private MazeValidator(Cell[][] cells) {
            this.size = new Vec2(cells[0].length, cells.length);
            this.cells = cells;
        }

        /**
         * Validates the maze.
         * @return The validation result.
         */
        private MazeResult validate() {
            var hasMultiplePaths = false;

            final var exits = findExits();
            final var parents = new HashMap<Cell, Cell>();

            final var start = exits.get(0);
            parents.put(start, start);

            final var stack = new Stack<Cell>();
            stack.push(start);

            while (!stack.isEmpty()) {
                final var current = stack.pop();
                for (var dir : Direction.values()) {
                    final var neighbor = getCell(current.position.move(dir));
                    if (neighbor == null) {
                        continue;
                    }

                    // Cells are separated by a wall.
                    if (current.hasWall(dir) || neighbor.hasWall(dir.opposite())) {
                        continue;
                    }

                    if (parents.containsKey(neighbor)) {
                        // Neighbor was already visited. If the parent is not the current cell
                        // then a loop exists and the maze has multiple paths.
                        hasMultiplePaths |= !parents.get(current).equals(neighbor);
                    } else {
                        // Neighbor is available to visit.
                        stack.push(neighbor);
                        parents.put(neighbor, current);
                    }
                }
            }

            if (!parents.containsKey(exits.get(1))) {
                return MazeResult.NoSolution;
            } else if (parents.size() < size.x * size.y) {
                return MazeResult.UnreachableCell;
            } else if (hasMultiplePaths) {
                return MazeResult.MultiplePaths;
            } else {
                return MazeResult.OK;
            }
        }

        /**
         * Gets the cell at the specified position.
         * @param pos The position of the cell.
         * @return The cell, or null if the position is outside the bounds of the maze.
         */
        private Cell getCell(Vec2 pos) {
            return (pos.x >= 0 && pos.x < size.x && pos.y >= 0 && pos.y < size.y) ? cells[pos.y][pos.x] : null;
        }

        /**
         * Finds the exits for the maze.
         * @return The list of exits.
         */
        private List<Cell> findExits() {
            final var exits = new ArrayList<Cell>();

            // Search that top and bottom rows for exits.
            for (var i = 0; i < size.x; i++) {
                final var northCell = cells[0][i];
                if (!northCell.hasWall(Direction.North)) {
                    exits.add(northCell);
                }
                final var southCell = cells[size.y - 1][i];
                if (!southCell.hasWall(Direction.South)) {
                    exits.add(southCell);
                }
            }

            // Search the left and right columns for exits (skips top and bottom rows).
            for (var i = 0; i < size.y; i++) {
                final var westCell = cells[i][0];
                if (!westCell.hasWall(Direction.West)) {
                    exits.add(westCell);
                }
                final var eastCell = cells[i][size.x - 1];
                if (!eastCell.hasWall(Direction.East)) {
                    exits.add(eastCell);
                }
            }

            return exits;
        }

    }

    /**
     * Processes a single test case.
     * @param sc The input scanner.
     * @param b The output builder.
     * @return {@code true} if another test case follows this one.
     */
    private static boolean processTestCase(Scanner sc, StringBuilder b) {
        final var rows = sc.nextInt();
        final var cols = sc.nextInt();
        if (rows == 0 || cols == 0) {
            return false;
        }

        final var cells = new Cell[rows][cols];
        for (var row = 0; row < rows; row++) {
            final var masks = sc.next();
            for (var col = 0; col < cols; col++) {
                cells[row][col] = new Cell(new Vec2(col, row), masks.charAt(col));
            }
        }

        final var result = new MazeValidator(cells).validate();
        b.append(result.message).append('\n');

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
