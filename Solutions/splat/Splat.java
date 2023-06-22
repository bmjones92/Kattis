import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Splat {

    /**
     * Represents a paint drop.
     */
    private static class PaintDrop {

        /**
         * The x coordinate of the origin.
         */
        private final double x;

        /**
         * The y coordinate of the origin.
         */
        private final double y;

        /**
         * The radius of the drop.
         */
        private final double radius;

        /**
         * The color of the paint.
         */
        private final String color;

        /**
         * Creates a new PaintDrop instance.
         * @param x The origin x coordinate.
         * @param y The origin y coordinate.
         * @param volume The volume of paint.
         * @param color The color of the paint.
         */
        private PaintDrop(double x, double y, double volume, String color) {
            this.x = x;
            this.y = y;
            this.radius = volume / Math.PI;
            this.color = color;
        }

        /**
         * Checks whether this paint drop contains the specified coordinate.
         * @param px The x coordinate.
         * @param py The y coordinate.
         * @return {@code true} if this drop contains the coordinate.
         */
        private boolean contains(double px, double py) {
            final var dx = px - x;
            final var dy = py - y;
            return (dx * dx + dy * dy) <= radius;
        }

    }

    /**
     * Processes a single test case.
     * @param sc The input scanner.
     */
    private static void processTestCase(Scanner sc) {
        // The number of paint drops.
        final var numDrops = sc.nextInt();

        final var drops = new ArrayList<PaintDrop>(numDrops);
        for (var i = 0; i < numDrops; ++i) {
            final var x = sc.nextDouble();
            final var y = sc.nextDouble();
            final var r = sc.nextDouble();
            final var color = sc.next();
            drops.add(new PaintDrop(x, y, r, color));
        }

        // Newer droplets should override older ones.
        Collections.reverse(drops);

        final var b = new StringBuilder();

        final var numQueries = sc.nextInt();
        for (var i = 0; i < numQueries; i++) {
            final var x = sc.nextDouble();
            final var y = sc.nextDouble();

            final var color = getColor(drops, x, y);
            b.append(color).append('\n');
        }

        System.out.println(b);
    }

    /**
     * Gets the color of the paper at the specified coordinates.
     * @param drops The paint drops that have been applied to the paper.
     * @param x The x coordinate.
     * @param y The y coordinate.
     * @return The color.
     */
    private static String getColor(List<PaintDrop> drops, double x, double y) {
        return drops.stream()
                .filter(drop -> drop.contains(x, y))
                .map(drop -> drop.color)
                .findFirst()
                .orElse("white");
    }

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            int numPaintings = sc.nextInt();
            for(int i = 0; i < numPaintings; ++i) {
                processTestCase(sc);
            }
        }
    }

}

