import java.util.Arrays;
import java.util.Scanner;

/**
 * Solution to the "ASCII Addition" problem on Kattis.
 * @author Brendan Jones
 */
public class AsciiAddition {

    /**
     * The width of a single character.
     */
    private static final int CHAR_WIDTH = 5;

    /**
     * The width of a single character with padding.
     */
    private static final int CHAR_WIDTH_PAD = CHAR_WIDTH + 1;

    /**
     * The height of a character.
     */
    private static final int CHAR_HEIGHT = 7;

    /**
     * Binary representations for each recognized character.
     */
    private static final long[] ASCII_BINARY = {
            0b11111100011000110001100011000111111L, //0
            0b00001000010000100001000010000100001L, //1
            0b11111000010000111111100001000011111L, //2
            0b11111000010000111111000010000111111L, //3
            0b10001100011000111111000010000100001L, //4
            0b11111100001000011111000010000111111L, //5
            0b11111100001000011111100011000111111L, //6
            0b11111000010000100001000010000100001L, //7
            0b11111100011000111111100011000111111L, //8
            0b11111100011000111111000010000111111L, //9
            0b00000001000010011111001000010000000L, //+
    };

    /**
     * The index of the "+" character in the ASCII_BINARY array.
     */
    private static final int VALUE_PLUS = ASCII_BINARY.length - 1;

    /**
     * Reads the number at the specified position within the image.
     * @param image The image to read the number from.
     * @param index The position of the digit.
     * @return The number that was read.
     */
    private static int readNumber(char[][] image, int index) {
        var binary = 0L;
        for (var row = 0; row < CHAR_HEIGHT; ++row) {
            for (var col = CHAR_WIDTH_PAD * index; col < CHAR_WIDTH_PAD * index + CHAR_WIDTH; ++col) {
                binary <<= 1;
                binary |= image[row][col] == 'x' ? 1 : 0;
            }
        }

        for (var i = 0; i < ASCII_BINARY.length; ++i) {
            if (ASCII_BINARY[i] == binary) {
                return i;
            }
        }

        return Integer.MAX_VALUE;
    }

    /**
     * Writes a number to the specified position within the image.
     * @param image The image to write the number to.
     * @param index The position of the digit.
     * @param value The value to write.
     */
    private static void writeNumber(char[][] image, int index, int value) {
        var binary = ASCII_BINARY[value];
        for (var row = CHAR_HEIGHT - 1; row >= 0; --row) {
            final var startCol = index * CHAR_WIDTH_PAD;
            for (var col = startCol + CHAR_WIDTH - 1; col >= startCol; --col) {
                image[row][col] = ((binary & 1) == 1) ? 'x' : '.';
                binary >>= 1;
            }
        }
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            var image = new char[CHAR_HEIGHT][];
            for (var row = 0; row < CHAR_HEIGHT; ++row) {
                image[row] = sc.next().toCharArray();
            }

            var valueA = 0;
            var valueB = 0;

            var isFirstNumber = true;

            var numChars = 1 + (image[0].length - CHAR_WIDTH) / CHAR_WIDTH_PAD;
            for (var i = 0; i < numChars; ++i) {
                final var value = readNumber(image, i);
                if (value == VALUE_PLUS) {
                    isFirstNumber = false;
                } else if (isFirstNumber) {
                    valueA = (valueA * 10) + value;
                } else {
                    valueB = (valueB * 10) + value;
                }
            }

            var result = valueA + valueB;

            numChars = String.valueOf(result).length();
            image = new char[CHAR_HEIGHT][(CHAR_WIDTH_PAD * (numChars - 1)) + CHAR_WIDTH];
            for (var row = 0; row < CHAR_HEIGHT; ++row) {
                Arrays.fill(image[row], '.');
            }

            for (var i = numChars - 1; i >= 0; --i) {
                writeNumber(image, i, result % 10);
                result /= 10;
            }

            final var b = new StringBuilder();
            for (var row = 0; row < CHAR_HEIGHT; ++row) {
                b.append(image[row]).append('\n');
            }

            System.out.println(b);
        }
    }

}
