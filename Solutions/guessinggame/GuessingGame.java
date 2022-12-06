import java.util.Scanner;

/**
 * Solution to the "Guessing Game" problem on Kattis.
 * @author Brendan Jones
 */
public class GuessingGame {

    /**
     * Processes a single test case.
     * @param sc The input Scanner.
     * @return Whether another test case follows.
     */
    private static boolean processTestCase(Scanner sc) {
        // The lower bound of the possible guesses.
        var low = 1;
        // The upper bound of the possible guesses.
        var high = 10;

        while (true) {
            // Reads the guess and discards the rest of the line, otherwise `response` will be an empty line.
            final var guess = sc.nextInt(); sc.nextLine();
            if (guess == 0) {
                return false;
            }

            final var response = sc.nextLine();
            switch(response) {
                case "too high": {
                    if(low <= guess && guess <= high) {
                        high = guess - 1;
                    }
                    break;
                }
                case "too low": {
                    if(low <= guess && guess <= high) {
                        low = guess + 1;
                    }
                    break;
                }
                case "right on": {
                    if(guess < low || guess > high) {
                        System.out.println("Stan is dishonest");
                    } else {
                        System.out.println("Stan may be honest");
                    }
                    return true;
                }
            }
        }
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            while (processTestCase(sc));
        }
    }

}

