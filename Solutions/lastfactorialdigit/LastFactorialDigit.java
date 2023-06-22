import java.util.Scanner;

/**
 * Solution to the "Last Factorial Digit" problem on Kattis.
 * @author Brendan Jones
 */
public class LastFactorialDigit {

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var numEntries = sc.nextInt();
            for (var i = 0; i < numEntries; ++i) {
                final var result = calculateFactorial(sc.nextInt()) % 10;
                System.out.println(result);
            }
        }
    }

    private static int calculateFactorial(int num) {
        var result = 1;
        for (var i = 1; i <= num; ++i) {
            result *= i;
        }
        return result;
    }

}
