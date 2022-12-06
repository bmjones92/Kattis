import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Solution to the "ABC" problem on Kattis.
 * @author Brendan Jones
 */
public class ABC {

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var numbers = new ArrayList<Integer>(3);
            for (var i = 0; i < 3; ++i) {
                numbers.add(sc.nextInt());
            }
            numbers.sort(Comparator.naturalOrder());

            final var order = sc.next();
            for (var i = 0; i < 3; ++i) {
                final var ch = order.charAt(i);
                System.out.print(numbers.get(ch - 'A'));
                if(i != 2) {
                    System.out.print(' ');
                }
            }
        }
    }

}

