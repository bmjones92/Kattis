import java.util.Scanner;

/**
 * Solution to the "Guess the Number" problem on Kattis.
 * @author Brendan Jones
 */
public class Guess {

    /**
     * The minimum possible guess.
     */
    public static final int MIN_VALUE = 1;

    /**
     * The maximum possible guess.
     */
    public static final int MAX_VALUE = 1000;

    /**
     * The number of guesses that can be made.
     */
    private static final int MAX_GUESSES = 10;

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            var rangeBegin = MIN_VALUE;
            var rangeEnd = MAX_VALUE;

            // Use binary search to make guesses.
            for (var i = 0; i < MAX_GUESSES; ++i) {
                final var middle = (rangeBegin + rangeEnd) / 2;
                System.out.println(middle);

                final var response = sc.nextLine();
                switch (response) {
                    case "lower":
                        rangeEnd = middle - 1;
                        break;
                    case "higher":
                        rangeBegin = middle + 1;
                        break;
                    default:
                        return;
                }
            }

        }
    }

}

