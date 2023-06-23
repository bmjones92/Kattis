import java.util.Scanner;

/**
 * Solution to the "The Amazing Human Cannonball" problem on Kattis.
 * @author Brendan Jones
 */
public class HumanCannonball2 {

    /**
     * Rough approximation of the gravitational constant.
     */
    private static final double GRAVITY = 9.81;

    /**
     * Processes a single test case.
     * @param sc The input scanner.
     * @param b The output builder.
     */
    private static void processTestCase(Scanner sc, StringBuilder b) {
        final var velocity = sc.nextDouble();
        final var angle = Math.toRadians(sc.nextDouble());
        final var distanceToWall = sc.nextDouble();

        final var gapLower = sc.nextDouble();
        final var gapUpper = sc.nextDouble();

        final var t = distanceToWall / (velocity * Math.cos(angle));
        final var y = (velocity * t * Math.sin(angle)) - (0.5 * GRAVITY * t * t);

        final var isSafe = y > gapLower + 1.0 && y < gapUpper - 1.0;
        b.append(isSafe ? "Safe" : "Not Safe").append('\n');
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

