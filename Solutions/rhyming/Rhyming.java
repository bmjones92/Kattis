import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Solution to the "Rhyming Slang" problem on Kattis.
 * @author Brendan Jones
 */
public class Rhyming {
    
    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var endings = new HashSet<String>();

            final var commonWord = sc.next();

            final var numEndingLists = sc.nextInt(); sc.nextLine();
            for (var i = 0; i < numEndingLists; ++i) {
                final var tokens = sc.nextLine().split(" ");
                
                for (final var token : tokens) {
                    if (commonWord.endsWith(token)) {
                        endings.addAll(Arrays.asList(tokens));
                        break;
                    }
                }
            }

            final var numPhrases = sc.nextInt(); sc.nextLine();
            for (var i = 0; i < numPhrases; ++i) {
                var found = false;

                final var phrase = sc.nextLine();
                for (final var ending : endings) {
                    if (phrase.endsWith(ending)) {
                        found = true;
                        break;
                    }
                }
                System.out.println(found ? "YES" : "NO");
            }
        }
    }

}
