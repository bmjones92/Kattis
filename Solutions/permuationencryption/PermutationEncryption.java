import java.util.Scanner;

/**
 * Solution to the "Permutation Encryption" problem on Kattis.
 * @author Brendan Jones
 */
public class PermutationEncryption {

    /**
     * Processes a single test case.
     * @param sc The input scanner.
     * @return Whether another test case follows this one.
     */
    private static boolean processTestCase(Scanner sc) {
        final var blockSize = sc.nextInt();
        if (blockSize == 0) {
            return false;
        }

        final var shuffleOrder = new int[blockSize];
        for (var i = 0; i < blockSize; ++i) {
            shuffleOrder[i] = sc.nextInt() - 1;
        }

        sc.nextLine(); //Discard the rest of the line.

        var line = sc.nextLine();
        {
            final var padding = line.length() % blockSize;
            if (padding != 0) {
                line = line + " ".repeat(Math.max(0, blockSize - padding));
            }
        }

        final var b = new StringBuilder("'");
        for (int index = 0; index < line.length(); index += blockSize) {
            for (int shuffle : shuffleOrder) {
                b.append(line.charAt(index + shuffle));
            }
        }
        b.append("'");

        System.out.println(b);

        return true;
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            while (processTestCase(sc));
        }
    }

}