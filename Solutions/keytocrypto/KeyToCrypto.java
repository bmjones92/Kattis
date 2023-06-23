import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Solution to the "The Key to Cryptography" problem on Kattis.
 * @author Brendan Jones
 */
public class KeyToCrypto {

    /**
     * Create a decoder.
     * @param key The key.
     * @return The key decoder.
     */
    private static Queue<Character> createDecoder(String key) {
        final var queue = new LinkedList<Character>();
        key.chars().forEach(i -> queue.add((char) i));
        return queue;
    }

    /**
     * Process a single test case.
     * @param sc The input scanner.
     */
    private static void processTestCase(Scanner sc) {
        final var message = sc.next();
        final var key = createDecoder(sc.next());

        final var b = new StringBuilder();
        message.chars().forEach(ch -> {
            var next = (char) ((ch - key.remove()) + 'A');
            if (next < 'A') {
                next += 26;
            }

            key.add(next);
            b.append(next);
        });

        System.out.println(b);
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            processTestCase(sc);
        }
    }

}

