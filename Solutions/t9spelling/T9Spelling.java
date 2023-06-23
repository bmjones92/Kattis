import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Solution to the "T9 Spelling" problem on Kattis.
 * @author Brendan Jones
 */
public class T9Spelling {

    /**
     * Maps various characters to the sequence of button presses.
     */
    private static final Map<Character, String> TRANSLATIONS = new HashMap<>();

    static {
        TRANSLATIONS.put(' ', "0");

        TRANSLATIONS.put('a', "2");
        TRANSLATIONS.put('b', "22");
        TRANSLATIONS.put('c', "222");

        TRANSLATIONS.put('d', "3");
        TRANSLATIONS.put('e', "33");
        TRANSLATIONS.put('f', "333");

        TRANSLATIONS.put('g', "4");
        TRANSLATIONS.put('h', "44");
        TRANSLATIONS.put('i', "444");

        TRANSLATIONS.put('j', "5");
        TRANSLATIONS.put('k', "55");
        TRANSLATIONS.put('l', "555");

        TRANSLATIONS.put('m', "6");
        TRANSLATIONS.put('n', "66");
        TRANSLATIONS.put('o', "666");

        TRANSLATIONS.put('p', "7");
        TRANSLATIONS.put('q', "77");
        TRANSLATIONS.put('r', "777");
        TRANSLATIONS.put('s', "7777");

        TRANSLATIONS.put('t', "8");
        TRANSLATIONS.put('u', "88");
        TRANSLATIONS.put('v', "888");

        TRANSLATIONS.put('w', "9");
        TRANSLATIONS.put('x', "99");
        TRANSLATIONS.put('y', "999");
        TRANSLATIONS.put('z', "9999");
    }

    /**
     * Process a single test case.
     * @param sc The input scanner.
     * @param b The output builder.
     */
    private static void processTestCase(Scanner sc, StringBuilder b) {
        final var line = sc.nextLine();

        var lastButton = '\0';
        for (var ch : line.toCharArray()) {
            final var input = TRANSLATIONS.get(ch);

            // Sequential inputs that use the same button should be separated by a space.
            final var button = input.charAt(0);
            if (button == lastButton) {
                b.append(' ');
            }
            b.append(input);

            lastButton = button;
        }
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var b = new StringBuilder();

            final var numCases = sc.nextInt();

            // Each test case reads a line from the scanner, so discard the remainder of the number of cases line.
            sc.nextLine();

            for (var i = 0; i < numCases; i++) {
                b.append("Case #").append(i + 1).append(": ");
                processTestCase(sc, b);
                b.append('\n');
            }

            System.out.print(b);
        }
    }

}