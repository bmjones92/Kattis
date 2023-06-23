
import java.util.Scanner;

/**
 * Solution to the "Tri Tiling" problem on Kattis.
 * @author Brendan Jones
 */
public class TriTiling {

    /**
     * The maximum width of the rectangle.
     */
    private static final int MAX_SIZE = 32;

    /**
     * List of cached solutions to speed up execution.
     */
    private static final long[] SOLUTIONS = new long[MAX_SIZE];

    static {
        SOLUTIONS[0] = 1;
        SOLUTIONS[2] = 3;
        for (var i = 4; i < MAX_SIZE; i += 2) {
            SOLUTIONS[i] = -1L;
        }
    }

    /**
     * Processes a single test case.
     * @param sc The input scanner.
     * @param b The output builder.
     * @return {@code true} if another test case follows this one.
     */
    private static boolean processTestCase(Scanner sc, StringBuilder b) {
        final var numCols = sc.nextInt();
        if (numCols == -1) {
            return false;
        }

        final var solution = getSolution(numCols);
        b.append(solution).append('\n');

        return true;
    }

    /**
     * Gets the solution for the specified number of columns.
     * @param numCols The number of columns.
     * @return The solution.
     */
    private static long getSolution(int numCols) {
        final var solution = SOLUTIONS[numCols];
        if (solution != -1) {
            return solution;
        }

        SOLUTIONS[numCols] = 4 * getSolution(numCols - 2) - getSolution(numCols - 4);

        return SOLUTIONS[numCols];
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var b = new StringBuilder();
            while (processTestCase(sc, b));
            System.out.print(b);
        }
    }

}

