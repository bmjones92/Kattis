import java.util.*;

/**
 * Solution to the "Secret Chamber at Mount Rushmore" problem on Kattis.
 * @author Brendan Jones
 */
public class SecretChamber {

    /**
     * The number of valid letter characters.
     */
    private static final int NUM_CHARS = 26;

    /**
     * Normalizes a letter to a numerical index.
     * @param ch The character. Must be a lowercase alphabetical character.
     * @return The character index.
     */
    private static int toCharIndex(char ch) {
        return ch - 'a';
    }

    /**
     * Checks whether `target` is a valid translation for `source`.
     * @param translations The translation table.
     * @param source The source message.
     * @param target The target message.
     * @return {@code true} if the translation is valid, otherwise {@code false}.
     */
    private static boolean isValidTranslation(BitSet[] translations, String source, String target) {
        // Character translations are 1:1, so strings with mismatched lengths cannot be valid translation pairs.
        if (source.length() != target.length()) {
            return false;
        }

        // Check that each character in source can be translated to target.
        for (var i = 0; i < source.length(); i++) {
            final var sourceIndex = toCharIndex(source.charAt(i));
            final var targetIndex = toCharIndex(target.charAt(i));
            if (!translations[sourceIndex].get(targetIndex)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var numTranslations = sc.nextInt();
            final var numWords = sc.nextInt();

            // Character translations can be represented by a graph.
            final var edges = new boolean[NUM_CHARS][NUM_CHARS];
            for (var i = 0; i < numTranslations; i++) {
                final var a = toCharIndex(sc.next().charAt(0));
                final var b = toCharIndex(sc.next().charAt(0));

                edges[a][b] = true;
            }

            // Traverse the translation table to populate all possible translations.
            final var conversions = new BitSet[NUM_CHARS];
            for (var source = 0; source < NUM_CHARS; source++) {
                final var set = new BitSet(NUM_CHARS);
                set.set(source);

                // Perform an exhaustive search starting with the current element being processed.
                final var queue = new LinkedList<Integer>();
                queue.add(source);

                while (!queue.isEmpty()) {
                    final var current = queue.poll();

                    for (var target = 0; target < NUM_CHARS; target++) {
                        if (set.get(target) || !edges[current][target]) {
                            continue;
                        }

                        if (conversions[target] != null) {
                            // Target translations have already been computed.
                            set.or(conversions[target]);
                        } else {
                            queue.add(target);
                            set.set(target);
                        }
                    }
                }

                conversions[source] = set;
            }

            // Process each of the test cases.
            for (var i = 0; i < numWords; i++) {
                final var a = sc.next();
                final var b = sc.next();
                System.out.println(isValidTranslation(conversions, a, b) ? "yes" : "no");
            }
        }
    }

}

