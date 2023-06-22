import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Solution to the "Stacking Cups" problem on Kattis.
 * @author Brendan Jones
 */
public class Cups {

    /**
     * Represents a cup.
     */
    private static class Cup {

        /**
         * The color of the cup.
         */
        private final String color;

        /**
         * The radius of the cup.
         */
        private final int radius;

        /**
         * Creates a new Cup instance.
         * @param sc The input scanner.
         */
        private Cup(Scanner sc) {
            if (sc.hasNextInt()) {
                this.radius = sc.nextInt() >> 1;
                this.color = sc.next();
            } else {
                this.color = sc.next();
                this.radius = sc.nextInt();
            }
        }

    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var cups = new TreeSet<>(Comparator.<Cup>comparingInt(c -> c.radius));

            final var numCups = sc.nextInt();
            for (var i = 0; i < numCups; ++i) {
                final var cup = new Cup(sc);
                cups.add(cup);
            }

            cups.stream()
                    .map(c -> c.color)
                    .forEach(System.out::println);
        }
    }

}
