import java.util.Arrays;
import java.util.Scanner;

/**
 * Solution to the "Permuted Arithmetic Sequence" problem on Kattis.
 * @author Brendan Jones
 */
public class PermutedArithmeticSequence {

    /**
     * Processes a single test case.
     * @param sc The input scanner.
     */
    private static void processTestCase(Scanner sc) {
        final var size = sc.nextInt();

        final var numbers = new int[size];
        for (var i = 0; i < size; ++i) {
            numbers[i] = sc.nextInt();
        }

        if (isArithmeticSequence(numbers)) {
            System.out.println("arithmetic");
        } else {
            Arrays.sort(numbers);
            if (isArithmeticSequence(numbers)) {
                System.out.println("permuted arithmetic");
            } else {
                System.out.println("non-arithmetic");
            }
        }
    }

    private static boolean isArithmeticSequence(int[] nums) {
        final var step = nums[1] - nums[0];
        for (var i = 2; i < nums.length; ++i) {
            if (nums[i] - nums[i - 1] != step) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var numTestCases = sc.nextInt();
            for (var i = 0; i < numTestCases; ++i) {
                processTestCase(sc);
            }
        }
    }

}
