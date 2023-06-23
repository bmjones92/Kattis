import java.util.Scanner;

/**
 * Solution to the "Train Passengers" problem on Kattis.
 * @author Brendan Jones
 */
public class TrainPassengers {

    /**
     * Processes a single test case.
     * @param sc The input scanner.
     * @param b The output builder.
     */
    private static void processTestCase(Scanner sc, StringBuilder b) {
        final var capacity = sc.nextInt();
        final var numStops = sc.nextInt();

        var currentPassengers = 0;
        for (var i = 0; i < numStops; i++) {
            final var numExited = sc.nextInt();
            final var numEntered = sc.nextInt();
            final var numWaiting = sc.nextInt();

            currentPassengers -= numExited;
            if (currentPassengers < 0) {
                b.append("impossible\n");
                return;
            }

            currentPassengers += numEntered;
            if (currentPassengers > capacity) {
                b.append("impossible\n");
                return;
            }

            if (currentPassengers < capacity && numWaiting > 0) {
                b.append("impossible\n");
                return;
            }

        }

        if (currentPassengers != 0) {
            b.append("impossible\n");
        } else {
            b.append("possible\n");
        }
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var b = new StringBuilder();
            processTestCase(sc, b);
            System.out.print(b);
        }
    }

}
