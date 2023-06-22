import java.util.Scanner;

/**
 * Solution to the "Soylent" problem on Kattis.
 * @author Brendan Jones
 */
public class Soylent {

    /**
     * The number of calories in a bottle.
     */
    private static final double CALORIES_PER_BOTTLE = 400.0;

    public static void main(String[] args) {
        final var sc = new Scanner(System.in);
        final var numTestCases = sc.nextInt();

        final var b = new StringBuilder();

        for (var i = 0; i < numTestCases; ++i) {
            final var requiredCalories = sc.nextInt();
            b.append((int) Math.ceil(requiredCalories / CALORIES_PER_BOTTLE)).append('\n');
        }

        System.out.print(b);
    }

}