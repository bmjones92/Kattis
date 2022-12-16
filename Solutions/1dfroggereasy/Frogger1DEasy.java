import java.util.Scanner;

/**
 * Solution to the "1-D Frogger (easy)" problem on Kattis.
 * @author Brendan Jones
 */
public class Frogger1DEasy {

    public static void main(String[] args) {
        final var sc = new Scanner(System.in);

        final var numSquares = sc.nextInt();
        final var startIndex = sc.nextInt() - 1;
        final var magicNumber = sc.nextInt();

        // Initialize the board.
        final var board = new int[numSquares];
        final var visited = new boolean[numSquares];
        for (var i = 0; i < board.length; i++) {
            board[i] = sc.nextInt();
        }

        var currentIndex = startIndex;
        var numMoves = 0;

        String result;
        while ((result = getCompletionStatus(board, visited, currentIndex, magicNumber)) == null) {
            visited[currentIndex] = true;
            currentIndex += board[currentIndex];
            numMoves++;
        }

        System.out.println(result);
        System.out.println(numMoves);
    }

    private static String getCompletionStatus(int[] board, boolean[] visited, int index, int magic) {
        if (index < 0) {
            return "left";
        }
        if (index >= board.length) {
            return "right";
        }
        if (visited[index]) {
            return "cycle";
        }
        if (board[index] == magic) {
            return "magic";
        }
        return null;
    }

}
