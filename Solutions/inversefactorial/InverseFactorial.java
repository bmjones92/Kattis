import java.util.Scanner;

/**
 * Solution for the "Inverse Factorial" problem on Kattis.
 * @author Brendan Jones
 */
public class InverseFactorial {

    /**
     * Constant for 2 * PI.
     */
    private static final double TWO_PI = Math.PI * 2.0;

    /**
     * Gets the number of digits in a factorial using Kamenetsky's formula.
     * @param n The factorial to check.
     * @return The length of the factorial.
     */
    private static int getFactorialLength(int n) {
        if(n < 2) {
            return 1;
        }

        // Kamenetsky's Formula
        final var x = n * Math.log10(n / Math.E) + Math.log10(TWO_PI * n) / 2.0;
        return (int) (Math.floor(x) + 1.0);
    }

    /**
     * Calculates the inverse factorial for a given number.
     * @param number The number to find the inverse factorial of.
     * @return The inverse factorial.
     */
    private static int getInverseFactorialByValue(int number) {
        if (number == 1) {
            return 1;
        }

        var n = 1;
        for (var factorial = 1; factorial < number; n++) {
            factorial *= n;
        }
        return n - 1;
    }

    /**
     * Calculates the inverse factorial for a given length.
     * @param length The length of the inverse factorial to find.
     * @return The inverse factorial.
     */
    private static int getInverseFactorialByLength(int length) {
        var result = 7;
        while (getFactorialLength(result) < length) {
            result++;
        }
        return result;
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var line = sc.next();

            if (line.length() >= 4) {
                System.out.println(getInverseFactorialByLength(line.length()));
            } else {
                // Can't use length here because multiple factorials map to the same length when length < 4.
                final var number = Integer.parseInt(line);
                System.out.println(getInverseFactorialByValue(number));
            }
        }
    }

}
