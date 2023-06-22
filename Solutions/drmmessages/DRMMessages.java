import java.util.Arrays;
import java.util.Scanner;

/**
 * Solution to the "DRM Messages".
 */
public class DRMMessages {

    /**
     * Processes a single test case.
     * @param sc The input Scanner.
     */
    private static void processTestCase(Scanner sc) {
        final var message = sc.next().toCharArray();

        final var halfA = Arrays.copyOfRange(message, 0, message.length / 2);
        final var halfB = Arrays.copyOfRange(message, message.length / 2, message.length);

        rotate(halfA);
        rotate(halfB);

        final var b = new StringBuilder();
        for (var i = 0; i < halfA.length; ++i) {
            b.append((char) ('A' + ((halfA[i] + halfB[i]) % 26)));
        }

        System.out.println(b);
    }

    /**
     * Rotates the message values.
     * @param chars The characters to rotate.
     */
    private static void rotate(char[] chars) {
        var rotation = 0;
        for (final var c : chars) {
            rotation += c - 'A';
        }

        for (var i = 0; i < chars.length; ++i) {
            chars[i] = (char) ((chars[i] + rotation) % 26);
        }
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            processTestCase(sc);
        }
    }

}