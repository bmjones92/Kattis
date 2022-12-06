import java.awt.Point;
import java.util.Scanner;

/**
 * Solution to the "Jabuke" problem on Kattis.
 * @author Brendan Joens
 */
public class Jabuke {

    /**
     * Gets the area of the triangle formed by the specified points.
     * @param a The first point.
     * @param b The second point.
     * @param c The third point.
     * @return The triangle's area.
     */
    private static double getArea(Point a, Point b, Point c) {
        return Math.abs(a.x * (b.y - c.y) + b.x * (c.y - a.y) + c.x * (a.y - b.y)) / 2.0;
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var a = new Point(sc.nextInt(), sc.nextInt());
            final var b = new Point(sc.nextInt(), sc.nextInt());
            final var c = new Point(sc.nextInt(), sc.nextInt());

            final var area = getArea(a, b, c);
            System.out.printf("%.1f%n", area);

            var numOwnedTrees = 0;

            final var numTrees = sc.nextInt();
            for (var i = 0; i < numTrees; ++i) {
                final var tree = new Point(sc.nextInt(), sc.nextInt());

                final var treeArea = getArea(tree, a, b) + getArea(tree, b, c) + getArea(tree, c, a);
                if (treeArea == area) {
                    ++numOwnedTrees;
                }
            }

            System.out.println(numOwnedTrees);
        }
    }

}

