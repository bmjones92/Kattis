import java.util.Scanner;

/**
 * Solution to the "Zamka" problem on Kattis.
 * @author Brendan Jones
 */
public class Zamka {

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var lowerBound = sc.nextInt();
            final var upperBound = sc.nextInt();
            final var targetSum = sc.nextInt();

            // Solve for the minimal digit N.
            for (var i = lowerBound; i <= upperBound; i++) {
                var sum = 0;
                var temp = i;
                while (temp != 0) {
                    sum += temp % 10;
                    temp /= 10;
                }

                if (sum == targetSum) {
                    System.out.println(i);
                    break;
                }
            }

            // Solve for the maximal digit M.
            for (var i = upperBound; i >= lowerBound; i--) {
                var sum = 0;
                var temp = i;
                while (temp != 0) {
                    sum += temp % 10;
                    temp /= 10;
                }

                if(sum == targetSum) {
                    System.out.println(i);
                    break;
                }
            }
        }
    }

}
