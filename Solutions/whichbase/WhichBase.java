import java.util.Scanner;

/**
 * Solution to the "Which Base is it Anyway?" problem on Kattis.
 * @author Brendan Jones
 */
public class WhichBase {

    /**
     * Processes a single test case.
     * @param sc The input scanner.
     */
    private static void processTestCase(Scanner sc, StringBuilder b) {
        final var id = sc.nextInt();
        b.append(id).append(' ');

        final var number = sc.next();
        b.append(convertNumberBase(number, 8)).append(' ');
        b.append(convertNumberBase(number, 10)).append(' ');
        b.append(convertNumberBase(number, 16)).append('\n');
    }

    /**
     * Converts `value` to the specified `base` or `0` if the conversion is invalid.
     * @param value The value to convert.
     * @param base The base to convert the number to.
     * @return The converted number, or `0` if the number could not be converted.
     */
    private static int convertNumberBase(String value, int base) {
        try {
            return Integer.parseInt(value, base);
        } catch (NumberFormatException e) {
            return 0;
        }
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

