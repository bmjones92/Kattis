import java.util.Scanner;

/**
 * Solution to the "Daylight Savings Time" problem on Kattis.
 * @author Brendan Jones
 */
public class DST {

    private static void processTestCase(Scanner sc) {
        final var direction = sc.next().charAt(0);

        final var delta = sc.nextInt();
        var hours = sc.nextInt();
        var minutes = sc.nextInt();

        if (direction == 'F') {
            // Forward
            minutes += delta;
            while (minutes >= 60) {
                minutes -= 60;
                if (++hours == 24) {
                    hours = 0;
                }
            }
        } else if (direction == 'B') {
            // Backward
            minutes -= delta;
            while (minutes < 0) {
                minutes += 60;
                if (--hours == -1) {
                    hours = 23;
                }
            }
        }

        System.out.println(hours + " " + minutes);
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var numTestCases = sc.nextInt();
            for (var i = 0; i < numTestCases; ++i) {
                processTestCase(sc);
            }
        }
    }

}

