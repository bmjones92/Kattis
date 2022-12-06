import java.util.Scanner;

/**
 * Solution to the "Misa" problem on Kattis.
 * @author Brendan Jones
 */
public class Misa {

    private static int countNeighbors(boolean[][] isOccupied, int row, int col) {
        var neighbors = 0;
        for (var nRow = row - 1; nRow <= row + 1; ++nRow) {
            if (nRow < 0 || nRow >= isOccupied.length) {
                continue;
            }
            for (var nCol = col - 1; nCol <= col + 1; ++nCol) {
                if (nCol < 0 || nCol >= isOccupied[nRow].length || nRow == 0 && nCol == 0) {
                    continue;
                }

                if (isOccupied[nRow][nCol]) {
                    ++neighbors;
                }
            }
        }

        return neighbors;
    }

    private static int countHandshakes(boolean[][] isOccupied, int row, int col) {
        var numHandshakes = 0;
        for (var nRow = row - 1; nRow <= row + 1; ++nRow) {
            if (nRow < 0 || nRow >= isOccupied.length) {
                continue;
            }
            for (var nCol = col - 1; nCol <= col + 1; ++nCol) {
                if (nCol < 0 || nCol >= isOccupied[nRow].length) {
                    continue;
                }

                if (nCol > col || nCol == col && nRow > row) {
                    if (isOccupied[nRow][nCol]) {
                        ++numHandshakes;
                    }
                }
            }
        }
        return numHandshakes;
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var numRows = sc.nextInt();
            final var numCols = sc.nextInt();

            // Read the board state in.
            final var isOccupied = new boolean[numRows][numCols];
            for (var row = 0; row < numRows; ++row) {
                final var line = sc.next();
                for (var col = 0; col < numCols; ++col) {
                    isOccupied[row][col] = line.charAt(col) == 'o';
                }
            }

            // Find the best unoccupied seat.
            var bestRow = 0;
            var bestCol = 0;
            var bestNeighbors = 0;
            for (var row = 0; row < numRows; ++row) {
                for (var col = 0; col < numCols; ++col) {
                    if (!isOccupied[row][col]) {
                        final var numNeighbors = countNeighbors(isOccupied, row, col);
                        if (numNeighbors > bestNeighbors) {
                            bestRow = row;
                            bestCol = col;
                            bestNeighbors = numNeighbors;
                        }
                    }
                }
            }
            isOccupied[bestRow][bestCol] = true;

            var numHandshakes = 0;
            for (var row = 0; row < numRows; ++row) {
                for (var col = 0; col < numCols; ++col) {
                    if (isOccupied[row][col]) {
                        numHandshakes += countHandshakes(isOccupied, row, col);
                    }
                }
            }
            System.out.println(numHandshakes);
        }
    }

}