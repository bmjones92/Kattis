import java.util.Scanner;

/**
 * Solution to the "Almost Perfect" problem on Kattis.
 * @author Brendan Jones
 */
public class AlmostPerfect {

    private static void processTestCase(Scanner sc) {
        final var number = sc.nextInt();
        final var limit = (int) Math.sqrt(number);

        var sum = 1;
        for (var i = 2; i <= limit; ++i) {
            if (number % i != 0) {
                continue;
            }
            sum += i;

            final var pair = number / i;
            if (pair != i) {
                sum += pair;
            }
        }

        if (number == sum) {
            System.out.println(number + " perfect");
        } else {
            final var difference = Math.abs(number - sum);
            if (difference > 2) {
                System.out.println(number + " not perfect");
            } else {
                System.out.println(number + " almost perfect");
            }
        }
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            while (sc.hasNextInt()) {
                processTestCase(sc);
            }
        }
    }

}
