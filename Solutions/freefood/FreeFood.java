import java.util.Arrays;
import java.util.Scanner;

/**
 * Solution to the "Free Food" problem on Kattis.
 * @author Brendan Jones
 */
public class FreeFood {

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var numEvents = sc.nextInt();

            final var days = new int[365];
            for (var i = 0; i < numEvents; ++i) {
                final var start = sc.nextInt();
                final var end = sc.nextInt();
                Arrays.fill(days, start - 1, end, 1);
            }

            var sum = 0;
            for (final var day : days) {
                sum += day;
            }

            System.out.println(sum);
        }
    }

}

