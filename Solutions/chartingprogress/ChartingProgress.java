import java.util.Scanner;

/**
 * Solution to the "Charting Progress" problem on Kattis.
 * @author Brendan Jones
 */
public class ChartingProgress {

    private static void processTestCase(Scanner sc) {
        var numSortedElements = 0;

        String line = null;
        while (sc.hasNextLine() && !(line = sc.nextLine()).isEmpty()) {
            var numResults = 0;
            for (var i = 0; i < line.length(); ++i) {
                if (line.charAt(i) == '*') {
                    numResults++;
                }
            }

            final var numUnsortedElements = line.length() - numSortedElements;

            String b = ".".repeat(Math.max(0, numUnsortedElements - numResults)) +
                       "*".repeat(Math.max(0, numResults)) +
                       ".".repeat(Math.max(0, numSortedElements));

            numSortedElements += numResults;

            System.out.println(b);
        }

        if (line != null && line.isEmpty()) {
            System.out.println();
        }
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            while (sc.hasNext()) {
                processTestCase(sc);
            }
        }
    }

}