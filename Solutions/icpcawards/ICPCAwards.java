import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Solution to the "ICPC Awards" problem on Kattis.
 * @author Brendan Jones
 */
public class ICPCAwards {

    /**
     * The number of winners that can be selected.
     */
    private static final int NUM_WINNERS = 12;

    /**
     * Processes a single test case.
     * @param sc The input scanner.
     */
    private static void processTestCase(Scanner sc) {
        // Number of teams. Not used.
        sc.nextInt();

        StringBuilder b = new StringBuilder();

        final var winners = new HashSet<String>();
        while (winners.size() != NUM_WINNERS) {
            final var university = sc.next();
            final var team = sc.next();

            if (winners.add(university)) {
                b.append(university).append(' ').append(team).append('\n');
            }
        }

        System.out.println(b);
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            processTestCase(sc);
        }
    }

}
