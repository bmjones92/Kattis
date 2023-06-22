import java.util.Scanner;

/**
 * Solution to the "Pervasive Heart Monitor" problem on Kattis.
 * @author Brendan Jones
 */
public class PervasiveHeartMonitor {

    public static void processTestCase(Scanner sc) {
        final var b = new StringBuilder();

        var score = 0.0;
        var numScores = 0;

        while (sc.hasNext()) {
            if (sc.hasNextDouble()) {
                score += sc.nextDouble();
                numScores++;
            } else {
                final var name = sc.next();
                b.append(' ').append(name);
            }
        }
        b.insert(0, score / numScores);

        System.out.println(b);
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            while (sc.hasNextLine()) {
                final var line = sc.nextLine();
                processTestCase(new Scanner(line));
            }
        }
    }

}
