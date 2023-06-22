import java.util.Scanner;

/**
 * Solution to the "Pig Latin" problem on Kattis.
 * @author Brendan Jones
 */
public class PigLatin {

    /**
     * Finds the index of the first vowel in a word.
     * @param word The word to search.
     * @return The index of the first vowel, or -1 if no vowels exist.
     */
    private static int getFirstVowelIndex(String word) {
        for (var i = 0; i < word.length(); ++i) {
            final var ch = word.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'y') {
                return i;
            }
        }
        return -1;
    }

    /**
     * Translates a line to pig latin.
     * @param line The line to translate.
     */
    private static void translateLine(String line) {
        final var b = new StringBuilder();
        for (final var word : line.split(" ")) {
            final var firstVowelIndex = getFirstVowelIndex(word);
            if (firstVowelIndex == 0) {
                b.append(word).append("yay");
            } else {
                b.append(word.substring(firstVowelIndex)).append(word, 0, firstVowelIndex).append("ay");
            }
            b.append(' ');
        }
        System.out.println(b);
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            while (sc.hasNext()) {
                String line = sc.nextLine();
                translateLine(line);
            }
        }
    }

}

