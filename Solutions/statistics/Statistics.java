import java.util.Scanner;

/**
 * Solution to the "Statistics" problem on Kattis.
 * @author Brendan Jones
 */
public class Statistics {

    /**
     * Process a single test case.
     * @param sc The input scanner.
     * @param id The id of the test.
     */
    private static void processTestCase(Scanner sc, int id) {
        final var numElements = sc.nextInt();

        // Minimum and maximum values.
        var min = Integer.MAX_VALUE;
        var max = Integer.MIN_VALUE;

        for (var i = 0; i < numElements; i++) {
            var value = sc.nextInt();
            min = Math.min(min, value);
            max = Math.max(max, value);
        }

        final var range = max - min;
        System.out.printf("Case %d: %d %d %d%n", id, min, max, range);
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            var id = 1;
            while (sc.hasNextInt()) {
                processTestCase(sc, id++);
            }
        }
    }

}
