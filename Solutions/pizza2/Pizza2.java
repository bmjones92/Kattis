import java.util.Scanner;

/**
 * Solution to the "Pizza Crust" problem on Kattis.
 * @author Brendan Jones
 */
public class Pizza2 {

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var radius = sc.nextInt();
            final var crust = sc.nextInt();

            final var totalArea = Math.PI * Math.pow(radius, 2.0);
            final var cheeseArea = Math.PI *  Math.pow(radius - crust, 2.0);

            System.out.println(cheeseArea / totalArea * 100.0);
        }
    }
}
