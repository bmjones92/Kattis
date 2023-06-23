import java.util.Scanner;

/**
 * Solution to the "ToLower" problem on Kattis.
 * @author Brendan Jones
 */
public class ToLower {

    /**
     * Process a single test case.
     * @param sc The input scanner.
     */
    private static void processTestCase(Scanner sc) {
        final var numProblems = sc.nextInt();
        final var numTestCases = sc.nextInt();

        var numSolved = 0;
        for (var problem = 0; problem < numProblems; problem++) {
            var isSolvable = true;
            for (var testCase = 0; testCase < numTestCases; testCase++) {
                final var text = sc.next();
                for (var i = 1; i < text.length(); i++) {
                    if (!Character.isLowerCase(text.charAt(i))) {
                        isSolvable = false;
                    }
                }
            }

            if (isSolvable) {
                numSolved++;
            }
        }

        System.out.println(numSolved);
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            processTestCase(sc);
        }
    }

}