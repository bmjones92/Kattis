import java.util.HashSet;
import java.util.Scanner;

/**
 * Solution to the "Odd Man Out" problem on Kattis.
 * @author Brendan Jones
 */
public class OddManOut {

    private static void processTestCase(Scanner sc, int id, StringBuilder b) {
        final var numGuests = sc.nextInt();

        final var guests = new HashSet<Integer>();
        for (var i = 0; i < numGuests; ++i) {
            final var uid = sc.nextInt();
            if (!guests.remove(uid)) {
                guests.add(uid);
            }
        }
        b.append("Case #").append(id).append(": ").append(guests.iterator().next()).append('\n');
    }

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            StringBuilder bldr = new StringBuilder();
            int numCases = sc.nextInt();
            for(int i = 0; i < numCases; ++i) {
                processTestCase(sc, i + 1, bldr);
            }
            System.out.print(bldr);
        }
    }

}

