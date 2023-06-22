import java.util.Arrays;
import java.util.Scanner;

/**
 * Solution to the "Sum of the Others" problem on Kattis.
 * @author Brendan Jones
 */
public class SumOfTheOthers {

    private static void processTestCase(Scanner sc) {
        // No way to read individual integers until the end of the line, so we need to read the entire line and parse
        // each number manually.
        final var tokens = sc.nextLine().split(" ");

        final var elements = Arrays.stream(tokens)
                .mapToInt(Integer::parseInt)
                .toArray();

        final var sum = Arrays.stream(elements)
                .sum();

        // Find the first element that is the sum of the others and print it out.
        Arrays.stream(elements)
                .filter(element -> sum - element == element)
                .findFirst()
                .ifPresent(System.out::println);
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            while (sc.hasNext()) {
                processTestCase(sc);
            }
        }
    }

}