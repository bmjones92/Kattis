import java.util.Arrays;
import java.util.Scanner;

/**
 * Solution to the "Height Ordering" problem on Kattis.
 * @author Brendan Jones
 */
public class Height {

    /**
     * The number of students in the class.
     */
    private static final int NUM_STUDENTS = 20;

    private static void processTestCase(Scanner sc) {
        final var caseID = sc.nextInt();

        var numSteps = 0;
        final var heights = new int[NUM_STUDENTS];
        for (var i = 0; i < NUM_STUDENTS; ++i) {
            final var current = sc.nextInt();

            final var pos = ~Arrays.binarySearch(heights, 0, i, current);
            if (i - pos >= 0) {
                System.arraycopy(heights, pos, heights, pos + 1, i - pos);
            }
            heights[pos] = current;
            numSteps += i - pos;
        }

        System.out.printf("%d %d%n", caseID, numSteps);
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var numTestCases = sc.nextInt();
            for (var i = 0; i < numTestCases; ++i) {
                processTestCase(sc);
            }
        }
    }

}