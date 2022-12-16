import java.util.HashMap;
import java.util.Scanner;

/**
 * Solution to the "Poker Hand" problem on Kattis.
 * @author Brendan Jones
 */
public class PokerHand {

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var cards = new HashMap<Character, Integer>();
            for (var i = 0; i < 5; ++i) {
                cards.merge(sc.next().charAt(0), 1, Integer::sum);
            }
            System.out.println(cards.values().stream().reduce(Math::max).get());
        }
    }

}
