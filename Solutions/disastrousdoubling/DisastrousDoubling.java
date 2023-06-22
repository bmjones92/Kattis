import java.math.BigInteger;
import java.util.Scanner;

/**
 * Solution to the "Disastrous Doubling" problem on Kattis.
 * @author Brendan Jones
 */
public class DisastrousDoubling {

    private static final BigInteger MOD = new BigInteger("1000000007");

    /**
     * Process a single test case.
     * @param sc The input scanner.
     */
    private static void processTestCase(Scanner sc) {
        // The number of generations the experiment will run for.
        final var numGenerations = sc.nextInt();

        // The total number of bacteria that can exist. The total number doubles with each generation.
        final var totalBacteria = BigInteger.ONE.shiftLeft(numGenerations);

        // Calculate the total number of bacteria that were used throughout the experiment.
        var totalUsed = BigInteger.ZERO;
        for (var i = 0; i < numGenerations; ++i) {
            totalUsed = totalUsed.shiftLeft(1).add(sc.nextBigInteger());
        }

        // Calculate the total number of bacteria.
        if (totalBacteria.compareTo(totalUsed) < 0) {
            System.out.println("error");
        } else {
            System.out.println(totalBacteria.subtract(totalUsed).mod(MOD));
        }
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            processTestCase(sc);
        }
    }

}
