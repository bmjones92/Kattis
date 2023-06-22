import java.util.Scanner;

/**
 * Solution to the "Nasty Hacks" problem on Kattis.
 * @author Brendan Jones
 */
public class NastyHacks {

    /**
     * Processes a single test case.
     * @param sc The input scanner.
     */
    private static void processTestCase(Scanner sc) {
        final var revenueNone = sc.nextInt();
        final var revenueWith = sc.nextInt();
        final var advertCost = sc.nextInt();

        final var difference = revenueNone - (revenueWith - advertCost);
        if (difference < 0) {
            System.out.println("advertise");
        } else if (difference > 0) {
            System.out.println("do not advertise");
        } else {
            System.out.println("does not matter");
        }
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var numLines = sc.nextInt();
            for (var i = 0; i < numLines; ++i) {
                processTestCase(sc);
            }
        }
    }

}