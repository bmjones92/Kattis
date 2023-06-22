import java.util.Scanner;

/**
 * Solution to the "Death Knight Hero" problem on Kattis.
 * @author Brendan Jones
 */
public class DeathKnight {

    private static boolean wasVictorious(String line) {
        for (var i = 1; i < line.length(); ++i) {
            // Last move was Chains of Ice and current move is Death Grip.
            if (line.charAt(i - 1) == 'C' && line.charAt(i) == 'D') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            var numVictories = 0;

            final var numBattles = sc.nextInt();
            for (var i = 0; i < numBattles; ++i) {
                if (wasVictorious(sc.next())) {
                    numVictories++;
                }
            }

            System.out.println(numVictories);
        }
    }

}

