import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Solution to the "Prva" problem on Kattis.
 * @author Brendan Jones
 */
public class Prva {

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var numRows = sc.nextInt();
            final var numCols = sc.nextInt();

            // Initialize the state of the board.
            final var puzzle = new char[numRows][numCols];
            for (var row = 0; row < numRows; ++row) {
                final var line = sc.next();
                for (var col = 0; col < numCols; ++col) {
                    puzzle[row][col] = line.charAt(col);
                }
            }

            // Build the list of found words.
            final var words = new TreeSet<String>();
            for (var row = 0; row < numRows; ++row) {
                for (var col = 0; col < numCols; ++col) {
                    final var wordH = searchRight(puzzle, row, col);
                    if (wordH != null && wordH.length() > 1) {
                        words.add(wordH);
                    }

                    final var wordV = searchDown(puzzle, row, col);
                    if (wordV != null && wordV.length() > 1) {
                        words.add(wordV);
                    }
                }
            }

            // Print the smallest lexicographical word.
            System.out.println(words.iterator().next());
        }
    }

    /**
     * Searches for a word starting at the specified position and moving right.
     * @param puzzle The puzzle.
     * @param row The row to start at.
     * @param col The column to start at.
     * @return The found word.
     */
    private static String searchRight(char[][] puzzle, int row, int col) {
        // Not the start of a word, so ignore it.
        if(col > 0 && puzzle[row][col - 1] != '#') {
            return null;
        }

        // Build the word.
        final var b = new StringBuilder();
        for (var i = col; i < puzzle[row].length; ++i) {
            if (puzzle[row][i] == '#') {
                break;
            }
            b.append(puzzle[row][i]);
        }

        // Return the found word.
        return b.toString();
    }

    /**
     * Searches for a word starting at the specified position and moving down.
     * @param puzzle The puzzle.
     * @param row The row to start at.
     * @param col The column to start at.
     * @return The found word.
     */
    private static String searchDown(char[][] puzzle, int row, int col) {
        // Not the start of a word, so ignore it.
        if (row > 0 && puzzle[row - 1][col] != '#') {
            return null;
        }

        // Build the word.
        final var b = new StringBuilder();
        for (var i = row; i < puzzle.length; ++i) {
            if (puzzle[i][col] == '#') {
                break;
            }
            b.append(puzzle[i][col]);
        }

        // Return the found word.
        return b.toString();
    }

}
