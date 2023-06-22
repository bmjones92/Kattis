import java.util.Scanner;

/**
 * Solution to the "Planina" problem on Kattis.
 * @author Brendan Jones
 */
public class Planina {

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            var size = 2;

            // There's probably an easier formula for the growth, but the maximum number of iterations is low enough
            // that looping wouldn't have a notable impact on performance.
            final var numIterations = sc.nextInt();
            for (var i = 0; i < numIterations; ++i) {
                size = (2 * size) - 1;
            }

            System.out.println(size * size);
        }
    }

}

