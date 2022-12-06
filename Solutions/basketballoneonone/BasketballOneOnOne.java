import java.util.Scanner;

/**
 * Solution to the "Basketball One-on-One" problem on Kattis.
 * @author Brendan Jones
 */
public class BasketballOneOnOne {

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var scores = new int[2];

            final var input = sc.next();
            for (var i = 0; i < input.length() / 2; ++i) {
                final var scorer = input.charAt(i * 2) - 'A';
                final var points = input.charAt(i * 2 + 1) - '0';

                scores[scorer] += points;
            }

            System.out.println(scores[0] > scores[1] ? "A" : "B");
        }
    }

}