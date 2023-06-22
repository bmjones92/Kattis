import java.util.Scanner;

/**
 * Solution to the "Periodic Strings" problem on Kattis.
 * @author Brendan Jones
 */
public class PeriodicStrings {

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var input = sc.nextLine();

            var period = 1;
            while (period < input.length()) {
                if (input.length() % period == 0 && check(input, period)) {
                    break;
                }
                period++;
            }

            System.out.println(period);
        }
    }

    private static boolean check(String input, int period) {
        var index = period - 1;
        for (var i = period; i < input.length(); ++i) {
            if (input.charAt(index) != input.charAt(i)) {
                return false;
            }

            if (i % period != period - 1) {
                index = (index + 1) % period;
            }
        }
        return true;
    }

}

