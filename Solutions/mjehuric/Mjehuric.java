import java.util.Scanner;

/**
 * Solution to the "Mjehuric" problem on Kattis.
 * @author Brendan Jones
 */
public class Mjehuric {

    /**
     * Length of the input array.
     */
    private static final int ARRAY_SIZE = 5;

    /**
     * Checks if the input array consists of positive integers in ascending order, without gaps, starting from 1.
     * @param array The input array.
     * @return Whether the array meets the conditions specified above.
     */
    private static boolean isSorted(int[] array) {
        for (var i = 0; i < array.length; ++i) {
            if (array[i] != i + 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var numbers = new int[ARRAY_SIZE];
            for(int i = 0; i < ARRAY_SIZE; ++i) {
                numbers[i] = sc.nextInt();
            }

            final var bldr = new StringBuilder();
            while (!isSorted(numbers)) {
                for (var i = 0; i < ARRAY_SIZE - 1; ++i) {
                    if (numbers[i] > numbers[i + 1]) {
                        final var temp = numbers[i];
                        numbers[i] = numbers[i + 1];
                        numbers[i + 1] = temp;

                        for (final var value : numbers) {
                            bldr.append(value).append(' ');
                        }
                        bldr.append('\n');
                    }
                }
            }

            System.out.print(bldr);
        }
    }

}

