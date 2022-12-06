import java.util.HashSet;
import java.util.Scanner;

/**
 * Solution to the "Boat Parts" problem on Kattis.
 * @author Brendan Jones
 */
public class BoatParts {

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var numParts = sc.nextInt();
            final var numDays = sc.nextInt();

            final var replacedParts = new HashSet<String>();
            for (var i = 1; i <= numDays; ++i) {
                replacedParts.add(sc.next());
                if (replacedParts.size() == numParts) {
                    System.out.println(i);
                    return;
                }
            }

            System.out.println("paradox avoided");
        }
    }

}