import java.util.Scanner;

/**
 * Solution to the "Natjecanje" problem on Kattis.
 * @author Brendan Jones
 */
public class Natjecanje {

    /**
     * Processes a single test case.
     * @param sc The input scanner.
     */
    private static void processTestCase(Scanner sc) {
        final var numTeams = sc.nextInt();
        var numDamaged = sc.nextInt();
        final var numReserved = sc.nextInt();

        final var isDamaged = new boolean[numTeams];
        for (var i = 0; i < numDamaged; ++i) {
            isDamaged[sc.nextInt() - 1] = true;
        }

        final var hasReserve = new boolean[numTeams];
        for (var i = 0; i < numReserved; ++i) {
            hasReserve[sc.nextInt() - 1] = true;
        }

        for (var i = 0; i < numTeams; ++i) {
            if (!hasReserve[i]) {
                continue;
            }

            if (isDamaged[i]) {
                isDamaged[i] = false;
                --numDamaged;
            } else if (i > 0 && isDamaged[i - 1]) {
                isDamaged[i - 1] = false;
                --numDamaged;
            } else if (i < numTeams - 1 && isDamaged[i + 1]) {
                isDamaged[i + 1] = false;
                --numDamaged;
            }
        }

        System.out.println(numDamaged);
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            processTestCase(sc);
        }
    }

}

