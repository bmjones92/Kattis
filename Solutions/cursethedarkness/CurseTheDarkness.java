import java.util.Scanner;

/**
 * Solution to the "Curse the Darkness" problem on Kattis.
 * @author Brendan Jones
 */
public class CurseTheDarkness {

    /**
     * Processes a single test case.
     * @param sc The input scanner.
     */
    private static void processTestCase(Scanner sc) {
        final var bookX = sc.nextDouble();
        final var bookY = sc.nextDouble();

        var solutionFound = false;
        final var numCandles = sc.nextInt();
        for (var i = 0; i < numCandles; ++i) {
            final var candleX = sc.nextDouble();
            final var candleY = sc.nextDouble();

            if (solutionFound) {
                continue;
            }

            final var dX = candleX - bookX;
            final var dY = candleY - bookY;
            if (dX * dX + dY * dY < 64.0) {
                solutionFound = true;
                System.out.println("light a candle");
            }
        }

        if (!solutionFound) {
            System.out.println("curse the darkness");
        }
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var numTestCases = sc.nextInt();
            for (var i = 0; i < numTestCases; ++i) {
                processTestCase(sc);
            }
        }
    }

}

