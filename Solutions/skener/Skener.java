import java.util.Scanner;

/**
 * Solution to the "Skener" problem on Kattis.
 * @author Brendan Jones
 */
public class Skener {

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var numRows = sc.nextInt();
            final var numCols = sc.nextInt();
            final var zoomedRowScale = sc.nextInt();
            final var zoomedColScale = sc.nextInt();

            final var b = new StringBuilder();

            for (var row = 0; row < numRows; ++row) {
                final var line = sc.next();
                for (var zRow = 0; zRow < zoomedRowScale; ++zRow) {
                    for (var col = 0; col < numCols; ++col) {
                        final var ch = line.charAt(col);
                        b.append(String.valueOf(ch).repeat(Math.max(0, zoomedColScale)));
                    }
                    b.append('\n');
                }
            }

            System.out.print(b);
        }
    }

}