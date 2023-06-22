import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * Solution to the "Shopaholic" problem on Kattis.
 * @author Brendan Jones
 */
public class Shopaholic {

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var numItems = sc.nextInt();

            final var items = new ArrayList<Integer>(numItems);
            for (var i = 0; i < numItems; i++) {
                items.add(sc.nextInt());
            }
            items.sort(Comparator.reverseOrder());

            var totalDiscount = 0L;
            for (var i = 2; i < items.size(); i += 3) {
                totalDiscount += items.get(i);
            }

            System.out.println(totalDiscount);
        }
    }

}

