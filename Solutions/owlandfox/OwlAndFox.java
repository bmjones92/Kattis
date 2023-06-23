import java.util.Scanner;

/**
 * Solution to the "The Owl and the Fox" problem on Kattis.
 * @author Brendan Jones
 */
public class OwlAndFox {

    /**
     * Process a single test case.
     * @param sc The input scanner.
     * @param b The output builder.
     */
    private static void processTestCase(Scanner sc, StringBuilder b) {
        var value = sc.nextInt();

        var position = 1;
        final var length = String.valueOf(value).length();
        for (var i = 0; i < length; ++i) {
            final var digit = (value / position) % 10;
            if (digit != 0) {
                value -= position;
                break;
            }
            position *= 10;
        }

        b.append(value).append('\n');
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var b = new StringBuilder();

            final var numTestCases = sc.nextInt();
            for (var i = 0; i < numTestCases; ++i) {
                processTestCase(sc, b);
            }

            System.out.print(b);
        }
    }

}

