import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Solution to the "Hiding Places" problem on Kattis.
 * @author Brendan Jones
 */
public class HidingPlaces {

    /**
     * The different moves that can be made.
     */
    private static final int[][] MOVE_DELTAS = new int[][] {
            { -2, -1 },
            { -2,  1 },
            {  2, -1 },
            {  2,  1 },
            { -1, -2 },
            { -1,  2 },
            {  1, -2 },
            {  1,  2 }
    };

    /**
     * The size of the board.
     */
    private static final int BOARD_SIZE = 8;

    /**
     * Processes a single test case.
     * @param sc The input scanner.
     */
    private static void processTestCase(Scanner sc) {
        final var src = sc.next();

        final var srcCol = src.charAt(0) - 'a';
        final var srcRow = '8' - src.charAt(1);

        final var distance = new int[BOARD_SIZE][BOARD_SIZE];
        for (var row = 0; row < distance.length; ++row) {
            for (var col = 0; col < distance.length; ++col) {
                distance[row][col] = Integer.MAX_VALUE;
            }
        }

        final var queue = new LinkedList<Point>();
        queue.add(new Point(srcCol, srcRow));
        distance[srcRow][srcCol] = 0;

        while (!queue.isEmpty()) {
            final var current = queue.poll();

            final var dist = distance[current.y][current.x] + 1;
            for (var moveDelta : MOVE_DELTAS) {
                final var pos = new Point(current.x + moveDelta[0], current.y + moveDelta[1]);
                if (isValid(pos.x, pos.y) && distance[pos.y][pos.x] > dist) {
                    distance[pos.y][pos.x] = dist;
                    queue.add(pos);
                }
            }
        }

        var maxRequiredMoves = 0;

        final var hidingSpots = new ArrayList<String>();
        for (var row = 0; row < BOARD_SIZE; ++row) {
            for (var col = 0; col < BOARD_SIZE; ++col) {
                if (distance[row][col] > maxRequiredMoves) {
                    hidingSpots.clear();
                    maxRequiredMoves = distance[row][col];
                }

                if (distance[row][col] == maxRequiredMoves) {
                    hidingSpots.add(String.valueOf((char) ('a' + col)) + (8 - row));
                }
            }
        }

        final var b = new StringBuilder();
        b.append(maxRequiredMoves);

        for (final var spot : hidingSpots) {
            b.append(' ').append(spot);
        }
        System.out.println(b);
    }

    /**
     * Checks whether the specified position is valid.
     * @param x The x coordinate.
     * @param y The y coordinate.
     * @return True if the position is valid, otherwise false.
     */
    private static boolean isValid(int x, int y) {
        return (x >= 0 && x < BOARD_SIZE && y >= 0 && y < BOARD_SIZE);
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var numTestCases = sc.nextInt();
            for (var i = 0; i < numTestCases; ++i) {
                processTestCase(sc);
            }
        }
    }

}

