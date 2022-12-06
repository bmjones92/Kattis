import java.util.Scanner;

/**
 * Solution to the "Bits" problem on Kattis.
 * @author Brendan Jones
 */
public class Bits {

    /**
     * Processes a single test case.
     * @param sc The input scanner.
     */
    private static void processTestCase(Scanner sc) {
        var maxOneBits = 0;

        var number = sc.nextInt();
        while (number > 0) {
            var numOneBits = 0;
            for (var i = 0; i < 32; ++i) {
                if ((number & (1 << i)) != 0) {
                    ++numOneBits;
                }
            }

            if (numOneBits > maxOneBits) {
                maxOneBits = numOneBits;
            }

            number /= 10;
        }

        System.out.println(maxOneBits);
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
