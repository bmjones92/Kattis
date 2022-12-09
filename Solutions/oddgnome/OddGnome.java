import java.util.Scanner;

/**
 * Solution to the "Odd Gnome" problem on Kattis.
 * @author Brendan Jones
 */
public class OddGnome {

    /**
     * Processes a single test case.
     * @param sc The input scanner.
     */
    private static void processTestCase(Scanner sc) {
        final var numGnomes = sc.nextInt();

        var lastGnome = sc.nextInt();
        for (var i = 1; i < numGnomes; ++i) {
            final var currentGnome = sc.nextInt();
            if (currentGnome != lastGnome + 1) {
                System.out.println(i + 1);
            } else {
                lastGnome = currentGnome;
            }
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

