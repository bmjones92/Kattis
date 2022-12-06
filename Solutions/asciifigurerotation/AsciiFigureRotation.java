import java.util.Scanner;

/**
 * Solution to the "ASCII Figure Rotation" problem on Kattis.
 * @author Brendan Jones
 */
public class AsciiFigureRotation {

    /**
     * The maximum size of the figure.
     */
    private static final int MAX_LENGTH = 100;

    /**
     * Processes a single test case.
     * @param sc The input Scanner.
     * @param numRows The number of rows.
     */
    private static void processTestCase(Scanner sc, int numRows) {
        final var matrix = new char[numRows][MAX_LENGTH];

        var longestLineLength = 0;
        for (var i = 0; i < numRows; ++i) {
            final var line = sc.nextLine();
            System.arraycopy(line.toCharArray(), 0, matrix[i], 0, line.length());

            if (line.length() > longestLineLength) {
                longestLineLength = line.length();
            }
        }

        for (var col = 0; col < longestLineLength; ++col) {
            final var b = new StringBuilder();
            for (var row = numRows - 1; row >= 0; --row) {
                final var ch = matrix[row][col];
                if (ch == '-') {
                    b.append('|');
                } else if (ch == '|') {
                    b.append('-');
                } else if (ch == '\0') {
                    b.append(' ');
                } else {
                    b.append(ch);
                }
            }

            System.out.println(b.toString().replaceFirst("\\s+$", ""));
        }

    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            var isFirst = true;
            var numRows = 0;
            while ((numRows = sc.nextInt()) != 0) {
                sc.nextLine();

                if (!isFirst) {
                    System.out.println();
                }
                isFirst = false;

                processTestCase(sc, numRows);
            }
        }
    }

}