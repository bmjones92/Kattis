import java.util.ArrayList;
import java.util.Scanner;

/**
 * Solution to the "Ceiling Function" problem on Kattis.
 * @author Brendan Jones
 */
public class Ceiling {

    private static class Node {
        int value;
        Node left;
        Node right;

        int numLeft;
        int numRight;

        private Node(int value) {
            this.value = value;
            this.numLeft = 0;
            this.numRight = 0;
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof Node) {
                final var node = (Node) o;
                if (numLeft != node.numLeft || numRight != node.numRight) {
                    return false;
                }
                return (numLeft <= 0 || left.equals(node.left)) && (numRight <= 0 || right.equals(node.right));
            }
            return false;
        }
    }

    private static class Tree {

        private Node root;

        private Tree() {
            this.root = null;
        }

        public void add(int value) {
            final var node = new Node(value);
            if (root == null) {
                root = node;
            } else {
                add(root, node);
            }
        }

        private void add(Node parent, Node child) {
            if (child.value < parent.value) {
                if (parent.left == null) {
                    parent.left = child;
                } else {
                    add(parent.left, child);
                }
                parent.numLeft++;
            } else {
                if (parent.right == null) {
                    parent.right = child;
                } else {
                    add(parent.right, child);
                }
                parent.numRight++;
            }
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof Tree) {
                final var t = (Tree) o;
                if (root != null && t.root != null) {
                    return root.equals(t.root);
                }

                return (root == null) != (t.root == null);
            }
            return false;
        }

    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var numPrototypes = sc.nextInt();
            final var numLayers = sc.nextInt();

            final var trees = new ArrayList<Tree>();

            for (var i = 0; i < numPrototypes; ++i) {
                final var tree = new Tree();
                for (var l = 0; l < numLayers; ++l) {
                    tree.add(sc.nextInt());
                }

                var shouldAdd = true;
                for (final var other : trees) {
                    if (other.equals(tree)) {
                        shouldAdd = false;
                        break;
                    }
                }

                if (shouldAdd) {
                    trees.add(tree);
                }
            }

            System.out.println(trees.size());
        }
    }

}