import java.util.Scanner;
import java.util.TreeSet;

/**
 * Solution to the "Bus Numbers" problem on Kattis.
 * @author Brendan Jones
 */
public class BusNumbers {

    private static void printRange(StringBuilder b, int begin, int end) {
        b.append(begin);
        if (begin != end) {
            b.append((end - begin < 2) ? ' ' : '-');
            b.append(end);
        }
        b.append(' ');
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var numBuses = sc.nextInt();

            final var numbers = new TreeSet<Integer>();
            for (var i = 0; i < numBuses; ++i) {
                numbers.add(sc.nextInt());
            }

            final var b = new StringBuilder();

            var rangeBegin = Integer.MIN_VALUE;
            var rangeEnd = Integer.MIN_VALUE;
            for (int number : numbers) {
                if (rangeBegin == Integer.MIN_VALUE) {
                    rangeBegin = number;
                    rangeEnd = number;
                } else if (rangeEnd + 1 == number) {
                    rangeEnd = number;
                } else {
                    printRange(b, rangeBegin, rangeEnd);
                    rangeBegin = number;
                    rangeEnd = number;
                }
            }

            printRange(b, rangeBegin, rangeEnd);

            System.out.println(b);
        }
    }

}

