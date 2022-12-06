import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Solution to the "All Different Directions" problem on Kattis.
 * @author Brendan Jones
 */
public class AllDifferentDirections {

    /**
     * The "start" keyword indicates the initial direction being faced.
     */
    private static final String TYPE_START = "start";

    /**
     * The "turn" keyword indicates an angle to turn relative to the current direction.
     */
    private static final String TYPE_TURN = "turn";

    /**
     * The "walk" keyword indicates how far to move in the current direction.
     */
    private static final String TYPE_WALK = "walk";

    /**
     * Represents a two-dimensional point.
     */
    private static class Point {

        /**
         * The x coordinate.
         */
        private double x;

        /**
         * The y coordinate.
         */
        private double y;

        public Point() {
            this.x = 0.0;
            this.y = 0.0;
        }

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        /**
         * Gets the squared distance between this point and another point.
         * @param p The other point.
         * @return The squared distance.
         */
        public double distanceSquared(Point p) {
            return Math.pow(x - p.x, 2.0) + Math.pow(y - p.y, 2.0);
        }

    }

    /**
     * Processes a single test case.
     * @param sc The input Scanner.
     * @return Whether another test case follows this one.
     */
    private static boolean processTestCase(Scanner sc) {
        final var numInstructions = sc.nextInt();
        if (numInstructions == 0) {
            return false;
        }

        // The average of all points.
        final var average = new Point();

        // The list of positions after each instruction.
        final var results = new ArrayList<Point>();

        // Process each instruction.
        for (var i = 0; i < numInstructions; ++i) {
            final var pos = new Point(sc.nextDouble(), sc.nextDouble());

            var direction = 0.0;

            while (!sc.hasNextDouble()) {
                final var type = sc.next();
                final var amount = sc.nextDouble();

                switch (type) {
                    case TYPE_START: {
                        direction = amount;
                        break;
                    }
                    case TYPE_TURN: {
                        direction += amount;
                        break;
                    }
                    case TYPE_WALK: {
                        pos.x += Math.cos(Math.toRadians(direction)) * amount;
                        pos.y += Math.sin(Math.toRadians(direction)) * amount;
                        break;
                    }
                }
            }

            average.x += pos.x;
            average.y += pos.y;

            results.add(pos);
        }

        average.x /= results.size();
        average.y /= results.size();

        final var dist = Math.sqrt(results.stream().mapToDouble(average::distanceSquared).max().orElse(0));
        System.out.println(average.x + ' ' + average.y + ' ' + dist);

        return true;
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            while (processTestCase(sc));
        }
    }

}