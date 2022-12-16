import java.util.Scanner;

/**
 * Solution to the "Rings" problem on Kattis.
 * @author Brendan Jones
 */
public class Rings2 {
    
    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var numRows = sc.nextInt() + 2;
            final var numCols = sc.nextInt() + 2;

            final var rings = new int[numRows][numCols];
            for (var row = 0; row < numRows - 2; ++row) {
                final var line = sc.next();
                for (var col = 0; col < numCols - 2; ++col) {
                    if (line.charAt(col) == 'T') {
                        // Initially the ring number is unknown.
                        rings[row + 1][col + 1] = Integer.MAX_VALUE;
                    }
                }
            }

            var numRings = 1;
            for (var i = 0; i != numRings; ++i) {
                var wasRingAdded = false;
                for (var row = 0; row < numRows; ++row) {
                    for (var col = 0; col < numCols; ++col) {
                        // Ring is not of the current type, so continue.
                        if (rings[row][col] != i) {
                            continue;
                        }
                        // Check western neighbor.
                        if (col > 0 && rings[row][col - 1] == Integer.MAX_VALUE) {
                            rings[row][col - 1] = numRings;
                            wasRingAdded = true;
                        }
                        // Check eastern neighbor.
                        if (col < numCols - 1 && rings[row][col + 1] == Integer.MAX_VALUE) {
                            rings[row][col + 1] = numRings;
                            wasRingAdded = true;
                        }
                        // Check northern neighbor.
                        if (row > 0 && rings[row - 1][col] == Integer.MAX_VALUE) {
                            rings[row - 1][col] = numRings;
                            wasRingAdded = true;
                        }
                        // Check southern neighbor.
                        if (row < numRows - 1 && rings[row + 1][col] == Integer.MAX_VALUE) {
                            rings[row + 1][col] = numRings;
                            wasRingAdded = true;
                        }
                    }
                }
                if(wasRingAdded) {
                    numRings++;
                }
            }
                        
            final var b = new StringBuilder();
            for (var row = 1; row < numRows - 1; ++row) {
                for (var col = 1; col < numCols - 1; ++col) {
                    final var ring = rings[row][col];
                    if (ring == 0) {
                        b.append((numRings > 10) ? "..." : "..");
                    } else {
                        b.append((numRings > 10 && ring < 10) ? ".." : ".");
                        b.append(ring);
                    }
                }
                b.append('\n');
            }
            
            System.out.println(b);
        }
    }

}
