import java.util.Scanner;

/**
 * Solution to the "N-Puzzle" problem on Kattis.
 * @author Brendan Jones
 */
public class NPuzzle {

    /**
     * The size of the board.
     */
    private static final int SIZE = 4;

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            var scatter = 0;
            for (var row = 0; row < SIZE; ++row) {
                final var line = sc.nextLine();
                for (var col = 0; col < SIZE; ++col) {
                    final var ch = line.charAt(col);
                    if (ch == '.') {
                        continue;
                    }

                    final var index = ch - 'A';
                    final var targetRow = index / SIZE;
                    final var targetCol = index % SIZE;

                    scatter += Math.abs(targetRow - row);
                    scatter += Math.abs(targetCol - col);
                }
            }

            System.out.println(scatter);
        }
    }

}

