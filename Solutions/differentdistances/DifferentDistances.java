import java.util.Scanner;

/**
 * Solution to the "Different Distances" problem on Kattis.
 * @author Brendan Jones
 */
public class DifferentDistances {

    /**
     * Processes a single test case.
     * @param sc The input scanner.
     * @return Whether another test case follows this one.
     */
    private static boolean processTestCase(Scanner sc) {
        final var x1 = sc.nextDouble();
        if (x1 == 0.0) {
            return false;
        }

        final var y1 = sc.nextDouble();
        final var x2 = sc.nextDouble();
        final var y2 = sc.nextDouble();

        final var p = sc.nextDouble();

        var result = Math.pow(Math.abs(x1 - x2), p) + Math.pow(Math.abs(y1 - y2), p);
        result = Math.pow(result, 1.0 / p);

        System.out.printf("%.10f%n", result);

        return true;
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            while (processTestCase(sc));
        }
    }

}