import java.util.Scanner;

/**
 * Solution to the "Mia" problem on Kattis.
 * @author Brendan Jones
 */
public class Mia {

    private static final int MIA = 21;

    private enum MatchResult {
        Tie,
        P1,
        P2
    }

    private static boolean processTestCase(Scanner sc) {
        final var score1 = calculateRoll(sc.nextInt(), sc.nextInt());
        final var score2 = calculateRoll(sc.nextInt(), sc.nextInt());
        if (score1 == 0 || score2 == 0) {
            return false;
        }

        final var winner = determineWinner(score1, score2);
        if (winner == MatchResult.Tie) {
            System.out.println("Tie.");
        } else {
            System.out.printf("Player %d wins.%n", winner.ordinal());
        }
        return true;
    }

    public static MatchResult determineWinner(int score1, int score2) {
        // Game is a tie if both scores are equal.
        if (score1 == score2) {
            return MatchResult.Tie;
        }

        // Player that rolled "MIA" will automatically win.
        if (score1 == MIA) {
            return MatchResult.P1;
        }
        if (score2 == MIA) {
            return MatchResult.P2;
        }

        // Player with the largest "doubles" roll wins.
        final var dubs1 = ((score1 / 10) == (score1 % 10)) ? (score1 % 10) : 0;
        final var dubs2 = ((score2 / 10) == (score2 % 10)) ? (score2 % 10) : 0;
        if(dubs1 > 0 && dubs2 > 0) {
            return (dubs1 > dubs2) ? MatchResult.P1 : MatchResult.P2;
        }
        if (dubs1 > 0 && dubs2 == 0) {
            return MatchResult.P1;
        }
        if (dubs2 > 0 && dubs1 == 0) {
            return MatchResult.P2;
        }

        // No special rolls, so whichever player had the highest score wins.
        return (score1 > score2) ? MatchResult.P1 : MatchResult.P2;
    }

    /**
     * Calculates a roll's score from two dice rolls.
     * @param diceA The roll of the first dice.
     * @param diceB The roll of the second dice.
     * @return The roll score.
     */
    private static int calculateRoll(int diceA, int diceB) {
        return (diceA < diceB) ? (diceB * 10 + diceA) : (diceA * 10 + diceB);
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            while (processTestCase(sc));
        }
    }

}

