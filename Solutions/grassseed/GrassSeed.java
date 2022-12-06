import java.util.Scanner;

/**
 * Solution to the "Grass Seed Inc." problem on Kattis.
 * @author Brendan Jones
 */
public class GrassSeed {

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            var totalCost = 0.0;

            var costPerMetre = sc.nextDouble();

            final var numLawns = sc.nextInt();
            for (var i = 0; i < numLawns; ++i) {
                final var width = sc.nextDouble();
                final var height = sc.nextDouble();
                totalCost += (width * height * costPerMetre);
            }

            System.out.println(totalCost);
        }
    }

}
