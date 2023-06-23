import java.util.Scanner;

/**
 * Solution to the "Toilet Seats" problem on Kattis.
 * @author Brendan Jones
 */
public class Toilet {

    /**
     * Processes a single test case.
     * @param sc The input scanner.
     */
    private static void processTestCase(Scanner sc) {
        final var input = sc.next();

        var numAlwaysUp = 0;
        var numAlwaysDown = 0;
        var numPreferredState = 0;

        var lastState = input.charAt(0);
        for (var i = 1; i < input.length(); ++i) {
            final var current = input.charAt(i);

            // The last seat state is different from the preferred state.
            if(lastState != current) {
                // Only care about the initial state for the first person with always up/down.
                if (i == 1) {
                    numAlwaysUp++;
                    numAlwaysDown++;
                }

                numPreferredState++;
                lastState = current;
            }

            // If the preferred state differs from the policy, adjustments must be made.
            // Only one adjustment is necessary for the initial person, otherwise two are needed.
            if (current != 'U') {
                numAlwaysUp += (i == 1) ? 1 : 2;
            } else {
                numAlwaysDown += (i == 1) ? 1 : 2;
            }
        }

        System.out.println(numAlwaysUp);
        System.out.println(numAlwaysDown);
        System.out.println(numPreferredState);
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            processTestCase(sc);
        }
    }

}

