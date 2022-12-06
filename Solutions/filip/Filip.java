import java.util.Scanner;

/**
 * Solution to the "Filip" problem on Kattis.
 * @author Brendan Jones
 */
public class Filip {

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var a = new StringBuilder(sc.next()).reverse().toString();
            final var b = new StringBuilder(sc.next()).reverse().toString();

            System.out.println(a.compareTo(b) > 0 ? a : b);
        }
    }

}

