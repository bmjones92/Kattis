import java.util.Scanner;
import java.util.TreeSet;

/**
 * Solution for the "Candy Division" problem on Kattis.
 * @author Brendan Jones
 */
public class CandyDivision {

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var number = sc.nextLong();

            final var b = new StringBuilder();

            final var factors = new TreeSet<Long>();
            for (var i = 1; i <= Math.sqrt(number); ++i) {
                if (number % i == 0) {
                    b.append(i - 1).append(' ');

                    final var inverse = number / i;
                    if (inverse != i) {
                        factors.add(inverse - 1);
                    }
                }
            }

            factors.forEach(factor -> b.append(factor).append(' '));

            System.out.println(b);
        }
    }

}
