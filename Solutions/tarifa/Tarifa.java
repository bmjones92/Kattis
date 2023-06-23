import java.util.Scanner;

/**
 * Solution to the "Tarifa" problem on Kattis.
 * @author Brendan Jones
 */
public class Tarifa {

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            var totalRemaining = 0;

            final var maxPerMonth = sc.nextInt();
            final var numMonths = sc.nextInt();

            for (var i = 0; i < numMonths; ++i) {
                final var spent = sc.nextInt();
                totalRemaining += (maxPerMonth - spent);
            }

            totalRemaining += maxPerMonth;
            System.out.println(totalRemaining);
        }
    }

}

