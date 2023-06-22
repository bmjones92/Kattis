import java.util.HashSet;
import java.util.Scanner;

/**
 * Solution to the "Booking a Room" problem on Kattis.
 * @author Brendan Jones
 */
public class BookingARoom {

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var numRooms = sc.nextInt();
            final var numBooked = sc.nextInt();

            if (numRooms == numBooked) {
                System.out.println("too late");
                return;
            }

            final var values = new HashSet<Integer>();
            for (var i = 1; i <= numRooms; ++i) {
                values.add(i);
            }

            for (var i = 0; i < numBooked; ++i) {
                values.remove(sc.nextInt());
            }

            System.out.println(values.iterator().next());
        }
    }

}

