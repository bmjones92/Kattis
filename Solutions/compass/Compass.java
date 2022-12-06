import java.util.Scanner;

/**
 * Solution to the "Jumbled Compass" problem on Kattis.
 * @author Brendan Jones
 */
public class Compass {

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var start = sc.nextInt();
            final var end = sc.nextInt();

            var distance = end - start;
            if(distance < 0) {
                distance += 360;
            }
            if(distance > 180) {
                distance -= 360;
            }

            System.out.println(distance);
        }
    }

}

