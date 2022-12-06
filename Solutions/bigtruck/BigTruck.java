import java.util.*;

public class BigTruck {

    private static class Node {

        /** The list of nodes that can reach this with shortest path. */
        private final List<Integer> parents = new ArrayList<>();
        
        /** The index of this node in the graph. */
        private final int index;

        /** The number of items that can be picked up from this location. */
        private final int items;


        /** The cost to reach this node */
        private int cost;


        /** The number of items that can be picked up along the most optimal path. */
        private int maxItems;

        private Node(int index, int items) {
            this.index = index;
            this.items = items;
            this.cost = Integer.MAX_VALUE;
            this.maxItems = Integer.MIN_VALUE;
        }

    }

    private static void dijkstras(Node[] nodes, int[][] edges, int start) {
        nodes[start].cost = 0;

        final var queue = new PriorityQueue<Node>(Comparator.comparingInt(a -> a.cost));
        queue.add(nodes[start]);

        while (!queue.isEmpty()) {
            final var current = queue.poll();

            for (final var neighbor : nodes) {
                if (neighbor.cost <= current.cost) {
                    continue; // Impossible for path to neighbor to be shorter from current node.
                }


                final var edgeCost = edges[current.index][neighbor.index];
                if (edgeCost == 0) {
                    continue; // No edge exists between the current and neighbor nodes.
                }

                final var newCost = current.cost + edgeCost;
                if (newCost > neighbor.cost) {
                    continue; // Would be more expensive to reach neighbor from current node.
                }

                // The neighbor node can be reached more cheaply from the current node than the previous path.
                if (newCost < neighbor.cost) {
                    // The neighboring node can be reached more quickly than before from the current node, so its
                    // position must be recalculated if it is already present in the queue. We do this by removing and
                    // re-adding it to the queue after its new cost has been calculated.
                    queue.remove(neighbor);

                    // Remove any old parents, as following them results in a longer path.
                    neighbor.parents.clear();

                    // Update the cost to the new neighbor.
                    neighbor.cost = newCost;

                    // Add the node to the queue to be used to find additional paths.
                    queue.add(neighbor);
                }

                // Add the current node as a parent of the neighbor node.
                neighbor.parents.add(current.index);
            }
        }
    }

    private static int findBestPath(Node[] nodes, int index) {
        final var node = nodes[index];
        if (node.maxItems != Integer.MIN_VALUE) {
            return node.maxItems;
        }

        var maxItems = 0;
        for(final var child : node.parents) {
            maxItems = Math.max(maxItems, findBestPath(nodes, child));
        }

        node.maxItems = maxItems + node.items;

        return node.maxItems;
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var numNodes = sc.nextInt();

            // Initializes the nodes with the number of items they have.
            final var nodes = new Node[numNodes];
            for (var i = 0; i < numNodes; ++i) {
                nodes[i] = new Node(i, sc.nextInt());
            }

            final var edges = new int[numNodes][numNodes];

            // Read the edge costs for the graph.
            final var numEdges = sc.nextInt();
            for (var i = 0; i < numEdges; ++i) {
                final var nodeA = sc.nextInt() - 1;
                final var nodeB = sc.nextInt() - 1;

                final var cost = sc.nextInt();
                edges[nodeA][nodeB] = cost;
                edges[nodeB][nodeA] = cost;
            }

            dijkstras(nodes, edges, 0);

            final var target = nodes[numNodes - 1];
            if (target.cost == Integer.MAX_VALUE) {
                // Destination node could not be reached.
                System.out.println("impossible");
            } else {
                findBestPath(nodes, target.index);
                System.out.println(target.cost + " " + target.maxItems);
            }

        }
    }

}

