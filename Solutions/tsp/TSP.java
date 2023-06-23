import java.util.Scanner;

/**
 * Solution to the "Travelling Salesperson 2D" problem on Kattis.
 * @author Brendan Jones
 */
public class TSP {

    /**
     * Represents a destination.
     */
    private static class Destination {

        /**
         * The x coordinate.
         */
        private final float x;

        /**
         * The y coordinate.
         */
        private final float y;

        /**
         * Whether the destination has been visited.
         */
        private boolean visited = false;

        /**
         * The destination index.
         */
        private int index = 0;

        /**
         * Creates a new Destination.
         * @param x The x coordinate.
         * @param y The y coordinate.
         */
        private Destination(float x, float y) {
            this.x = x;
            this.y = y;
        }

        private float distance(Destination dest) {
            final var dX = (x - dest.x);
            final var dY = (y - dest.y);
            return dX * dX + dY * dY;
        }

    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var numDestinations = sc.nextInt();

            final var destinations = new Destination[numDestinations];
            for (var i = 0; i < numDestinations; i++) {
                destinations[i] = new Destination(sc.nextFloat(), sc.nextFloat());
            }

            destinations[0].index = 0;
            destinations[0].visited = true;

            for (var i = 1; i < destinations.length; ++i) {
                final var tour = destinations[i - 1].index;

                var bestIndex = -1;
                var bestDistance = Float.MAX_VALUE;
                for (var j = 0; j < destinations.length; ++j) {
                    if (!destinations[j].visited) {
                        final var distance = destinations[tour].distance(destinations[j]);
                        if (bestIndex == -1 || distance < bestDistance) {
                            bestIndex = j;
                            bestDistance = distance;
                        }
                    }
                }

                destinations[i].index = bestIndex;
                destinations[bestIndex].visited = true;
            }

            final var b = new StringBuilder();
            for (final var destination : destinations) {
                b.append(destination.index).append('\n');
            }

            System.out.print(b);
        }
    }

}
