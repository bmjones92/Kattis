import java.util.Scanner;

/**
 * Solution to the "Best Compression Ever" problem on Kattis.
 * @author Brendan Jones
 */
public class BestCompression {

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var numFiles = sc.nextLong();
            final var numBits = sc.nextInt();

            final var maxFiles = (1L << (numBits + 1)) - 1;
            if (maxFiles >= numFiles) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }

}