import java.util.Arrays;
import java.util.Scanner;

/**
 * Solution to the "Words for Numbers" problem on Kattis.
 * @author Brendan Jones
 */
public class WordsForNumbers {

    /**
     * Word representations for numbers with standard naming conventions.
     */
    private static final String[][] PLACE_NAMES = {
            { null, null },
            { null, "one" },
            { "twenty", "two" },
            { "thirty", "three" },
            { "forty", "four" },
            { "fifty", "five" },
            { "sixty", "six" },
            { "seventy", "seven" },
            { "eighty", "eight" },
            { "ninety", "nine" }
    };

    /**
     * Textual representations for numbers 10-19.
     */
    private static final String[] TENS = {
            "ten",
            "eleven",
            "twelve",
            "thirteen",
            "fourteen",
            "fifteen",
            "sixteen",
            "seventeen",
            "eighteen",
            "nineteen"
    };

    /**
     * Converts `number` to its word representation.
     * @param number The number to convert.
     * @return The word
     */
    private static String getWordForNumber(int number) {
        if(number == 0) {
            return "zero";
        } else if(number < 10) {
            return PLACE_NAMES[number][1];
        } else if(number < 20) {
            return TENS[number - 10];
        }

        final var tens = PLACE_NAMES[number / 10][0];
        final var ones = PLACE_NAMES[number % 10][1];
        if (ones == null) {
            return tens;
        } else {
            return tens + '-' + ones;
        }
    }

    /**
     * Attempts to convert a number to its word equivalent. If the provided word is not a number, then the word itself
     * will be returned.
     * @param word The word to attempt to convert.
     * @return The word equivalent, or the word itself.
     */
    private static String tryGetWordForNumber(String word) {
        try {
            final var number = Integer.parseInt(word);
            return getWordForNumber(number);
        } catch (NumberFormatException e) {
            return word;
        }
    }

    /**
     * Processes a single test case.
     * @param sc The input scanner.
     * @param b The output builder.
     */
    private static void processTestCase(Scanner sc, StringBuilder b) {
        final var words = sc.nextLine().split(" ");

        Arrays.stream(words)
                .map(WordsForNumbers::tryGetWordForNumber)
                .forEach(w -> b.append(w).append(' '));

        b.append('\n');
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var b = new StringBuilder();

            while (sc.hasNextLine()) {
                processTestCase(sc, b);
            }

            System.out.print(b);
        }
    }

}
