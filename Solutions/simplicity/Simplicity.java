import java.util.Arrays;
import java.util.Scanner;

/**
 * Solution to the "Simplicity" problem on Kattis.
 * @author Brendan Jones
 */
public class Simplicity {

    /**
     * The number of characters in the alphabet.
     */
    private static final int NUM_CHARS = 26;

    /**
     * The maximum allowed simplicity.
     */
    private static final int MAX_SIMPLICITY = 2;

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var word = sc.next();

            // Calculate how many times each letter occurs in the word.
            final var counts = new int[NUM_CHARS];
            for (var i = 0; i < word.length(); ++i) {
                final var index = word.charAt(i) - 'a';
                counts[index]++;
            }

            // Order each letter by the number of occurrences.
            Arrays.sort(counts);

            // Remove all letters that aren't the two most common.
            var numToRemove = 0;
            for (int i = 0; i < NUM_CHARS - MAX_SIMPLICITY; ++i) {
                numToRemove += counts[i];
            }

            System.out.println(numToRemove);
        }
    }

}

