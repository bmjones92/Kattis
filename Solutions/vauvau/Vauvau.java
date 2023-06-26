import java.util.Scanner;

/**
 * Solution to the "Vauvau" problem on Kattis.
 * @author Brendan Jones
 */
public class Vauvau {

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var aggroA = sc.nextInt();
            final var calmA = sc.nextInt();
            final var periodA = aggroA + calmA;

            final var aggroB = sc.nextInt();
            final var calmB = sc.nextInt();
            final var periodB = aggroB + calmB;

            for (var i = 0; i < 3; i++) {
                final var arrival = sc.nextInt() - 1;

                var numAttackers = 0;

                if (arrival % periodA < aggroA) {
                    numAttackers++;
                }

                if (arrival % periodB < aggroB) {
                    numAttackers++;
                }

                switch (numAttackers) {
                    case 0:
                        System.out.println("none");
                        break;
                    case 1:
                        System.out.println("one");
                        break;
                    case 2:
                        System.out.println("both");
                        break;
                }
            }
        }
    }

}
