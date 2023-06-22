import java.util.Scanner;

/**
 * Solution to the "Peragrams" problem on Kattis.
 * @author Brendan Jones
 */
public class Peragrams {

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var counts = new int[26];

            final var line = sc.next();
            for (var i = 0; i < line.length(); ++i) {
                counts[line.charAt(i) - 'a']++;
            }

            var hasOdd = false;

            var numToRemove = 0;
            for (final var count : counts) {
                if (count % 2 == 1) {
                    if (hasOdd) {
                        ++numToRemove;
                    }
                    hasOdd = true;
                }
            }
            System.out.println(numToRemove);
        }
    }

}
