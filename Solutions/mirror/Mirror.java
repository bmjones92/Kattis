import java.util.Scanner;

/**
 * Solution to the "Mirror Images" problem on Kattis.
 * @author Brendan Jones
 */
public class Mirror {

    private static void processTestCase(Scanner sc) {
        final var numRows = sc.nextInt();
        final var numCols = sc.nextInt();

        final var framebuffer = new char[numRows][numCols];
        for (var row = 0; row < numRows; ++row) {
            final var line = sc.next();
            for (var col = 0; col < numCols; ++col) {
                framebuffer[row][col] = line.charAt(col);
            }
        }

        final var b = new StringBuilder();
        for (var row = numRows - 1; row >= 0; --row) {
            for (var col = numCols - 1; col >= 0; --col) {
                b.append(framebuffer[row][col]);
            }
            b.append('\n');
        }

        System.out.print(b);
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var numTestCases = sc.nextInt();
            for (var i = 0; i < numTestCases; ++i) {
                System.out.println("Test " + (i + 1));
                processTestCase(sc);
            }
        }
    }

}

