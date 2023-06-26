import java.util.Scanner;

/**
 * Solution to the "Weak Vertices" problem on Kattis.
 * @author Brendan Jones
 */
public class WeakVertices {

    /**
     * Processes a single test case.
     * @param sc The input scanner.
     * @param b The output builder.
     * @return {@code true} if another test case follows this one.
     */
    private static boolean processTestCase(Scanner sc, StringBuilder b) {
        final var numNodes = sc.nextInt();
        if (numNodes == -1) {
            return false;
        }

        // Read the adjacency matrix.
        final var edges = new boolean[numNodes][numNodes];
        for (var row = 0; row < numNodes; ++row) {
            for (var col = 0; col < numNodes; ++col) {
                edges[row][col] = sc.nextInt() == 1;
            }
        }

        // Test whether each of the nodes is a weak vertex.
        for (var current = 0; current < numNodes; ++current) {
            if (isWeak(edges, numNodes, current)) {
                b.append(current).append(' ');
            }
        }
        b.append('\n');

        return true;
    }

    /**
     * Checks whether the specified vertex is `weak`.
     * @param edges The graph to check.
     * @param numNodes The number of nodes in the graph.
     * @param current The id of the vertex to check.
     * @return {@code true} if the vertex is weak.
     */
    private static boolean isWeak(boolean[][] edges, int numNodes, int current) {
        for (var neighbor = 0; neighbor < numNodes; neighbor++) {
            // No edge between the nodes so skip it.
            if (!edges[current][neighbor]) {
                continue;
            }

            // If any matches exist we win.
            for (var other = neighbor + 1; other < numNodes; ++other) {
                if (edges[current][other] && edges[neighbor][other]) {
                    return false;
                }
            }
        }

        // No good matches found.
        return true;
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var b = new StringBuilder();
            while (processTestCase(sc, b));
            System.out.print(b);
        }
    }

}

