import java.util.Scanner;

public class ProgressiveScramble {

    /**
     * Identifier for encryption mode.
     */
    private static final String MODE_ENCRYPT = "e";

    /**
     * Identifier for decryption mode.
     */
    private static final String MODE_DECRYPT = "d";

    /**
     * Processes a single test case.
     * @param sc The input scanner.
     */
    private static void processTestCase(Scanner sc) {
        final var mode = sc.next();
        final var message = sc.nextLine().substring(1);

        switch (mode) {
            case MODE_ENCRYPT:
                encryptMessage(message);
                break;
            case MODE_DECRYPT:
                decryptMessage(message);
                break;
        }
    }

    /**
     * Encrypts a message.
     * @param message The message to encrypt.
     */
    private static void encryptMessage(String message) {
        final var b = new StringBuilder();

        var number = 0;
        for (var i = 0; i < message.length(); ++i) {
            number += getNumber(message.charAt(i));
            b.append(getSymbol(number % 27));
        }
        System.out.println(b);
    }

    /**
     * Decrypts a message.
     * @param message The message to decrypt.
     */
    private static void decryptMessage(String message) {
        final var b = new StringBuilder();

        var number = 0;
        for (var i = 0; i < message.length(); ++i) {
            var temp = getNumber(message.charAt(i)) - number;
            while (temp < 0) {
                temp += 27;
            }
            number += temp;
            b.append(getSymbol(temp));
        }
        System.out.println(b);
    }

    /**
     * Gets a number for a character.
     * @param ch The character.
     * @return The number.
     */
    private static int getNumber(char ch) {
        return (ch == ' ') ? 0 : (ch - 'a' + 1);
    }

    /**
     * Gets a symbol for a number.
     * @param num The number.
     * @return The symbol.
     */
    private static char getSymbol(int num) {
        return (char) ((num == 0) ? ' ' : (num + 'a' - 1));
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
