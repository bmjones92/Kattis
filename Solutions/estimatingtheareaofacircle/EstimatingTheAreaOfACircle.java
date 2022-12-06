import java.util.Scanner;

/**
 * Solution to the "Estimating the Area of a Circle" problem on Kattis.
 * @author Brendan Jones
 */
public class EstimatingTheAreaOfACircle {

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            while (true) {
                // Read the next line of input.
                final var radius = sc.nextDouble();
                final var pointsMarked = sc.nextInt();
                final var pointsInside = sc.nextInt();

                // There is no more input, so break from the loop.
                if (radius == 0.0D && pointsMarked == 0 && pointsInside == 0) {
                    break;
                }

                // Calculate the true and estimated areas of the circle.
                final var trueArea = Math.PI * Math.pow(radius, 2);
                final var estimatedArea = Math.pow(2 * radius, 2) * pointsInside / pointsMarked;

                // Print the results.
                System.out.printf("%f %f%n", trueArea, estimatedArea);
            }
        }
    }

}