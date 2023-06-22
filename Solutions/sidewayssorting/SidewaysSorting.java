import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Solution to the "Sideways Sorting" problem on Kattis.
 * @author Brendan Jones
 */
public class SidewaysSorting {

    public static boolean processTestCase(Scanner sc) {
        final var numRows = sc.nextInt();
        final var numCols = sc.nextInt();
        if (numRows == 0 && numCols == 0) {
            return false;
        }

        final var matrix = new char[numRows][numCols];
        for (var row = 0; row < numRows; row++) {
            final var line = sc.next();
            for (var col = 0; col < numCols; col++) {
                matrix[row][col] = line.charAt(col);
            }
        }

        final var lines = new ArrayList<String>();
        for (var col = 0; col < numCols; col++) {
            final var b = new StringBuilder();
            for (int row = 0; row < numRows; row++) {
                b.append(matrix[row][col]);
            }
            lines.add(b.toString());
        }
        lines.sort(Comparator.comparing(String::toLowerCase));

        for (var col = 0; col < numCols; col++) {
            final var line = lines.get(col);
            for (var row = 0; row < numRows; row++) {
                matrix[row][col] = line.charAt(row);
            }
        }

        final var b = new StringBuilder();
        for (var row = 0; row < numRows; row++) {
            for (var col = 0; col < numCols; col++) {
                b.append(matrix[row][col]);
            }
            b.append('\n');
        }
        System.out.println(b);

        return true;
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            while (processTestCase(sc));
        }
    }

}