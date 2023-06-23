import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Solution to the "Un-bear-able Zoo" problem on Kattis.
 * @author Brendan Jones
 */
public class Zoo {

    /**
     * Processes a single test case.
     * @param sc The input scanner.
     * @param b The output builder.
     * @param id The test id.
     * @return {@code true} if another case follows this one.
     */
    private static boolean processTestCase(Scanner sc, StringBuilder b, int id) {
        final var numAnimals = sc.nextInt();
        if (numAnimals == 0) {
            return false;
        }

        // Discard the remainder of the line.
        sc.nextLine();

        final var animals = new TreeMap<String, Integer>();

        for (var i = 0; i < numAnimals; ++i) {
            var type = sc.nextLine();

            final var lastSpaceIndex = type.lastIndexOf(' ');
            if (lastSpaceIndex != -1) {
                type = type.substring(lastSpaceIndex + 1);
            }
            type = type.toLowerCase();

            var count = animals.get(type);
            if (count == null) {
                count = 0;
            }
            animals.put(type, count + 1);
        }

        b.append("List ").append(id).append(":\n");
        for (final var entry : animals.entrySet()) {
            b.append(entry.getKey()).append(" | ").append(entry.getValue()).append('\n');
        }

        return true;
    }

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            final var b = new StringBuilder();

            int id = 1;
            while(processTestCase(sc, b, id++));

            System.out.print(b);
        }
    }

}
