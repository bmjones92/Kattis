import java.util.Scanner;

/**
 * Solution to the "Jury Jeopardy" problem on Kattis.
 * @author Brendan Jones
 */
public class JuryJeopardy {

    private static final int MAX_SIZE = 100;

    private enum Direction {
        East(1, 0),
        South(0, 1),
        West(-1, 0),
        North(0, -1);

        private final int dX;
        private final int dY;

        Direction(int x, int y) {
            this.dX = x;
            this.dY = y;
        }

        /**
         * Gets the direction that is counterclockwise of this direction.
         * @return The new direction.
         */
        public Direction left() {
            switch (this) {
                case East:
                    return Direction.North;
                case North:
                    return Direction.West;
                case West:
                    return Direction.South;
                case South:
                    return Direction.East;
                default:
                    throw new RuntimeException("Unexpected direction: " + this);
            }
        }

        /**
         * Gets the direction that is clockwise of this direction.
         * @return The new direction.
         */
        public Direction right() {
            switch (this) {
                case East:
                    return Direction.South;
                case South:
                    return Direction.West;
                case West:
                    return Direction.North;
                case North:
                    return Direction.East;
                default:
                    throw new RuntimeException("Unexpected direction: " + this);
            }
        }

        /**
         * Gets the direction that is opposite this direction.
         * @return The new direction.
         */
        public Direction back() {
            switch (this) {
                case East:
                    return Direction.West;
                case South:
                    return Direction.North;
                case West:
                    return Direction.East;
                case North:
                    return Direction.South;
                default:
                    throw new RuntimeException("Unexpected direction: " + this);
            }
        }

    }

    private static void processTestCase(Scanner sc) {
        final var movements = sc.next();

        final var visited = new boolean[2 * MAX_SIZE + 1][2 * MAX_SIZE + 1];

        var minX = MAX_SIZE;
        var minY = MAX_SIZE;
        var maxX = MAX_SIZE;
        var maxY = MAX_SIZE;

        var currentX = MAX_SIZE;
        var currentY = MAX_SIZE;

        visited[currentY][currentX] = true;

        var currentDir = Direction.East;

        for (final var ch : movements.toCharArray()) {
            switch (ch) {
                case 'F':
                    break;
                case 'L':
                    currentDir = currentDir.left();
                    break;
                case 'R':
                    currentDir = currentDir.right();
                    break;
                case 'B':
                    currentDir = currentDir.back();
                    break;
            }

            // Move in the new direction.
            currentX += currentDir.dX;
            currentY += currentDir.dY;

            visited[currentY][currentX] = true;

            minX = Math.min(minX, currentX);
            maxX = Math.max(maxX, currentX);

            minY = Math.min(minY, currentY);
            maxY = Math.max(maxY, currentY);
        }

        final var b = new StringBuilder();
        b.append(maxY - minY + 3).append(' ').append(maxX - minX + 2).append('\n');
        for (var row = minY - 1; row <= maxY + 1; row++) {
            for (var col = minX; col <= maxX + 1; col++) {
                b.append(visited[row][col] ? '.' : '#');
            }
            b.append('\n');
        }

        System.out.print(b);

    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var numInputs = sc.nextInt();
            System.out.println(numInputs);
            for (var i = 0; i < numInputs; ++i) {
                processTestCase(sc);
            }
        }
    }

}

