import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Solution to the "Minimum Scalar Product" problem on Kattis.
 * @author Brendan Jones
 */
public class MinimumScalar {

    private static void processTestCase(Scanner sc, int id) {
        final var numComponents = sc.nextInt();

        final var a = new PriorityQueue<Long>();
        for (var i = 0; i < numComponents; i++) {
            a.add(sc.nextLong());
        }

        final var b = new PriorityQueue<Long>(Comparator.reverseOrder());
        for (var i = 0; i < numComponents; i++) {
            b.add(sc.nextLong());
        }

        var minProduct = 0L;
        for (var i = 0; i < numComponents; i++) {
            minProduct += a.poll() * b.poll();
        }
        
        System.out.printf("Case #%d: %d%n", id, minProduct);
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var numCases = sc.nextInt();
            for (var i = 1; i <= numCases; ++i) {
                processTestCase(sc, i);
            }
        }
    }

}
