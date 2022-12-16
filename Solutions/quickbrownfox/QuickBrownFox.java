import java.util.Scanner;

/**
 * Solution to the "Quick Brown Fox" problem on Kattis.
 * @author Brendan Jones
 */
public class QuickBrownFox {

    /**
     * Mask with all alphabet bits set.
     */
    private static final int PANGRAM_MASK = 0x3FFFFFF;

    /**
     * Processes a single test case.
     * @param sc The input Scanner.
     */
    private static void processTestCase(Scanner sc) {
        // Mask of all letters that were found. The Nth letter in the alphabet is mapped to the Nth bit in the mask.
        var mask = 0;

        // Read the input and populate the bitmask.
        final var line = sc.nextLine();
        for (final var ch : line.toCharArray()) {
            if (Character.isAlphabetic(ch)) {
                mask |= bit(Character.toLowerCase(ch));
            }
        }

        if (mask == PANGRAM_MASK) {
            System.out.println("pangram");
        } else {
            final var b = new StringBuilder("missing ");
            for (var ch = 'a'; ch <= 'z'; ch++) {
                if ((mask & bit(ch)) == 0) {
                    b.append(ch);
                }
            }
            System.out.println(b);
        }
    }

    /**
     * Converts a character to its corresponding bit.
     * @param ch The character.
     * @return The mask bit.
     */
    private static int bit(char ch) {
        return 1 << (ch - 'a');
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var numTestCases = sc.nextInt(); sc.nextLine();
            for (var i = 0; i < numTestCases; i++) {
                processTestCase(sc);
            }
        }
    }

}
