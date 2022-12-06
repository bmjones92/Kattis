import java.util.Scanner;

/**
 * Solution to the "Beekeeper" problem on Kattis.
 * @author Brendan Jones
 */
public class Beekeeper {

    private static void processTestCase(Scanner sc, int numWords) {
        String bestWord = null;
        var bestNumDoubleVowels = 0;

        for (var i = 0; i < numWords; ++i) {
            var numDoubleVowels = 0;

            var lastChar = '\0';
            final var word = sc.next();
            for (var j = 0; j < word.length(); ++j) {
                final var ch = word.charAt(j);
                if (lastChar == ch && isVowel(ch)) {
                    numDoubleVowels++;
                }
                lastChar = ch;
            }

            if (bestWord == null || numDoubleVowels > bestNumDoubleVowels) {
                bestWord = word;
                bestNumDoubleVowels = numDoubleVowels;
            }
        }

        System.out.println(bestWord);
    }

    private static boolean isVowel(char ch) {
        return (ch == 'a') || (ch == 'e') || (ch == 'i') || (ch == 'o') || (ch == 'u') || (ch == 'y');
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            int numWords;
            while ((numWords = sc.nextInt()) != 0) {
                processTestCase(sc, numWords);
            }
        }
    }

}