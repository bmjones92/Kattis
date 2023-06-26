import java.util.Scanner;

/**
 * Solution to the "Which is Greater" problem on Kattis.
 * @author Brendan Jones
 */
public class WhichIsGreater {

    public static void main(String[] args) {
        final var sc = new Scanner(System.in);

        final var a = sc.nextInt();
        final var b = sc.nextInt();

        System.out.println(a > b ? 1 : 0);
    }

}