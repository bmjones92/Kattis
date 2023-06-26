import java.util.Scanner;

/**
 * Solution to the "Verify This, Your Majesty" problem on Kattis.
 * @author Brendan Jones
 */
public class Queens {

    /**
     * Processes a single test case.
     * @param sc The input scanner.
     */
    private static void processTestCase(Scanner sc) {
        System.out.println(checkSolution(sc) ? "CORRECT" : "INCORRECT");
    }

    /**
     * Reads a solution from `sc` and checks its correctness.
     * @param sc The input scanner.
     * @return {@code true} if the solution is correct.
     */
    private static boolean checkSolution(Scanner sc) {
        final var numQueens = sc.nextInt();

        final var rows = new boolean[numQueens];
        final var cols = new boolean[numQueens];
        final var majorDiagonals = new boolean[2 * numQueens - 1];
        final var minorDiagonals = new boolean[2 * numQueens - 1];
        for (var i = 0; i < numQueens; ++i) {
            final var col = sc.nextInt();
            final var row = sc.nextInt();

            if (rows[row]) {
                return false;
            }
            rows[row] = true;

            if (cols[col]) {
                return false;
            }
            cols[col] = true;

            final var major = numQueens + (col - row);
            if (majorDiagonals[major]) {
                return false;
            }
            majorDiagonals[major] = true;

            final var minor = col + row;
            if (minorDiagonals[minor]) {
                return false;
            }
            minorDiagonals[minor] = true;
        }

        return true;
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            processTestCase(sc);
        }
    }

}
