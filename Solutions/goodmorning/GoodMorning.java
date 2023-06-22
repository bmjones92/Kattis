import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Solution to the "Good Morning!" problem on Kattis.
 * @author Brendan Jones
 */
public class GoodMorning {

    private static final List<Integer> values = Arrays.asList(
            0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
            10, 11, 12, 13, 14, 15, 16, 17, 18, 19,
            20, 22, 23, 25, 26, 28, 29, 33, 36, 39,
            40, 44, 45, 46, 47, 48, 49, 50, 55, 56,
            58, 59, 66, 69, 70, 77, 78, 79, 80, 88,
            89, 99, 100, 110, 111, 112, 113, 114, 115,
            116, 117, 118, 119, 120, 122, 123, 125, 126,
            128, 129, 133, 136, 139, 140, 144, 145, 146,
            147, 148, 149, 150, 155, 156, 158, 159, 166,
            169, 170, 177, 178, 179, 180, 188, 189, 199, 200
    );

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var numTestCases = sc.nextInt();
            for (var i = 0; i < numTestCases; ++i) {
                System.out.println(calculateClosest(sc.nextInt()));
            }
        }
    }

    private static int calculateClosest(int value) {
        var index = Collections.binarySearch(values, value);
        if (index >= 0) {
            return value;
        } else {
            index = ~index;
            if (index == 0) {
                return values.get(0);
            } else if (index == values.size()) {
                return values.get(values.size() - 1);
            } else {
                final var a = values.get(index - 1);
                final var b = values.get(index);
                return Math.abs(value - a) < Math.abs(value - b) ? a : b;
            }
        }
    }

}