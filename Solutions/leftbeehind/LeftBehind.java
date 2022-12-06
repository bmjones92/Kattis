import java.util.Scanner;

/**
 * Solution to the "Left Beehind" problem on Kattis.
 * @author Brendan Jones
 */
public class LeftBeehind {

    /**
     * Processes a single test case.
     * @param sc The input Scanner.
     * @return
     */
    private static boolean processTestCase(Scanner sc) {
        final var numSweet = sc.nextInt();
        final var numSour = sc.nextInt();
        if (numSweet == 0 && numSour == 0) {
            return false;
        }

        if (numSweet + numSour == 13) {
            System.out.println("Never speak again.");
        } else if (numSweet > numSour) {
            System.out.println("To the convention.");
        } else if (numSweet < numSour) {
            System.out.println("Left beehind.");
        } else {
            System.out.println("Undecided.");
        }

        return true;
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            while (processTestCase(sc));
        }
    }

}
