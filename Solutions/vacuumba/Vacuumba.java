import java.util.Scanner;

/**
 * Solution to the "Vacuumba" problem on Kattis.
 * @author Brendan Jones
 */
public class Vacuumba {

    /**
     * Process a single test case.
     * @param sc The input scanner.
     * @param b The output builder.
     */
    private static void processTestCase(Scanner sc, StringBuilder b) {
        var posX = 0.0;
        var posY = 0.0;
        var angle = Math.PI / 2.0;

        final var numSegments = sc.nextInt();
        for (var i = 0; i < numSegments; ++i) {
            angle += Math.toRadians(sc.nextDouble());

            final var distance = sc.nextDouble();

            posX += Math.cos(angle) * distance;
            posY += Math.sin(angle) * distance;
        }

        b.append(posX).append(' ').append(posY).append('\n');
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var b = new StringBuilder();

            final var numTestCases = sc.nextInt();
            for (var i = 0; i < numTestCases; i++) {
                processTestCase(sc, b);
            }

            System.out.print(b);
        }
    }

}

