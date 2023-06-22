import java.util.Scanner;
import java.util.Stack;

/**
 * Solution to the "Reachable Roads" problem on Kattis.
 * @author Brendan Jones
 */
public class ReachableRoads {

    /**
     * Processes a single test case.
     * @param sc The input Scanner.
     */
    private static void processTestCase(Scanner sc) {
        final var numNodes = sc.nextInt();
        final var isVisited = new boolean[numNodes];
        final var connections = new boolean[numNodes][numNodes];

        final var numRoads = sc.nextInt();
        for (var i = 0; i < numRoads; ++i) {
            final var a = sc.nextInt();
            final var b = sc.nextInt();
            connections[a][b] = true;
            connections[b][a] = true;
        }

        var numDisjointGraphs = 0;

        for (var i = 0; i < numNodes; ++i) {
            if (isVisited[i]) {
                continue;
            }

            numDisjointGraphs++;

            isVisited[i] = true;

            final var nodes = new Stack<Integer>();
            nodes.push(i);

            while (!nodes.isEmpty()) {
                final var top = nodes.pop();
                for (var j = 0; j < numNodes; ++j) {
                    if(!isVisited[j] && connections[top][j]) {
                        isVisited[j] = true;
                        nodes.push(j);
                    }
                }
            }
        }
        System.out.println(numDisjointGraphs - 1);
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var numTestCases = sc.nextInt();
            for (int i = 0; i < numTestCases; ++i) {
                processTestCase(sc);
            }
        }
    }

}