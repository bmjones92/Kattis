import java.util.Arrays;
import java.util.Scanner;

/**
 * Solution to the "Veci" problem on Kattis.
 * @author Brendan Jones
 */
public class Veci {

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var number = sc.next();

            // Store each digit in an array.
            final var digits = new int[number.length()];
            for (var i = 0; i < number.length(); ++i) {
                digits[i] = number.charAt(i) - '0';
            }

            // The algorithm starts from the right and works its way left, swapping the first two elements that are out
            // of place (ascending), then sorts the subset of the array that come after the swap.
            for(var i = digits.length - 1; i > 0; --i) {
                // Current digit is less/equal to the previous digit.
                if (digits[i] <= digits[i - 1]) {
                    continue;
                }

                // Track the digit before the first one.
                final var x = digits[i - 1];
                var smallest = i;

                for (var j = i + 1; j < digits.length; ++j) {
                    if (digits[j] > x && digits[j] < digits[smallest]) {
                        smallest = j;
                    }
                }

                // Swap the two digits.
                {
                    final var temp = digits[smallest];
                    digits[smallest] = digits[i - 1];
                    digits[i - 1] = temp;
                }

                // Sort the digits after the swap.
                Arrays.sort(digits, i, digits.length);

                // Construct the output.
                final var b = new StringBuilder();
                for (final var digit : digits) {
                    b.append(digit);
                }

                // Print the output.
                System.out.println(b);
                return;
            }

            // No solution has been found.
            System.out.println(0);
        }
    }

}

