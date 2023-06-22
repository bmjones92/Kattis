import java.util.*;

/**
 * Solution to the "Set!" problem on Kattis.
 * @author Brendan Jones
 */
public class KattisSet {

    /**
     * Represents a set of cards.
     */
    private static class CardSet {

        /**
         * The first card in the set.
         */
        private final int cardA;

        /**
         * The second card in the set.
         */
        private final int cardB;

        /**
         * The third card in the set.
         */
        private final int cardC;

        /**
         * Creates a new card set.
         * @param cardA The first card
         * @param cardB The second card
         * @param cardC The third card
         */
        private CardSet(int cardA, int cardB, int cardC) {
            this.cardA = cardA;
            this.cardB = cardB;
            this.cardC = cardC;
        }

        @Override
        public String toString() {
            return String.format("%d %d %d", cardA, cardB, cardC);
        }

    }

    /**
     * The number of cards on the board.
     */
    private static final int NUM_CARDS = 12;

    /**
     * The number of attributes per card.
     */
    private static final int NUM_ATTRIBUTES = 4;

    /**
     * Read the set of cards from the input scanner.
     * @param sc The input scanner.
     * @return The read cards.
     */
    private static String[] readCards(Scanner sc) {
        final var cards = new String[NUM_CARDS];
        for (var i = 0; i < NUM_CARDS; i++) {
            cards[i] = sc.next();
        }
        return cards;
    }

    /**
     * Checks the cards for combinations that form valid sets.
     * @param cards The set of cards to check.
     * @return The list of sets.
     */
    private static List<CardSet> findSets(String[] cards) {
        final var sets = new ArrayList<CardSet>();

        final var attributes = new HashSet<Character>();
        for (var a = 0; a < NUM_CARDS; a++) {
            for (var b = a + 1; b < NUM_CARDS; b++) {
                for (var c = b + 1; c < NUM_CARDS; c++) {
                    var isMatch = true;

                    // Check each card attribute to determine if the cards form a valid set.
                    for (var attribute = 0; attribute < NUM_ATTRIBUTES; attribute++) {
                        attributes.clear();
                        attributes.add(cards[a].charAt(attribute));
                        attributes.add(cards[b].charAt(attribute));
                        attributes.add(cards[c].charAt(attribute));

                        // Does not form a set because two cards match but the third does not.
                        if (attributes.size() == 2) {
                            isMatch = false;
                            break;
                        }
                    }

                    // All attributes meet the conditions for a set.
                    if (isMatch) {
                        sets.add(new CardSet(a + 1, b + 1, c + 1));
                    }
                }
            }
        }

        return sets;
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var cards = readCards(sc);
            final var sets = findSets(cards);

            if (sets.isEmpty()) {
                System.out.println("no sets");
            } else {
                // Sets are checked in ascending order, so the set list will inherently be sorted.
                sets.forEach(System.out::println);
            }
        }
    }

}
