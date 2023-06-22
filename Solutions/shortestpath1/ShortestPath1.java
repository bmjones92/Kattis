import java.util.*;

/**
 * Solution to the "Single source shortest path, non-negative weights" problem on Kattis.
 * @author Brendan Jones
 */
public class ShortestPath1 {

    /**
     * Represents a node on the graph.
     */
    private static class Node {

        private static Comparator<Node> COMPARATOR = Comparator.comparingInt(n -> n.cost);

        /**
         * The cost to reach this node.
         */
        private int cost = Integer.MAX_VALUE;

        /**
         * The list of edges.
         */
        private final List<Edge> edges = new ArrayList<>();

    }

    /**
     * Represents an edge on the graph.
     */
    private static class Edge {

        /**
         * The weight of this edge.
         */
        private final int weight;

        /**
         * The node this edge belongs to.
         */
        private final Node node;

        /**
         * Creates a new Edge.
         * @param node The node instance.
         * @param weight The weight of this edge.
         */
        private Edge(Node node, int weight) {
            this.node = node;
            this.weight = weight;
        }

    }

    /**
     * Processes a single test case.
     * @param sc The input scanner.
     * @return {@code true} if another test case follows this one.
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
        for(var i = 0; i < numNodes; ++i) {
            nodes[i] = new Node();
        }
        nodes[startIndex].cost = 0;

        // Read the edge weights from the input.
        readEdges(sc, nodes, numEdges);

        // Calculate the costs to each node using Dijkstra's algorithm.
        findShortestPaths(nodes, startIndex);

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

    /**
     * Reads the edge weights between nodes.
     * @param sc The input scanner.
     * @param nodes The graph.
     * @param numEdges The number of edges on the graph.
     */
    private static void readEdges(Scanner sc, Node[] nodes, int numEdges) {
        for (var i = 0; i < numEdges; ++i) {
            final var from = sc.nextInt();
            final var to = sc.nextInt();
            final var weight = sc.nextInt();

            nodes[from].edges.add(new Edge(nodes[to], weight));
        }
    }

    /**
     * Find the shortest paths to all nodes from the starting node.
     * @param nodes The graph.
     * @param startIndex The index of the source node.
     */
    private static void findShortestPaths(Node[] nodes, int startIndex) {
        final var queue = new PriorityQueue<Node>(Node.COMPARATOR);
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

