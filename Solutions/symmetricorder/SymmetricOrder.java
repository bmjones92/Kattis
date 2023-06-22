import java.util.ArrayList;
import java.util.Scanner;

/**
 * Solution to the "Symmetric Order" problem on Kattis.
 * @author Brendan Jones
 */
public class SymmetricOrder {

    private static boolean processTestCase(Scanner sc, int caseNumber, StringBuilder b) {
        final var numElements = sc.nextInt();
        if (numElements == 0) {
            return false;
        }

        b.append("SET ").append(caseNumber).append('\n');

        final var names = new ArrayList<String>(numElements);
        for (var i = 0; i < numElements; i++) {
            names.add(sc.next());
        }

        // Add every other name in ascending order.
        for (var i = 0; i < numElements; i += 2) {
            b.append(names.get(i)).append('\n');
        }

        // Add the other half of the names in descending order.
        for (int i = numElements - 1 - (numElements % 2); i > 0; i -= 2) {
            b.append(names.get(i)).append('\n');
        }

        return true;
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var b = new StringBuilder();

            var currentCase = 1;
            while (processTestCase(sc, currentCase++, b));

            System.out.print(b);
        }
    }

}

