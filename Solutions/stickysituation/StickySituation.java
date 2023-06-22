import java.util.Arrays;
import java.util.Scanner;

/**
 * Solution to the "Sticky Situation" problem on Kattis.
 * @author Brendan Jones
 */
public class StickySituation {

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var numSticks = sc.nextInt();

            final var sticks = new long[numSticks];
            for (var i = 0; i < numSticks; ++i) {
                sticks[i] = sc.nextLong();
            }

            // Order sticks by length.
            Arrays.sort(sticks);

            for (var i = 0; i < numSticks - 2; i++) {
                final var legA = sticks[i];
                final var legB = sticks[i + 1];
                final var hypotenuse = sticks[i + 2];

                // Hypotenuse is always the longest side and must be at least as long as the sum of the other two sides.
                if (legA + legB > hypotenuse) {
                    System.out.println("possible");
                    return;
                }
                
            }

            System.out.println("impossible");
        }
    }

}

