import java.util.Scanner;

/**
 * Solution to the "Detailed Differences" problem on Kattis.
 * @author Brendan Jones
 */
public class DetailedDifferences {

    /**
     * Processes a single test case.
     * @param sc The input scanner.
     */
    private static void processTestCase(Scanner sc) {
        final var a = sc.next();
        final var b = sc.next();

        final var sb = new StringBuilder();
        for (var i = 0; i < a.length(); ++i) {
            sb.append(a.charAt(i) == b.charAt(i) ? '.' : '*');
        }
        
        System.out.println(a);
        System.out.println(b);
        System.out.println(sb);
        System.out.println();
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

