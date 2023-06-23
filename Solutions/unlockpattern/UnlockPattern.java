import java.util.Scanner;

/**
 * Solution to the "Unlock Pattern" problem on Kattis.
 * @author Brendan Jones
 */
public class UnlockPattern {

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var positions = new int[9];
            for (var pos = 0; pos < positions.length; pos++) {
                positions[sc.nextInt() - 1] = pos;
            }

            var lastPos = positions[0];

            var totalLength = 0.0;
            for (var i = 1; i < positions.length; ++i) {
                final var currPos = positions[i];

                final var dx = (lastPos % 3) - (currPos % 3);
                final var dy = (lastPos / 3) - (currPos / 3);

                totalLength += Math.sqrt(dx * dx + dy * dy);

                lastPos = currPos;
            }

            System.out.println(totalLength);
        }
    }

}

