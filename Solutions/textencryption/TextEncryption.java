import java.util.Scanner;

/**
 * Solution to the "Text Encryption" problem on Kattis.
 * @author Brendan Jones
 */
public class TextEncryption {

    /**
     * Process a single test case.
     * @param sc The input scanner.
     * @return {@code true} if another test case follows this one.
     */
    private static boolean processTestCase(Scanner sc, StringBuilder b) {
        final var size = sc.nextInt();
        if (size == 0) {
            return false;
        }

        // We read input one line at a time, so we need to discord the rest of the 'size' line otherwise the first
        // call to 'nextLine' will produce an empty string.
        sc.nextLine();

        final var input = sc.nextLine().toUpperCase().replace(" ", "");

        char[] output = new char[input.length()];

        var currentChar = 0;
        for (int i = 0; i < size; i++) {
            for (int j = i; j < input.length(); j += size) {
                output[j] = input.charAt(currentChar++);
            }
        }

        b.append(output).append('\n');

        return true;
    }

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            final var b = new StringBuilder();
            while(processTestCase(sc, b));
            System.out.print(b);
        }
    }

}
