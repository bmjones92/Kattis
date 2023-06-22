import java.util.HashSet;
import java.util.Scanner;

/**
 * Solution to the "I've Been Everywhere, Man" problem on Kattis.
 * @author Brendan Jones
 */
public class Everywhere {

    /**
     * Processes a single test case.
     * @param sc The input scanner.
     */
    private static void processTestCase(Scanner sc) {
        final var citiesVisited = new HashSet<String>();

        final var numTrips = sc.nextInt();
        for (var i = 0; i < numTrips; ++i) {
            citiesVisited.add(sc.next());
        }

        System.out.println(citiesVisited.size());
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

