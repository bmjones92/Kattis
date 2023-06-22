import java.util.Scanner;

/**
 * Solution for the "Dejavu" problem on Kattis.
 * @author Brendan Jones
 */
public class Dejavu {

    /**
     * The maximum possible number of points.
     */
    private static final int MAX_VALUE = 100000;

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            // Read the number of elements in.
            final var numElements = sc.nextInt();

            // Stores the coordinate pairs.
            final var posX = new int[numElements];
            final var posY = new int[numElements];

            // Stores the number of times each coordinate pair shows up.
            final var countsX = new int[MAX_VALUE + 1];
            final var countsY = new int[MAX_VALUE + 1];
            for (var i = 0; i < numElements; ++i) {
                // Read the coordinate pair in.
                final var x = sc.nextInt();
                final var y = sc.nextInt();

                // Update the coordinate pair.
                posX[i] = x;
                posY[i] = y;

                // Update the counts for the coordinates.
                countsX[x]++;
                countsY[y]++;
            }

            // Count the number of triangles that can be made.
            var numTriangles = 0L;
            for(int i = 0; i < numElements; ++i) {
                numTriangles += (long) (countsX[posX[i]] - 1) * (countsY[posY[i]] - 1);
            }

            System.out.println(numTriangles);
        }
    }

}
