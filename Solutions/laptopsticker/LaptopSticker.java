import java.util.Scanner;

/**
 * Solution to the "Laptop Sticker" problem on Kattis.
 * @author Brendan Jones
 */
public class LaptopSticker {

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var wc = sc.nextInt() - 2;
            final var hc = sc.nextInt() - 2;
            final var ws = sc.nextInt();
            final var hs = sc.nextInt();

            System.out.println((wc >= ws && hc >= hs) ? 1 : 0);
        }
    }

}
