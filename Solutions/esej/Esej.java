import java.util.Scanner;

/**
 * Solution to the "Esej" problem on Kattis.
 * @author Brendan Jones
 */
public class Esej {

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var minWords = sc.nextInt();
            final var maxWords = sc.nextInt();

            final var numWords = (minWords + maxWords) / 2;

            final var word = new char[]{ 'a', 'a', 'a', 'a' };

            final var b = new StringBuilder();
            for (var i = 0; i < numWords; ++i) {
                for (var j = 0; j < word.length; ++j) {
                    if (++word[j] > 'z') {
                        word[j] = 'a';
                        continue;
                    }
                    break;
                }
                b.append(word).append(' ');
            }

            System.out.print(b);
        }
    }

}

