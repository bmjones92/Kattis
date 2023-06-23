import java.util.Scanner;

/**
 * Solution to the "Timebomb" problem on Kattis.
 * @author Brendan Jones
 */
public class Timebomb {

    /**
     * Binary representations of the ASCII digits.
     */
    private static final int[] ASCII_DIGITS = {
            0b111101101101111, // 0
            0b001001001001001, // 1
            0b111001111100111, // 2
            0b111001111001111, // 3
            0b101101111001001, // 4
            0b111100111001111, // 5
            0b111100111101111, // 6
            0b111001001001001, // 7
            0b111101111101111, // 8
            0b111101111001111, // 9
    };

    /**
     * Extracts a binary digit from the display.
     * @param lines The lines of the display.
     * @param index The index of the digit to extract.
     * @return The extracted digit.
     */
    private static int extractDigit(String[] lines, int index) {
        var digitCode = 0;
        for (var row = 0; row < 5; ++row) {
            for (var col = index * 4; col < index * 4 + 3; ++col) {
                digitCode = digitCode << 1 | ((lines[row].charAt(col) == '*') ? 1 : 0);
            }
        }

        for (var i = 0; i < 10; ++i) {
            if (ASCII_DIGITS[i] == digitCode) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var lines = new String[5];
            for (var i = 0; i < lines.length; ++i) {
                lines[i] = sc.nextLine();
            }

            var bombCode = 0;

            // Each digit is 3 columns wide and separated by a space.
            final var numDigits = (lines[0].length() + 1) / 4;
            for (var i = 0; i < numDigits; ++i) {
                final var digit = extractDigit(lines, i);
                if (digit == -1) {
                    bombCode = -1;
                    break;
                }
                bombCode = bombCode * 10 + digit;
            }

            if (bombCode % 6 != 0) {
                System.out.println("BOOM!!");
            } else {
                System.out.println("BEER!!");
            }
        }
    }

}

