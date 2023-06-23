import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Solution to the "Text Messaging Outrage" problem on Kattis.
 * @author Brendan Jones
 */
public class TextMessaging {

    /**
     * Performs iteration over a keypad.
     */
    private static class KeyIterator {

        /**
         * The number of keys on the keypad.
         */
        private final int numKeys;

        /**
         * The current number of presses.
         */
        private int presses = 1;

        /**
         * The current key.
         */
        private int key = 0;

        /**
         * Creates a new KeyIterator.
         * @param numKeys The number of keys to iterate over.
         */
        private KeyIterator(int numKeys) {
            this.numKeys = numKeys;
        }

        /**
         * Advances to the next key. If all keys have been exhausted, then the first key will be selected and the
         * number of presses will be incremented.
         */
        private void next() {
            key++;
            if (key == numKeys) {
                presses++;
                key = 0;
            }
        }

    }

    private static void processTestCase(Scanner sc, StringBuilder b) {
        // The maximum number of letters per key. Not used.
        sc.nextInt();

        final var numKeysAvailable = sc.nextInt();
        final var numLettersInAlphabet = sc.nextInt();

        final var frequencies = new ArrayList<Integer>(numLettersInAlphabet);
        for (var i = 0; i < numLettersInAlphabet; i++) {
            frequencies.add(sc.nextInt());
        }

        // We want the most frequently used characters to take priority when being assigned to keys.
        frequencies.sort(Comparator.reverseOrder());

        // The total number of presses required to submit the message.
        var totalPresses = 0L;

        final var it = new KeyIterator(numKeysAvailable);
        for (final var frequency : frequencies) {
            totalPresses += (long) frequency * it.presses;
            it.next();
        }

        // Print the solution.
        b.append(totalPresses).append('\n');
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var b = new StringBuilder();

            final var numTestCases = sc.nextInt();
            for (var i = 0; i < numTestCases; i++) {
                b.append("Case #").append(i + 1).append(": ");
                processTestCase(sc, b);
            }

            System.out.print(b);
        }
    }

}