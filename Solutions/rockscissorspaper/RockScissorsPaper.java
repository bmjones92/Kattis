import java.util.Scanner;

/**
 * Solution to the "Rock, Scissors, Paper" problem on Kattis.
 * @author Brendan Jones
 */
public class RockScissorsPaper {

    /**
     * The identifier for "Rock".
     */
    private static final char ROCK = 'R';

    /**
     * The identifier for "Paper".
     */
    private static final char PAPER = 'P';

    /**
     * The identifier for "Scissors".
     */
    private static final char SCISSORS = 'S';

    /**
     * Deltas for all four cardinal directions.
     */
    private static final int[][] DIRECTIONS = {
            { -1,  0 }, // Left
            {  0, -1 }, // Up
            {  1,  0 }, // Right
            {  0,  1 }  // Down
    };
    
    private static void processTestCase(Scanner sc) {
        final var numRows = sc.nextInt();
        final var numCols = sc.nextInt();
        final var numDays = sc.nextInt();

        // Discard the remainder of the line.
        sc.nextLine();
        
        // Read the initial state of the board.
        var board = new char[numRows][numCols];
        for (var row = 0; row < numRows; ++row) {
            final var line = sc.nextLine();
            for (var col = 0; col < numCols; ++col) {
                board[row][col] = line.charAt(col);
            }
        }
        
        // Changes must be stored on a back buffer and then copied over to the front buffer, otherwise partial results
        // could screw up the rest of the board.
        var backBuffer = new char[numRows][numCols];
        for (int row = 0; row < numRows; ++row) {
            System.arraycopy(board[0], 0, backBuffer[row], 0, numCols);
        }
        
        for (var day = 0; day < numDays; ++day) {
            for (var row = 0; row < numRows; ++row) {
                System.arraycopy(board[row], 0, backBuffer[row], 0, numCols);
                for(int col = 0; col < numCols; ++col) {
                    final var weakness = getWeakness(board[row][col]);
                    for (final var dir : DIRECTIONS) {
                        if (isType(board, col + dir[0], row + dir[1], weakness)) {
                            // This tile was overtaken.
                            backBuffer[row][col] = weakness;
                            break;
                        }
                    }
                }
            }
            
            // Swap buffers to update the board.
            final var temp = board;
            board = backBuffer;
            backBuffer = temp;
        }

        final var b = new StringBuilder();
        for (var row = 0; row < numRows; ++row) {
            for (var col = 0; col < numCols; ++col) {
                b.append(board[row][col]);
            }
            b.append('\n');
        }
        System.out.println(b);
    }
    
    /**
     * Checks if the specified tile is of the specified type.
     * @param board The board
     * @param col The column of the tile to check.
     * @param row The row of the tile to check.
     * @param type The type to compare to.
     * @return Whether the tile is within the bounds of the board and is of the correct type.
     */
    private static boolean isType(char[][] board, int col, int row, char type) {
        // Ensure the tile is not out of bounds.
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return false;
        }
        return board[row][col] == type;
    }
    
    /**
     * Gets the weakness of the specified tile.
     * @param ch The type
     * @return The weakness type.
     */
    private static char getWeakness(char ch) {
        switch (ch) {
        case ROCK:
            return PAPER;
        case PAPER:
            return SCISSORS;
        case SCISSORS:
            return ROCK;
        }
        throw new IllegalArgumentException("Unrecognized character: '" + ch + "' (" + (int) ch + ")");
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
