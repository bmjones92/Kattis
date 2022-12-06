import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Solution to the "False Sense of Security" problem on Kattis.
 * @author Brendan Jones
 */
public class FalseSecurity {

    private static final Map<Character, String> CHAR_TO_MORSE = new HashMap<>();

    private static final Map<String, Character> MORSE_TO_CHAR = new HashMap<>();

    static {
        CHAR_TO_MORSE.put('A', ".-");
        CHAR_TO_MORSE.put('B', "-...");
        CHAR_TO_MORSE.put('C', "-.-.");
        CHAR_TO_MORSE.put('D', "-..");
        CHAR_TO_MORSE.put('E', ".");
        CHAR_TO_MORSE.put('F', "..-.");
        CHAR_TO_MORSE.put('G', "--.");
        CHAR_TO_MORSE.put('H', "....");
        CHAR_TO_MORSE.put('I', "..");
        CHAR_TO_MORSE.put('J', ".---");
        CHAR_TO_MORSE.put('K', "-.-");
        CHAR_TO_MORSE.put('L', ".-..");
        CHAR_TO_MORSE.put('M', "--");
        CHAR_TO_MORSE.put('N', "-.");
        CHAR_TO_MORSE.put('O', "---");
        CHAR_TO_MORSE.put('P', ".--.");
        CHAR_TO_MORSE.put('Q', "--.-");
        CHAR_TO_MORSE.put('R', ".-.");
        CHAR_TO_MORSE.put('S', "...");
        CHAR_TO_MORSE.put('T', "-");
        CHAR_TO_MORSE.put('U', "..-");
        CHAR_TO_MORSE.put('V', "...-");
        CHAR_TO_MORSE.put('W', ".--");
        CHAR_TO_MORSE.put('X', "-..-");
        CHAR_TO_MORSE.put('Y', "-.--");
        CHAR_TO_MORSE.put('Z', "--..");
        CHAR_TO_MORSE.put('_', "..--");
        CHAR_TO_MORSE.put('.', "---.");
        CHAR_TO_MORSE.put(',', ".-.-");
        CHAR_TO_MORSE.put('?', "----");

        CHAR_TO_MORSE.forEach((key, value) -> MORSE_TO_CHAR.put(value, key));
    }

    /**
     * Processes a single test case.
     * @param encodedMessage The message to process.
     */
    private static void processTestCase(String encodedMessage) {
        final var messageBuilder = new StringBuilder();
        final var countBuilder = new StringBuilder();

        for (int i = 0; i < encodedMessage.length(); ++i) {
            messageBuilder.append(CHAR_TO_MORSE.get(encodedMessage.charAt(i)));
            countBuilder.append(CHAR_TO_MORSE.get(encodedMessage.charAt(encodedMessage.length() - i - 1)).length());
        }

        final var tempMessage = messageBuilder.toString();
        final var count = countBuilder.toString();

        // Reset the message builder.
        messageBuilder.setLength(0);

        var index = 0;
        for (var i = 0; i < count.length(); ++i) {
            final var length = count.charAt(i) - '0';

            final var morse = tempMessage.substring(index, index + length);
            messageBuilder.append(MORSE_TO_CHAR.get(morse));

            index += length;
        }

        System.out.println(messageBuilder);

    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            while (sc.hasNext()) {
                processTestCase(sc.next());
            }
        }
    }

}
