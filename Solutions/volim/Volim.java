import java.util.Scanner;

/**
 * Solution to the "Volim" problem on Kattis.
 * @author Brendan Jones
 */
public class Volim {

    /**
     * How many seconds after the game starts before the box explodes.
     */
    private static final int EXPLOSION_DELAY = 210;

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            var currentPlayer = sc.nextInt();

            var currentTime = 0;

            final var numQuestions = sc.nextInt();
            for (var i = 0; i < numQuestions; ++i) {
                final var timeElapsed = sc.nextInt();
                final var result = sc.next();

                currentTime += timeElapsed;
                if (currentTime > EXPLOSION_DELAY) {
                    System.out.println(currentPlayer);
                    return;
                }

                if (result.equals("T")) {
                    currentPlayer = Math.max(1, (currentPlayer + 1) % 9);
                }
            }

            throw new RuntimeException("That shouldn't happen...");
        }
    }

}

