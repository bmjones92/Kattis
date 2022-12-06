import java.util.Scanner;

/**
 * Solution to the "How Many Digits?" problem on Kattis
 * @author Brendan Jones
 */
public class HowManyDigits {

    /**
     * Constant for 2PI.
     */
    private static final double TWO_PI = Math.PI * 2.0;

    /**
     * Calculates the length of the factorial using Kamenetsky's formula
     * @param n The factorial.
     * @return The length of the factorial.
     */
    private static int getFactorialLength(int n) {
        if(n < 2) {
            return 1;
        }

        final var x = n * Math.log10(n / Math.E) + Math.log10(TWO_PI * n) / 2.0;
        return (int) (Math.floor(x) + 1.0);
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            while (sc.hasNextInt()) {
                final var number = sc.nextInt();
                System.out.println(getFactorialLength(number));
            }
        }
    }

}

