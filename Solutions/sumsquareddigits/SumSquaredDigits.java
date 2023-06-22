import java.util.Scanner;

/**
 * Solution to the "Sum Squared Digits Function" problem on Kattis.
 * @author Brendan Jones
 */
public class SumSquaredDigits {

    /**
     * Processes a single test case.
     * @param sc The input scanner.
     * @param b The StringBuilder for outputting results.
     */
    private static void processTestCase(Scanner sc, StringBuilder b) {
        final var testNumber = sc.nextInt();

        final var base = sc.nextInt();
        var number = sc.nextLong();

        var result = 0;
        do {
            final var digit = number % base;
            number /= base;

            result += digit * digit;
        } while(number > 0L);

        b.append(testNumber).append(' ').append(result);
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var b = new StringBuilder();

            final var numTestCases = sc.nextInt();
            for (var i = 1; i <= numTestCases; ++i) {
                processTestCase(sc, b);
                b.append('\n');
            }
            System.out.print(b);
        }
    }

}

