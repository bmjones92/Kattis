import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Solution to the "Bela" problem on Kattis.
 * @author Brendan Jones
 */
public class Bela {

    private static final Map<Character, Integer[]> CARD_SCORES = new HashMap<>();

    static {
        CARD_SCORES.put('A', new Integer[] { 11, 11 });
        CARD_SCORES.put('K', new Integer[] { 4,  4 });
        CARD_SCORES.put('Q', new Integer[] { 3,  3 });
        CARD_SCORES.put('J', new Integer[] { 20, 2 });
        CARD_SCORES.put('T', new Integer[] { 10, 10 });
        CARD_SCORES.put('9', new Integer[] { 14, 0 });
        CARD_SCORES.put('8', new Integer[] { 0,  0 });
        CARD_SCORES.put('7', new Integer[] { 0,  0 });
    }

    private static int getCardScore(String card, char dominantSuit) {
        final var cardValue = card.charAt(0);
        final var isDominant = (card.charAt(1) == dominantSuit);

        final var scores = CARD_SCORES.get(cardValue);
        return scores[isDominant ? 0 : 1];
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            var totalScore = 0;

            final var numHands = sc.nextInt() << 2;
            final var dominantSuit = sc.next().charAt(0);

            for (var i = 0; i < numHands; ++i) {
                totalScore += Bela.getCardScore(sc.next(), dominantSuit);
            }

            System.out.println(totalScore);
        }
    }

}