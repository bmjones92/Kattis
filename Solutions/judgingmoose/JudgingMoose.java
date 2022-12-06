import java.util.Scanner;

/**
 * Solution to the "Judging Moose" problem on Kattis.
 * @author Brendan Jones
 */
public class JudgingMoose {

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var numLeft = sc.nextInt();
            final var numRight = sc.nextInt();

            if (numLeft == 0 && numRight == 0) {
                System.out.println("Not a moose");
            } else if (numLeft == numRight) {
                System.out.println("Even " + (numLeft * 2));
            } else {
                final var points = Math.max(numLeft, numRight) * 2;
                System.out.println("Odd " + points);
            }
        }
    }

}

