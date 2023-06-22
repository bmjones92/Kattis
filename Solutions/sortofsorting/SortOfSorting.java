import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Solution to the "Sort of Sorting" problem on Kattis.
 * @author Brendan Jones
 */
public class SortOfSorting {

    /**
     * Comparator for sorting words.
     */
    private static final Comparator<String> COMPARATOR = Comparator
            .<String>comparingInt(a -> a.charAt(0))
            .thenComparingInt(a -> a.charAt(1));

    /**
     * Processes a single test case.
     * @param sc The input scanner.
     * @return {@code true} if another test case follows this one.
     */
    private static boolean processTestCase(Scanner sc) {
        final var numNames = sc.nextInt();
        if (numNames == 0) {
            return false;
        }

        // Populate the list of names.
        final var names = new ArrayList<String>(numNames);
        for (var i = 0; i < numNames; i++) {
            names.add(sc.next());
        }

        // Build the output string. We use a StringBuilder here because it's significantly faster than separate
        // print calls for every name.
        final var b = new StringBuilder();
        names.stream().sorted(COMPARATOR).forEach(name -> b.append(name).append('\n'));

        System.out.println(b);

        return true;
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            while (processTestCase(sc));
        }
    }

}