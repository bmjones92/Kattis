import java.util.*;

/**
 * Solution to the "Touchscreen Keyboard" problem on Kattis.
 * @author Brendan Jones
 */
public class TouchscreenKeyboard {

    /**
     * Maps characters to their key positions.
     */
    private static final Position[] KEY_POSITIONS = new Position[26];

    static {
        final var keys = new String[] { "qwertyuiop", "asdfghjkl", "zxcvbnm" };
        for (var row = 0; row < keys.length; row++) {
            final var line = keys[row];
            for (var col = 0; col < line.length(); col++) {
                KEY_POSITIONS[toCharIndex(line.charAt(col))] = new Position(row, col);
            }
        }
    }

    /**
     * Represents a position on the touchscreen.
     */
    private static class Position {

        /**
         * The row.
         */
        private final int row;

        /**
         * The column.
         */
        private final int col;

        /**
         * Creates a new Position.
         * @param row The row.
         * @param col The column.
         */
        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }

        /**
         * Calculates the distance between two points.
         * @param other The other position.
         * @return The distance.
         */
        private int distance(Position other) {
            return Math.abs(row - other.row) + Math.abs(col - other.col);
        }

    }

    /**
     * Represents a spell checker suggestion.
     */
    private static class Suggestion implements Comparable<Suggestion> {

        /**
         * The default comparator.
         */
        private static final Comparator<Suggestion> COMPARATOR = Comparator
                .<Suggestion>comparingInt(s -> s.distance)
                .thenComparing(s -> s.word);

        /**
         * The suggested word.
         */
        private final String word;

        /**
         * The word distance.
         */
        private final int distance;

        /**
         * Creates a new Suggestion.
         * @param word The suggested word.
         * @param distance The word distance.
         */
        private Suggestion(String word, int distance) {
            this.word = word;
            this.distance = distance;
        }

        @Override
        public String toString() {
            return word + " " + distance;
        }

        @Override
        public int compareTo(Suggestion o) {
            return COMPARATOR.compare(this, o);
        }

    }

    /**
     * Converts a lowercase letter to its numerical index in KEY_POSITIONS.
     * @param ch The character to convert.
     * @return The character index.
     */
    private static int toCharIndex(char ch) {
        return ch - 'a';
    }

    /**
     * Computers the total distance between `input` and `word`.
     * @param input The input.
     * @param word The word.
     * @return The total distance.
     */
    private static int computeDistance(String input, String word) {
        var totalDistance = 0;
        for (var i = 0; i < word.length(); i++) {
            final var inPos = KEY_POSITIONS[toCharIndex(input.charAt(i))];
            final var wordPos = KEY_POSITIONS[toCharIndex(word.charAt(i))];
            totalDistance += inPos.distance(wordPos);
        }
        return totalDistance;
    }

    /**
     * Process a single test case.
     * @param sc The input scanner.
     * @param b The output builder.
     */
    private static void processTestCase(Scanner sc, StringBuilder b) {
        final var suggestions = new TreeSet<>();

        final var input = sc.next();
        final var numSuggestions = sc.nextInt();
        for (var i = 0; i < numSuggestions; i++) {
            final var word = sc.next();
            final var dist = computeDistance(input, word);

            final var suggestion = new Suggestion(word, dist);
            suggestions.add(suggestion);
        }

        suggestions.forEach(s -> b.append(s).append('\n'));
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var b = new StringBuilder();

            final var numTestCases = sc.nextInt();
            for (var i = 0; i < numTestCases; ++i) {
                processTestCase(sc, b);
            }

            System.out.print(b);
        }
    }

}
