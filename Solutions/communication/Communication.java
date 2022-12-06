import java.util.Scanner;

/**
 * Solution to the "Jumbled Communication" problem on Kattis.
 * @author Brendan Jones
 */
public class Communication {

    public static void main(String[] args) {
        final var decoder = new int[256];
        for (var x = 0; x < decoder.length; ++x) {
            final var y = (x ^ (x << 1)) & 0xFF;
            decoder[y] = x;
        }

        try (final var sc = new Scanner(System.in)) {
            final var b = new StringBuilder();

            final var numBytes = sc.nextInt();
            for (var i = 0; i < numBytes; ++i) {
                final var y = sc.nextInt();
                b.append(decoder[y]).append(' ');
            }
            System.out.println(b);
        }
    }

}

