import java.util.Scanner;

/**
 * Solution to the "Herman" problem on Kattis.
 * @author Brendan Jones
 */
public class Herman {

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var radius = sc.nextInt();

            final var areaEuclidean = Math.PI * radius * radius;
            final var areaTaxicab = (radius << 1) * (radius << 1) >> 1;

            System.out.println(areaEuclidean);
            System.out.println(areaTaxicab);
        }
    }

}
