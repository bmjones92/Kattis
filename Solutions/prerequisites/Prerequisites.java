import java.util.HashSet;
import java.util.Scanner;

/**
 * Solution to the "Prerequisites?" problem on Kattis.
 * @author Brendan Jones
 */
public class Prerequisites {

    /**
     * Processes a single test case.
     * @param sc The input scanner.
     * @return Whether another test case follows.
     */
    private static boolean processTestCase(Scanner sc) {
        final var numSelectedCourses = sc.nextInt();
        if (numSelectedCourses == 0) {
            return false;
        }

        final var numCategories = sc.nextInt();

        final var selectedCourses = new HashSet<Integer>();
        for (var i = 0; i < numSelectedCourses; ++i) {
            selectedCourses.add(sc.nextInt());
        }

        var hasRequirements = true;
        for (var i = 0; i < numCategories; ++i) {
            final var numAvailable = sc.nextInt();
            final var numRequired = sc.nextInt();

            var taken = 0;
            for (var j = 0; j < numAvailable; ++j) {
                final var course = sc.nextInt();
                if (selectedCourses.contains(course)) {
                    taken++;
                }
            }

            if (taken < numRequired) {
                hasRequirements = false;
            }
        }
        System.out.println(hasRequirements ? "yes" : "no");
        return true;
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            while (processTestCase(sc));
        }
    }

}