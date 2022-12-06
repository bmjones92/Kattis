import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * Solution to the "Is-A? Has A? Who Knowz-A?" problem on Kattis.
 * @author Brendan Jones
 */
public class Isahasa {

    /**
     * A node in the inheritance graph.
     */
    private static class Node {

        /**
         * The list of has-a relations.
         */
        private List<Node> hasARelations;

        /**
         * The list of is-a relations.
         */
        private List<Node> isARelations;

        /**
         * The list of aliases.
         */
        private Set<Node> aliases;

        /**
         * Whether this node was visited.
         */
        private boolean isVisited;

        /**
         * Creates a new Node.
         */
        private Node() {
            this.hasARelations = new ArrayList<>();
            this.isARelations = new ArrayList<>();
            this.aliases = null;
            this.isVisited = false;
        }

        /**
         * Visits this node.
         * @return This node.
         */
        public Node visit() {
            this.isVisited = true;
            return this;
        }

        /**
         * Checks whether this node has an "is-a" relationship with the other node.
         * @param other The other node.
         * @return Whether there is an is-a relationship.
         */
        public boolean isA(Node other) {
            // A node is an instance of itself.
            if (this == other) {
                return true;
            }

            calculateAliases();

            return aliases.contains(other);
        }

        /**
         * Checks whether this node has a "has-a" relationship with the other node.
         * @param other The other node.
         * @return Whether there is a "has-a" relationship.
         */
        private boolean hasA(Node other) {
            final var queue = new LinkedList<Node>();
            queue.add(visit());

            calculateAliases();
            aliases.forEach(alias -> queue.add(alias.visit()));

            while (!queue.isEmpty()) {
                final var current = queue.poll();

                for (var child : current.hasARelations) {
                    if (child.isA(other)) {
                        return true;
                    }

                    if (child.isVisited) {
                        continue;
                    }

                    queue.add(child.visit());

                    child.aliases.forEach(alias -> {
                        if (!alias.isVisited) {
                            queue.add(alias.visit());
                        }
                    });
                }
            }
            return false;
        }

        /**
         * Calculates aliases for this node.
         */
        private void calculateAliases() {
            // Aliases are already calculated.
            if (aliases != null) {
                return;
            }
            aliases = new HashSet<>();

            isARelations.forEach(child -> {
                child.calculateAliases();

                aliases.addAll(child.aliases);
                aliases.add(child);
            });
        }
    }


    /**
     * Reads a single test case from the Scanner and outputs the result.
     * @param sc The Scanner.
     */
    private static void processTestCase(Scanner sc) {
        final var numRelations = sc.nextInt();
        final var numQueries = sc.nextInt();

        final var graph = new HashMap<String, Node>();

        // Read the input and build the inheritance graph.
        for (var i = 0; i < numRelations; ++i) {
            final var nodeA = getNode(graph, sc.next());
            final var relation = sc.next();
            final var nodeB = getNode(graph, sc.next());

            if (relation.equals("is-a")) {
                nodeA.isARelations.add(nodeB);
            } else {
                nodeA.hasARelations.add(nodeB);
            }
        }

        final var sb = new StringBuilder();
        for (var i = 0; i < numQueries; ++i) {
            final var nodeA = getNode(graph, sc.next());
            final var relation = sc.next();
            final var nodeB = getNode(graph, sc.next());

            sb.append("Query ").append(i + 1).append(": ");
            if (relation.equals("is-a")) {
                sb.append(nodeA.isA(nodeB));
            } else {
                sb.append(nodeA.hasA(nodeB));
                graph.forEach((key, value) -> value.isVisited = false);
            }

            sb.append('\n');
        }

        System.out.print(sb);
    }

    /**
     * Finds a node in the graph. If the node does not exist, then a new node will be created in its place.
     * @param graph The graph to search.
     * @param name The name of the node.
     * @return The found node.
     */
    private static Node getNode(Map<String, Node> graph, String name) {
        return graph.computeIfAbsent(name, key -> new Node());
    }

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            processTestCase(sc);
        }
    }

}
