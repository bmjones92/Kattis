import java.util.Scanner;

/**
 * Solution to the "Texture Analysis" problem on Kattis.
 * @author Brendan Jones
 */
public class TextureAnalysis {

    /**
     * Process a single test case.
     * @param sc The input scanner.
     * @param b The output builder.
     * @param id The id of the test.
     * @return {@code true} if another test follows this one.
     */
    private static boolean processTestCase(Scanner sc, StringBuilder b, int id) {
        final var line = sc.next();
        if (line.equals("END")) {
            return false;
        }

        b.append(id).append(' ');

        if (line.length() > 1) {
            final var step = line.indexOf('*', 1);

            // Alternatively we could use a regular expression here, but since the patterns can't be compiled ahead of
            // time, the performance is noticeably worse, so we can settle for manually iterating over each character.
            for (var i = 0; i < line.length(); i++) {
                if ((line.charAt(i) == '*') != (i % step == 0)) {
                    b.append("NOT EVEN").append('\n');
                    return true;
                }
            }
        }

        b.append("EVEN").append('\n');
        return true;
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var b = new StringBuilder();

            var id = 1;
            while (processTestCase(sc, b, id)) {
                id++;
            }

            System.out.print(b);
        }
    }

}

