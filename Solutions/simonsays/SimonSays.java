import java.util.Scanner;

/**
 * Solution to the "Simon Says" problem on Kattis.
 * @author Brendan Jones
 */
public class SimonSays {

    /**
     * The prefix for valid commands.
     */
    private static final String COMMAND_PREFIX = "Simon says";

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var numLines = sc.nextInt(); sc.nextLine();
            for (var i = 0; i < numLines; i++) {
                final var line = sc.nextLine();
                if (line.startsWith(COMMAND_PREFIX)) {
                    System.out.println(line.substring(COMMAND_PREFIX.length()));
                }
            }
        }
    }

}

