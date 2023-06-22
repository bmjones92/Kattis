import java.util.Scanner;

/**
 * Solution to the "Pebble Solitaire" problem on Kattis.
 * @author Brendan Jones
 */
public class PebbleSolitaire {

    /**
     * Processes a single test case.
     * @param sc The input scanner.
     */
    private static void processTestCase(Scanner sc) {
        final var line = sc.next();

        var numRemaining = 0;

        final var board = new boolean[line.length()];
        for (var i = 0; i < board.length; ++i) {
            if (line.charAt(i) == 'o') {
                board[i] = true;
                numRemaining++;
            }
        }

        System.out.println(getRemainingStones(board, numRemaining));
    }

    private static boolean isValidMove(boolean[] board, int pos, int direction) {
        final var dest = pos + (direction * 2);
        if (dest < 0 || dest >= board.length) {
            return false;
        }
        return board[pos + direction] && !board[dest];
    }

    private static int getRemainingStones(boolean[] board, int numRemaining) {
        var minRemaining = numRemaining;

        for (var i = 0; i < board.length; ++i) {
            if (board[i]) {
                if (isValidMove(board, i, -1)) {
                    // Move to the left.
                    board[i] = false;
                    board[i - 1] = false;
                    board[i - 2] = true;

                    minRemaining = Math.min(minRemaining, getRemainingStones(board, numRemaining - 1));

                    board[i] = true;
                    board[i - 1] = true;
                    board[i - 2] = false;
                }
                if (isValidMove(board, i, 1)) {
                    // Move to the right.
                    board[i] = false;
                    board[i + 1] = false;
                    board[i + 2] = true;

                    minRemaining = Math.min(minRemaining, getRemainingStones(board, numRemaining - 1));

                    board[i] = true;
                    board[i + 1] = true;
                    board[i + 2] = false;
                }
            }
        }

        return minRemaining;
    }


    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var numCases = sc.nextInt();
            for (var i = 0; i < numCases; ++i) {
                processTestCase(sc);
            }
        }
    }

}
