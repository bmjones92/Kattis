import java.util.Scanner;

/**
 * Solution for the "Alphabet Spam" problem on Kattis.
 */
public class AlphabetSpam {

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var line = sc.next();

            var numWhitespace = 0;
            var numLowercase = 0;
            var numUppercase = 0;
            var numSymbols = 0;

            for (var ch : line.toCharArray()) {
                if (ch == '_') {
                    numWhitespace++;
                } else if (Character.isUpperCase(ch)) {
                    numUppercase++;
                } else if (Character.isLowerCase(ch)) {
                    numLowercase++;
                } else {
                    numSymbols++;
                }
            }

            System.out.println((double) numWhitespace / line.length());
            System.out.println((double) numLowercase / line.length());
            System.out.println((double) numUppercase / line.length());
            System.out.println((double) numSymbols / line.length());
        }
    }

}