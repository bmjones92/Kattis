import java.util.Scanner;

/**
 * Solution to the "The Easiest Problem Is This One" problem on Kattis.
 * @author Brendan Jones
 */
public class Easiest {

    /**
     * Sum the digits in a number.
     * @param number The number.
     * @return The sum of the digits.
     */
    private static int sumDigits(int number) {
        var total = 0;
        while (number != 0) {
            total += number % 10;
            number /= 10;
        }

        return total;
    }

    /**
     * Processes a single test case.
     * @param sc The input scanner.
     * @param b The output builder.
     * @return {@code true} if another test case follows this one.
     */
    private static boolean processTestCase(Scanner sc, StringBuilder b) {
        final var number = sc.nextInt();
        if (number == 0) {
            return false;
        }

        final var sumOfDigits = sumDigits(number);

        var m = 11;
        while (sumOfDigits != sumDigits(number * m)) {
            m++;
        }

        b.append(m).append('\n');

        return true;
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var b = new StringBuilder();

            while (processTestCase(sc, b));

            System.out.print(b);
        }
    }

}
