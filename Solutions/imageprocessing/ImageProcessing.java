import java.util.Scanner;

/**
 * Solution to the "Image Processing" problem on Kattis.
 * @author Brendan Jones
 */
public class ImageProcessing {

    /**
     * Matrix implementation.
     */
    private static class Matrix {

        /**
         * The height of the matrix.
         */
        private final int height;

        /**
         * The width of the matrix.
         */
        private final int width;

        /**
         * The matrix values.
         */
        private final int[][] mat;

        /**
         * Creates a new Matrix instance.
         * @param height The matrix height.
         * @param width The matrix width.
         */
        public Matrix(int height, int width) {
            this.height = height;
            this.width = width;
            this.mat = new int[height][width];
        }

        /**
         * Loads data into the matrix.
         * @param sc The input scanner.
         * @param flip Whether the rows and columns should be flipped when reading data in.
         */
        public void load(Scanner sc, boolean flip) {
            for (var row = 0; row < height; ++row) {
                for (var col = 0; col < width; ++col) {
                    if (flip) {
                        mat[height - 1 - row][width - 1 - col] = sc.nextInt();
                    } else {
                        mat[row][col] = sc.nextInt();
                    }
                }
            }
        }

        /**
         * Calculates the multiply sum result.
         * @param other The matrix to multiply against.
         * @param baseRow The starting row.
         * @param baseCol The starting column.
         * @return The multiply sum result.
         */
        private int multSum(Matrix other, int baseRow, int baseCol) {
            var sum = 0;
            for (var row = 0; row < other.height; ++row) {
                for (var col = 0; col < other.width; ++col) {
                    sum += mat[baseRow + row][baseCol + col] * other.mat[row][col];
                }
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var image = new Matrix(sc.nextInt(), sc.nextInt());
            final var kernel = new Matrix(sc.nextInt(), sc.nextInt());

            image.load(sc, false);
            kernel.load(sc, true);

            final var numRows = image.height - kernel.height + 1;
            final var numCols = image.width - kernel.width + 1;

            for (var row = 0; row < numRows; ++row) {
                for (var col = 0; col < numCols; ++col) {
                    System.out.print(image.multSum(kernel, row, col) + " ");
                }
                System.out.println();
            }
        }
    }

}
