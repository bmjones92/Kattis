import java.util.Scanner;

/**
 * Solution to the "Time Travelling Temperatures" problem on Kattis.
 * @author Brendan Jones
 */
public class Temperature {

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var b = sc.nextDouble();
            final var m = sc.nextDouble();

            if (m == 1.0) {
                if (b == 0.0) {
                    System.out.println("ALL GOOD");
                } else {
                    System.out.println("IMPOSSIBLE");
                }
            } else {
                System.out.println(b / (1.0 - m));
            }
        }
    }

}