import java.util.Scanner;

/**
 * Solution to the "Rijeci" problem on Kattis.
 * @author Brendan Jones
 */
public class Rijeci {

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            var oldCount = 0;
            var newCount = 1;

            final var numPresses = sc.nextInt();
            for (var i = 0; i < numPresses - 1; ++i) {
                final var temp = oldCount + newCount;
                oldCount = newCount;
                newCount = temp;
            }
            System.out.println(oldCount + " " + newCount);
        }
    }

}