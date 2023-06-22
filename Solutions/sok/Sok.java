import java.util.Scanner;

/**
 * Solution to the "Sok" problem on Kattis.
 * @author Brendan Jones
 */
public class Sok {

    /**
     * The number of different juices that are available.
     */
    private static final int NUM_JUICES = 3;

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            // The amount of each juice that was purchased.
            final var amounts = new int[NUM_JUICES];
            for (var i = 0; i < NUM_JUICES; i++) {
                amounts[i] = sc.nextInt();
            }

            var numServings = Double.MAX_VALUE;

            final var ratios = new double[NUM_JUICES];
            for (var i = 0; i < NUM_JUICES; i++) {
                ratios[i] = sc.nextInt();
                numServings = Math.min(numServings, amounts[i] / ratios[i]);
            }

            for (var i = 0; i < NUM_JUICES; i++) {
                final var remainder = amounts[i] - ratios[i] * numServings;
                System.out.print(remainder + " ");
            }
        }
    }

}

