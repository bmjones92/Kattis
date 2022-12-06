import java.util.Scanner;

/**
 * Solution to the "Alien Numbers" problem on Kattis.
 * @author Brendan Jones
 */
public class AlienNumbers {

    /**
     * Processes a single test case.
     * @param sc The scanner.
     * @param caseNumber The case number.
     */
    private static void processTestCase(Scanner sc, int caseNumber) {
        final var number = sc.next();
        final var source = sc.next();
        final var target = sc.next();

        final var result = encode(target, decode(source, number));
        System.out.println("Case #" + caseNumber + ": " + result);
    }

    /**
     * Decodes a number represented in the specified language.
     * @param language The language to decode the number in.
     * @param number The number to decode.
     * @return The decoded number.
     */
    private static int decode(String language, String number) {
        var decimal = 0;

        for (var i = 0; i < number.length(); i++) {
            decimal *= language.length();
            decimal += language.indexOf(number.charAt(i));
        }

        return decimal;
    }

    /**
     * Encodes a number into the target language.
     * @param language The language to encode the number in.
     * @param decimal The number to encode.
     * @return The encoded number.
     */
    private static String encode(String language, int decimal) {
        final var b = new StringBuilder();
        while (decimal > 0) {
            final var index = decimal % language.length();
            b.append(language.charAt(index));

            decimal /= language.length();
        }
        return b.reverse().toString();
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var numTestCases = sc.nextInt();
            for (var i = 0; i < numTestCases; ++i) {
                processTestCase(sc, i + 1);
            }
        }
    }

}

