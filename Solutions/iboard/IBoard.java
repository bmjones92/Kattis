import java.util.Scanner;

/**
 * Solution to the "iBoard" problem on Kattis.
 * @author Brendan Jones
 */
public class IBoard {

    /**
     * Processes a single test case.
     * @param sc The input scanner.
     */
    private static void processTestCase(Scanner sc) {
        final var line = sc.nextLine();

        final var isPressed = new boolean[2];
        for (final var ch : line.toCharArray()) {
            for (var i = 0; i < 7; ++i) {
                final var button = (ch >> i) % 2;
                isPressed[button] = !isPressed[button];
            }
        }

        if (isPressed[0] || isPressed[1]) {
            System.out.println("trapped");
        } else {
            System.out.println("free");
        }
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            while (sc.hasNextLine()) {
                processTestCase(sc);
            }
        }
    }

}
