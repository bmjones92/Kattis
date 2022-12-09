import java.util.Scanner;

/**
 * Solution to the "Okvir" problem on Kattis.
 * @author Brendan Jones
 */
public class Okvir {

    /**
     * Processes a single test case.
     * @param sc The input Scanner.
     */
    private static void processTestCase(Scanner sc) {
        final var numRows = sc.nextInt();
        final var numCols = sc.nextInt();
        final var padTop = sc.nextInt();
        final var padLeft = sc.nextInt();
        final var padRight = sc.nextInt();
        final var padBottom = sc.nextInt();

        final var totalWidth = numCols + padLeft + padRight;

        final var b = new StringBuilder();
        writeEmptyRows(b, 0, padTop, totalWidth);

        for (var i = 0; i < numRows; ++i) {
            final var word = sc.next();
            writePartialRow(b, padTop + i, 0, padLeft);
            b.append(word);
            writePartialRow(b, padTop + i, padLeft + word.length(), padRight);
            b.append('\n');
        }
        writeEmptyRows(b, numRows + padTop, padBottom, totalWidth);

        System.out.println(b);
    }

    /**
     * Writes a partial row to the specified builder.
     * @param b The string builder.
     * @param startRow The starting row.
     * @param startCol The starting column.
     * @param numCols The number of columns to write.
     */
    private static void writePartialRow(StringBuilder b, int startRow, int startCol, int numCols) {
        for (var col = 0; col < numCols; ++col) {
            b.append((startRow ^ (startCol + col)) % 2 == 0 ? '#' : '.');
        }
    }

    /**
     * Writes the specified number of empty rows to the specified builder.
     * @param b The string builder.
     * @param startRow The starting row.
     * @param numRows The number of rows to write.
     * @param numCols The number of columns to write.
     */
    private static void writeEmptyRows(StringBuilder b, int startRow, int numRows, int numCols) {
        for (var row = 0; row < numRows; ++row) {
            for (var col = 0; col < numCols; ++col) {
                b.append(((row + startRow) ^ col) % 2 == 0 ? '#' : '.');
            }
            b.append('\n');
        }
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            processTestCase(sc);
        }
    }

}

