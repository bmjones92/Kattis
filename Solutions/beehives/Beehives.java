import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Solution to the "Beehives" problem on Kattis.
 * @author Brendan Jones
 */
public class Beehives {

    /**
     * Represents a single beehive.
     */
    private static class Hive {

        /**
         * The x coordinate of the hive.
         */
        private double x;

        /**
         * The y coordinate of the hive.
         */
        private double y;

        /**
         * Whether the hive is sour.
         */
        private boolean isSour;

        public Hive(double x, double y) {
            this.x = x;
            this.y = y;
        }

        /**
         * Calculates the squared distance between this hive and another hive.
         * @param other The other hive.
         * @return The squared distance between the two hives.
         */
        public double distance(Hive other) {
            final var dx = x - other.x;
            final var dy = y - other.y;
            return dx * dx + dy * dy;
        }

    }

    private static boolean processTestCase(Scanner sc) {
        var sourDistance = sc.nextDouble();

        final var numHives = sc.nextInt();
        if(sourDistance == 0.0 && numHives == 0) {
            return false;
        }

        sourDistance *= sourDistance;

        final var hives = new ArrayList<Hive>();

        for(var i = 0; i < numHives; ++i) {
            final var x = sc.nextDouble();
            final var y = sc.nextDouble();
            hives.add(new Hive(x, y));
        }

        var numSour = 0;
        for (var i = 0; i < hives.size(); ++i) {
            final var hive = hives.get(i);
            for (var j = i + 1; j < hives.size(); ++j) {
                final var other = hives.get(j);
                if (hive.distance(other) <= sourDistance) {
                    if (!hive.isSour) {
                        hive.isSour = true;
                        numSour++;
                    }
                    if(!other.isSour) {
                        other.isSour = true;
                        numSour++;
                    }
                }
            }
        }

        System.out.printf("%d sour, %d sweet%n", numSour, numHives - numSour);

        return true;
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            while (processTestCase(sc));
        }
    }

}

