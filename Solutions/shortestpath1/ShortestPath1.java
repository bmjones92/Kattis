import java.util.*;

/**
 * Solution for the "Single source shortest path, non-negative weights" problem on Kattis.
 * @author Brendan Jones
 */
public class ShortestPath1 {

    /**
     * A single node within the graph.
     */
    private static class Node {

        private int cost = Integer.MAX_VALUE;

        private final List<Edge> edges = new ArrayList<>();

        public int cost() {
            return cost;
        }

    }

    /**
     * A single edge within the graph.
     */
    private static class Edge {

        private final int weight;

        private final Node node;

        private Edge(Node node, int weight) {
            this.node = node;
            this.weight = weight;
        }

    }

    /**
     * Processes a single test case.
     * @param sc The input scanner.
     * @return Whether another test case follows.
     */
    private static boolean processTestCase(Scanner sc) {
        final var numNodes = sc.nextInt();
        final var numEdges = sc.nextInt();
        final var numQueries = sc.nextInt();
        final var startIndex = sc.nextInt();

        if (numNodes == 0 && numEdges == 0 && numQueries == 0 && startIndex == 0) {
            return false;
        }

        // Initialize the graph nodes.
        final var nodes = new Node[numNodes];
        for (var i = 0; i < numNodes; ++i) {
            nodes[i] = new Node();
        }
        nodes[startIndex].cost = 0;

        // Initialize the edges.
        initializeEdges(sc, nodes, numEdges);

        // Calculates the costs to each node using Dijkstra's algorithm.
        runDijkstra(nodes, startIndex);

        final var b = new StringBuilder();
        for (var i = 0; i < numQueries; ++i) {
            final var query = sc.nextInt();

            final var cost = nodes[query].cost;
            if (cost == Integer.MAX_VALUE) {
                b.append("Impossible");
            } else {
                b.append(cost);
            }
            b.append('\n');
        }
        System.out.println(b);

        return true;
    }

    private static void initializeEdges(Scanner sc, Node[] nodes, int numEdges) {
        for (var i = 0; i < numEdges; ++i) {
            final var from = sc.nextInt();
            final var to = sc.nextInt();
            final var weight = sc.nextInt();

            nodes[from].edges.add(new Edge(nodes[to], weight));
        }
    }

    private static void runDijkstra(Node[] nodes, int startIndex) {
        final var queue = new PriorityQueue<>(Comparator.comparingInt(Node::cost));
        queue.add(nodes[startIndex]);

        while (!queue.isEmpty()) {
            final var current = queue.poll();
            for (final var edge : current.edges) {
                final var neighbor = edge.node;
                if (current.cost + edge.weight < neighbor.cost) {
                    // Node is already in the queue, so remove it.
                    if (neighbor.cost != Integer.MAX_VALUE) {
                        queue.remove(neighbor);
                    }

                    neighbor.cost = current.cost + edge.weight;
                    queue.add(neighbor);
                }
            }
        }

    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            while (processTestCase(sc));
        }
    }

}

