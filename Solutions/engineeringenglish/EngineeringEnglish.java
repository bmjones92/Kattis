import java.util.HashSet;
import java.util.Scanner;

/**
 * Solution to the "Engineering English" problem on Kattis.
 * @author Brendan Jones
 */
public class EngineeringEnglish {

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var b = new StringBuilder();

            final var existing = new HashSet<>();
            while (sc.hasNext()) {
                final var line = sc.nextLine().split(" ");
                for (final var word : line) {
                    if (existing.add(word.toLowerCase())) {
                        b.append(word).append(' ');
                    } else {
                        b.append(". ");
                    }
                }
                b.append('\n');
            }

            System.out.println(b);
        }
    }

}

