import java.util.Arrays;
import java.util.Scanner;

/**
 * Solution to the "Platforme" problem on Kattis.
 * @author Brendan Jones
 */
public class Platforme {

    private static class Platform {

        private final int height;

        private final int left;

        private final int right;

        private Platform(int height, int left, int right) {
            this.height = height;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var numPlatforms = sc.nextInt();

            // Read platforms in and sort them from highest to lowest.
            final var platforms = new Platform[numPlatforms];
            for (var i = 0; i < numPlatforms; ++i) {
                platforms[i] = new Platform(sc.nextInt(), sc.nextInt(), sc.nextInt());
            }
            Arrays.sort(platforms, (a, b) -> b.height - a.height);

            var totalSupportLength = 0;
            for (var i = 0; i < platforms.length; ++i) {
                var needsLeftSupport = true;
                var needsRightSupport = true;

                final var current = platforms[i];

                for (var j = i + 1; j < platforms.length && (needsLeftSupport || needsRightSupport); ++j) {
                    final var below = platforms[j];

                    if (needsLeftSupport && below.left <= current.left && below.right > current.left) {
                        needsLeftSupport = false;
                        totalSupportLength += current.height - below.height;
                    }

                    if (needsRightSupport && below.right >= current.right && below.left < current.right) {
                        needsRightSupport = false;
                        totalSupportLength += current.height - below.height;
                    }
                }

                if (needsLeftSupport) {
                    totalSupportLength += current.height;
                }
                if (needsRightSupport) {
                    totalSupportLength += current.height;
                }
            }
            System.out.println(totalSupportLength);
        }
    }

}
