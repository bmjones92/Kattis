import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Solution to the "Welcome to Code Jam (Easy)" problem on Kattis.
 * @author Brendan Jones.
 */
public class WelcomeEasy {

    /**
     * The string to search for.
     */
    private static final char[] TARGET_STRING = "welcome to code jam".toCharArray();

    /**
     * Processes a single test case.
     * @param sc The input scanner.
     * @param b The output builder.
     * @param caseID The id of the test case.
     */
    private static void processTestCase(Scanner sc, StringBuilder b, int caseID) {
        final var input = sc.nextLine().toCharArray();

        var indices = new ArrayList<Integer>();
        indices.add(-1);

        var newIndices = new ArrayList<Integer>();
        for (final var ch : TARGET_STRING) {
            for (final var index : indices) {
                findPossibilities(ch, index, input, newIndices);
            }

            // Clear the existing indices.
            indices.clear();

            // Swap the indices.
            final var temp = indices;
            indices = newIndices;
            newIndices = temp;
        }

        b.append("Case #")
                .append(caseID)
                .append(": ")
                .append(String.format("%04d", indices.size()))
                .append('\n');
    }

    /**
     * Finds all possible indices for the target character.
     * @param target The target character.
     * @param index The starting index.
     * @param input The input string to search.
     * @param list The list of matching indices.
     */
    private static void findPossibilities(char target, int index, char[] input, List<Integer> list) {
        for (var i = index + 1; i < input.length; ++i) {
            if (input[i] == target) {
                list.add(i);
            }
        }
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var b = new StringBuilder();

            final var numTestCases = sc.nextInt(); sc.nextLine();
            for (var i = 0; i < numTestCases; ++i) {
                processTestCase(sc, b, i + 1);
            }

            System.out.print(b);
        }
    }

}
