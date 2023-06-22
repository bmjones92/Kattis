import java.util.Scanner;

/**
 * Solution to the "Sibice" problem on Kattis.
 * @author Brendan Jones
 */
public class Sibice {

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var numMatches = sc.nextInt();
            final var boxWidth = sc.nextInt();
            final var boxHeight = sc.nextInt();

            final var maxLength = (float) Math.sqrt(boxWidth * boxWidth + boxHeight * boxHeight);
            for (var i = 0; i < numMatches; ++i) {
                final var matchLength = sc.nextFloat();
                System.out.println(matchLength <= maxLength ? "DA" : "NE");
            }
        }
    }

}