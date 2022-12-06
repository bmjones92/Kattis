import java.util.Scanner;

/**
 * Solution to the "Flow Layout" problem on Kattis.
 * @author Brendan Jones
 */
public class FlowLayout {

    private static boolean processTestCase(Scanner sc) {
        final var maxWidth = sc.nextInt();
        if (maxWidth == 0) {
            return false;
        }

        var requiredWidth = 0;
        var requiredHeight = 0;

        var nodeX = 0;
        var nodeY = 0;

        while (true) {
            final var nodeWidth = sc.nextInt();
            final var nodeHeight = sc.nextInt();
            if (nodeWidth == -1 || nodeHeight == -1) {
                break;
            }

            var nodeRight = nodeX + nodeWidth;
            if (nodeRight > maxWidth) {
                nodeY = requiredHeight;
                nodeRight = nodeWidth;
            }

            final var nodeBottom = nodeY + nodeHeight;
            requiredHeight = Math.max(requiredHeight, nodeBottom);
            requiredWidth = Math.max(requiredWidth, nodeRight);

            nodeX = nodeRight;
        }

        System.out.println(requiredWidth + " x " + requiredHeight);
        return true;
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            while (processTestCase(sc));
        }
    }

}

