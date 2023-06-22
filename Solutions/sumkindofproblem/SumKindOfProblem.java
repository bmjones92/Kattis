import java.util.Scanner;

/**
 * Solution to the "Sum Kind of Problem" problem on Kattis.
 * @author Brendan Jones
 */
public class SumKindOfProblem {

    private static void processTestCase(Scanner sc) {
        final var b = new StringBuilder();
        b.append(sc.nextInt()).append(' ');

        final var n = sc.nextInt();

        // Consecutive
        b.append(n * (n + 1) / 2).append(' ');

        // Odd
        b.append(n * n).append(' ');

        // Even
        b.append(n * (n + 1)).append('\n');

        System.out.print(b);
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