import java.util.HashMap;
import java.util.Scanner;

/**
 * Solution to the "Babelfish" problem on Kattis.
 * @author Brendan Jones
 */
public class Babelfish {

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var dictionary = new HashMap<String, String>();

            String line;
            while (!(line = sc.nextLine()).isEmpty()) {
                final var tokens = line.split(" ");
                dictionary.put(tokens[1], tokens[0]);
            }

            final var b = new StringBuilder();
            while (sc.hasNext()) {
                final var translation = dictionary.get(sc.next());
                if (translation == null) {
                    b.append("eh\n");
                } else {
                    b.append(translation).append('\n');
                }
            }
            System.out.print(b);
        }
    }

}
