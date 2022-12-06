import java.util.Scanner;

/**
 * Solution to the "Nine Knights" problem on Kattis.
 * @author Brendan Jones
 */
public class NineKnights {

    /**
     * Position deltas for all valid moves.
     */
    private static final int[][] DELTAS = {
        {  0,  0 }, // Starting position.
        { -1, -2 }, // Left 1, Up 2.
        { -1,  2 }, // Left 1, Down 2.
        { -2, -1 }, // Left 2, Up 1.
        { -2,  1 }, // Left 2, Down 1.
        {  1, -2 }, // Right 1, Up 2.
        {  1,  2 }, // Right 1, Down 2.
        {  2, -1 }, // Right 2, Up 1.
        {  2,  1 }, // Right 2, Down 1.
    };

    /**
     * Size of the board.
     */
    private static final int SIZE = 5;

    /**
     * Processes a single test case.
     * @param sc The input Scanner.
     */
    private static void processTestCase(Scanner sc) {
        var count = 0;

        final var blocked = new boolean[SIZE][SIZE];

        for (var row = 0; row < SIZE; ++row) {
            final var line = sc.next();
            for (var col = 0; col < line.length(); ++col) {
                if (line.charAt(col) == 'k') {
                    count++;
                    if (!addKnight(row, col, blocked)) {
                        System.out.println("invalid");
                        return;
                    }
                }
            }
        }
        System.out.println(count == 9 ? "valid" : "invalid");
    }

    private static boolean addKnight(int row, int col, boolean[][] blocked) {
        if (blocked[row][col]) {
            return false;
        }

        for (final var delta : DELTAS) {
            final var newCol = col + delta[0];
            final var newRow = row + delta[1];
            if (checkBounds(newCol, newRow)) {
                blocked[newRow][newCol] = true;
            }
        }
        
        return true;
    }

    /**
     * Checks that the position is within the bounds of the board.
     * @param x The x coordinate.
     * @param y The y coordinate.
     * @return Whether the position is inside the bounds of the board.
     */
    private static boolean checkBounds(int x, int y) {
        return (y >= 0 && x >= 0 && y < SIZE && x < SIZE);
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            processTestCase(sc);
        }
    }

}

