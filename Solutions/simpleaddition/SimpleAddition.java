import java.util.Scanner;

/**
 * Solution to the "Simple Addition" problem on Kattis.
 */
public class SimpleAddition {

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            // Valid inputs can exceed size of a long, so we need to use big integers instead.
            final var a = sc.nextBigInteger();
            final var b = sc.nextBigInteger();

            System.out.println(a.add(b));
        }
    }

}

