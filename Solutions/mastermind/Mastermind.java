import java.util.Scanner;

/**
 * Solution to the "Mastering Mastermind" problem on Kattis.
 * @author Brendan Jones
 */
public class Mastermind {

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var length = sc.nextInt();

            final var code = sc.next();
            final var guess = sc.next();

            final var codeCounts = getCharacterCounts(code);
            final var guessCounts = getCharacterCounts(guess);

            // The number of elements matching the exact color and position.
            var numExactMatches = 0;

            // The number of elements matching the color but not position.
            var numColorMatches = 0;

            for (var i = 0; i < length; ++i) {
                final var ch = guess.charAt(i);
                if (ch == code.charAt(i)) {
                    numExactMatches++;
                    codeCounts[ch - 'A']--;
                    guessCounts[ch - 'A']--;
                }
            }

            for (var i = 0; i < 26; ++i) {
                numColorMatches += Math.min(codeCounts[i], guessCounts[i]);
            }

            System.out.println(numExactMatches + " " + numColorMatches);
        }
    }

    private static int[] getCharacterCounts(String value) {
        final var counts = new int[26];
        for (var i = 0; i < value.length(); ++i) {
            counts[value.charAt(i) - 'A']++;
        }
        return counts;
    }

}
