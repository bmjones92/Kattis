import java.util.Scanner;

/**
 * Solution to the "Oktalni" problem on Kattis.
 * @author Brendan Jones
 */
public class Oktalni {

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var line = sc.next();

            final var b = new StringBuilder();

            // Read the first octal digit.
            final var remainder = (line.length() % 3);
            if (remainder != 0) {
                var value = 0;
                for (var i = 0; i < remainder; ++i) {
                    value |= line.charAt(i) - '0';
                    value <<= 1;
                }
                value >>= 1;

                b.append(value);
            }

            // Read the remaining digits.
            var value = 0;
            for (var i = remainder; i < line.length(); ++i) {
                value |= line.charAt(i) - '0';
                if (i != remainder && (i + 1) % 3 == remainder) {
                    b.append(value);
                    value = 0;
                } else {
                    value <<= 1;
                }
            }
            System.out.println(b);
        }
    }

}