import java.util.Scanner;

/**
 * Solution to the "Provinces and Gold" problem on Kattis.
 * @author Brendan Jones
 */
public class ProvincesAndGold {

    /**
     * The different types of "Victory" card.
     */
    private static final Card[] VICTORY_CARDS = { Card.Province, Card.Duchy, Card.Estate };

    /**
     * The different types of "Treasure" card.
     */
    private static final Card[] TREASURE_CARDS = { Card.Gold, Card.Silver, Card.Copper };

    private enum Card {
        Province(8, 6),
        Duchy(5, 3),
        Estate(2, 1),

        Gold(6, 3),
        Silver(3, 2),
        Copper(0, 1);

        /**
         * The cost of the card.
         */
        final int cost;

        /**
         * The number of points the card is worth.
         */
        final int worth;

        Card(int cost, int worth) {
            this.cost = cost;
            this.worth = worth;
        }

    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            var worth = 0;
            for (final var card : TREASURE_CARDS) {
                worth += sc.nextInt() * card.worth;
            }
            for (final var card : VICTORY_CARDS) {
                if (card.cost <= worth) {
                    System.out.print(card.name() + " or ");
                    break;
                }
            }
            for (final var card : TREASURE_CARDS) {
                if (card.cost <= worth) {
                    System.out.print(card.name());
                    break;
                }
            }
        }
    }

}
