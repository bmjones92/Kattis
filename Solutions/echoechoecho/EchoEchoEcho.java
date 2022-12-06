import java.util.Scanner;

/**
 * Solution to the "Echo Echo Echo" problem on Kattis.
 * @author Brendan Jones
 */
public class EchoEchoEcho {

    public static void main(String[] args) {
        final var sc = new Scanner(System.in);

        final var word = sc.next();
        for (var i = 0; i < 3; i++) {
            System.out.print(word);
            if (i != 2) {
                System.out.print(' ');
            }
        }
    }

}
