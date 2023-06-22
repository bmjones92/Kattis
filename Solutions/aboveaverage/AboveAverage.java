import java.util.ArrayList;
import java.util.Scanner;

/**
 * Solution to the "Above Average" problem on Kattis.
 * @author Brendan Jones
 */
public class AboveAverage {

    private static void processTestCase(Scanner sc) {
        final var scores = new ArrayList<Integer>();

        var total = 0L;

        final var numScores = sc.nextInt();
        for (var i = 0; i < numScores; ++i) {
            final var grade = sc.nextInt();
            scores.add(grade);
            total += grade;
        }

        final var avg = (float) total / numScores;
        final var count = scores.stream().filter((score) -> score > avg).count();
        final var percent = ((float) count / numScores) * 100.0f;

        System.out.printf("%.3f%%%n", percent);
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            var numTestCases = sc.nextInt();
            for (var i = 0; i < numTestCases; ++i) {
                processTestCase(sc);
            }
        }
    }

}