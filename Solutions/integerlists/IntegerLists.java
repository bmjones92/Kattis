import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * Solution to the "Integer Lists" problem on Kattis.
 * @author Brendan Jones
 */
public class IntegerLists {

    /**
     * Processes a single test case from input.
     * @param sc The input Scanner.
     */
    private static void processTestCase(Scanner sc) {
        final var commands = sc.next();
        final var list = createList(sc);
        var isReversed = false;

        // Parse the commands.
        for (var ch : commands.toCharArray()) {
            switch (ch) {
                case 'R':
                    isReversed = !isReversed;
                    break;
                case 'D':
                    if (list.isEmpty()) {
                        System.out.println("error");
                        return;
                    } else if (isReversed) {
                        list.removeLast();
                    } else {
                        list.removeFirst();
                    }
                    break;
            }
        }

        // Build the output string.
        final var b = new StringBuilder("[");
        final var it = isReversed ? list.descendingIterator() : list.iterator();
        while (it.hasNext()) {
            b.append(it.next());
            if (it.hasNext()) {
                b.append(',');
            }
        }
        System.out.println(b.append(']'));
    }

    /**
     * Reads an integer list from the Scanner.
     * @param sc The Scanner.
     * @return The parsed list.
     */
    private static ArrayDeque<Integer> createList(Scanner sc) {
        final var size = sc.nextInt();
        final var line = sc.next();

        final var list = new ArrayDeque<Integer>(size);
        if (size > 0) {
            var num = 0;
            for (var ch : line.toCharArray()) {
                if (Character.isDigit(ch)) {
                    num = (num * 10) + (ch - '0');
                } else if (ch != '[') {
                    list.add(num);
                    num = 0;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            var numTestCases = sc.nextInt();
            for (var i = 0; i < numTestCases; ++i) {
                processTestCase(sc);
            }
        }
    }
}
