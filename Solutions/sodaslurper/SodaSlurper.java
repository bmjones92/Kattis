import java.util.Scanner;

/**
 * Solution to the "Soda Slurper" problem on Kattis.
 * @author Brendan Jones
 */
public class SodaSlurper {

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var numEmpty = sc.nextInt();
            final var numFound = sc.nextInt();
            final var numRequired = sc.nextInt();

            var totalDrank = 0;

            var numCurrent = (numEmpty + numFound);
            while (numCurrent >= numRequired) {
                final var numDrank = numCurrent / numRequired;
                totalDrank += numDrank;
                numCurrent = (numCurrent % numRequired) + numDrank;
            }

            System.out.println(totalDrank);
        }
    }

}

