import java.util.Scanner;

/**
 * Solution to the "Mars Window" problem on Kattis.
 * @author Brendan Jones
 */
public class MarsWindow {

    /**
     * The month to start at - April 2018.
     */
    private static final int START_MONTH = 2018 * 12 + 3;

    /**
     * How many months between optimal launch windows.
     */
    private static final int PERIOD = 26;

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var year = sc.nextInt();

            final var start = (year * 12) - START_MONTH;
            final var end = (start + 11);

            if (year == 2018 || (start % PERIOD) > (end % PERIOD)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }

        }
    }

}

