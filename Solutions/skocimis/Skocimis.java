import java.util.Scanner;

/**
 * Solution to the "Skocimis" problem on Kattis.
 * @author Brendan Jones
 */
public class Skocimis {

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var a = sc.nextInt();
            final var b = sc.nextInt();
            final var c = sc.nextInt();

            final var min = Math.min(a, Math.min(b, c));
            final var max = Math.max(a, Math.max(b, c));
            final var mid = (a != max && a != min) ? a : (b != max && b != min) ? b : c;

            var numMoves = 0;
            if (max - mid < mid - min) {
                numMoves = (mid - min) - 1;
            } else {
                numMoves = (max - mid) - 1;
            }

            System.out.println(numMoves);
        }
    }

}

