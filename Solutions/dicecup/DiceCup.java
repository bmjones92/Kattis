import java.util.Scanner;

/**
 * Solution to the "Dice Cup" problem on Kattis.
 * @author Brendan Jones
 */
public class DiceCup {

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var a = sc.nextInt();
            final var b = sc.nextInt();

            final var min = Math.min(a, b) + 1;
            final var max = Math.max(a, b) + 1;

            for (var i = min; i <= max; ++i) {
                System.out.println(i);
            }
        }
    }

}

