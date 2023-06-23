import java.util.Scanner;

/**
 * Solution to the "Trik" problem on Kattis.
 * @author Brendan Jones
 */
public class Trik {

    /**
     * Swaps two cups.
     * @param cups The list of cups.
     * @param a The index of the first cup to swap.
     * @param b The index of the second cup to swap.
     */
    private static void swap(boolean[] cups, int a, int b) {
        if (cups[a] != cups[b]) {
            cups[a] = !cups[a];
            cups[b] = !cups[b];
        }
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var cups = new boolean[] { true, false, false };

            final var line = sc.nextLine();
            for (var i = 0; i < line.length(); ++i) {
                switch (line.charAt(i)) {
                    case 'A':
                        Trik.swap(cups, 0, 1);
                        break;
                    case 'B':
                        Trik.swap(cups, 1, 2);
                        break;
                    case 'C':
                        Trik.swap(cups, 0, 2);
                        break;
                }
            }

            for (var i = 0; i < cups.length; i++) {
                if (cups[i]) {
                    System.out.println(i + 1);
                    break;
                }
            }
        }
    }

}
