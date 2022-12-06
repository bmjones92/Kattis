import java.util.Scanner;

/**
 * Solution to the "Boss Battle" problem on Kattis.
 * @author Brendan Jones
 */
public class BossBattle {

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var turns = Math.max(1, sc.nextInt() - 2);
            System.out.println(turns);
        }
    }

}

