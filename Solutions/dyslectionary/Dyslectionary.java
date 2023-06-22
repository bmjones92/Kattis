import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Solution to the "Dyslectionary" problem on Kattis.
 * @author Brendan Jones
 */
public class Dyslectionary {

    /**
     * A word to add to the dyslectionary.
     */
    private static class Word {

        /**
         * The word.
         */
        private final String word;

        /**
         * The reversed word.
         */
        private final String reversed;

        /**
         * Creates a new word.
         * @param word The word.
         */
        private Word(String word) {
            this.word = word;
            this.reversed = new StringBuilder(word).reverse().toString();
        }

    }

    /**
     * Processes a single test case.
     * @param sc The input Scanner.
     */
    private static void processTestCase(Scanner sc) {
        // The set of words in the dictionary.
        final var dictionary = new TreeSet<Word>(Comparator.comparing(a -> a.reversed));

        // The length of the longest word in the dictionary.
        var longestWord = 0;

        String line;
        while (sc.hasNextLine() && !(line = sc.nextLine()).isEmpty()) {
            longestWord = Math.max(longestWord, line.length());
            dictionary.add(new Word(line));
        }

        // Print each word in the dictionary.
        for (final var word : dictionary) {
            System.out.printf("%" + longestWord + "s%n", word.word);
        }

        // Every test case is separated with a blank line.
        if (sc.hasNextLine()) {
            System.out.println();
        }
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            while (sc.hasNextLine()) {
                processTestCase(sc);
            }
        }
    }

}

