import java.util.Scanner;

/**
 * Solution to the "Game Rank" problem on Kattis.
 * @author Brendan Jones
 */
public class GameRank {

    /**
     * Calculates the number of stars needed to advance to the next rank.
     * @param rank The rank.
     * @return The number of stars.
     */
    private static int calculateStarsForRank(int rank) {
        return Math.min(5, (35 - rank) / 5);
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            var currentRank = 25;
            var currentStars = 0;
            var numRequiredStars = calculateStarsForRank(currentRank);
            var numConsecutiveWins = 0;

            final var results = sc.next();
            for (var i = 0; i < results.length(); ++i) {
                final var result = results.charAt(i);

                if (result == 'W') {
                    numConsecutiveWins++;
                    currentStars += (numConsecutiveWins >= 3 && currentRank > 5) ? 2 : 1;

                    // Rank up occurred.
                    if(currentStars > numRequiredStars) {
                        currentStars -= numRequiredStars;
                        currentRank--;
                        numRequiredStars = calculateStarsForRank(currentRank);

                        // Permanently legend rank.
                        if (currentRank == 0) {
                            break;
                        }
                    }
                } else {
                    numConsecutiveWins = 0;

                    // Cannot go below rank 20 with 0 stars.
                    if (currentRank < 20 || (currentRank == 20 && currentStars > 0)) {
                        currentStars--;
                        if (currentStars < 0) {
                            currentRank++;
                            numRequiredStars = calculateStarsForRank(currentRank);
                            currentStars = numRequiredStars - 1;
                        }
                    }
                }
            }

            System.out.println((currentRank == 0) ? "Legend" : currentRank);
        }
    }

}

