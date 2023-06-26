import java.util.Scanner;

/**
 * Solution to the "Yoda" problem on Kattis.
 * @author Brendan Jones
 */
public class Yoda {

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var a = sc.next();
            final var b = sc.next();

            final var outA = new StringBuilder();
            final var outB = new StringBuilder();
            for (var i = 0; i < Math.max(a.length(), b.length()); ++i) {
                final var chA = (i < a.length()) ? a.charAt(a.length() - 1 - i) : '0';
                final var chB = (i < b.length()) ? b.charAt(b.length() - 1 - i) : '0';

                final var delta = Character.compare(chA, chB);
                if (delta >= 0) {
                    outA.append(chA);
                }
                if (delta <= 0) {
                    outB.append(chB);
                }
            }

            if (outA.length() == 0) {
                System.out.println("YODA");
            } else {
                System.out.println(Integer.parseInt(outA.reverse().toString()));
            }

            if (outB.length() == 0) {
                System.out.println("YODA");
            } else {
                System.out.println(Integer.parseInt(outB.reverse().toString()));
            }
        }
    }

}

