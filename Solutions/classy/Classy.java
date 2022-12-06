import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Solution for the "A Classy Problem" problem on Kattis.
 * @author Brendan Jones
 */
public class Classy {

    /**
     * The binary representation of the 'lower' ranking.
     */
    private static final int RANKING_LOWER = 0b01;

    /**
     * The binary representation of the 'middle' ranking.
     */
    private static final int RANKING_MIDDLE = 0b10;

    /**
     * The binary representation of the 'upper' ranking.
     */
    private static final int RANKING_UPPER = 0b11;

    /**
     * Represents a single person.
     */
    private static class Person {

        /**
         * The person's name.
         */
        public final String name;

        /**
         * The person's ranking.
         */
        public final int ranking;

        private Person(String name, int ranking) {
            this.name = name.substring(0, name.length() - 1);
            this.ranking = ranking;
        }

        public int ranking() {
            return ranking;
        }

        public String name() {
            return name;
        }

    }

    /**
     * Packs a rank string into an ordered 20-bit integer.
     * @param rankString The rank string.
     * @return The rank.
     */
    private static int calculateRanking(String rankString) {
        final var ranks = rankString.split("-");

        var ranking = 0;

        // Each rank string is packed into a 2-bit integer. Up to 10 rank strings can be present at once.
        var currentBit = 18;
        for (var i = 0; i < ranks.length; ++i) {
            var rank = 0;
            switch (ranks[ranks.length - i - 1]) {
                case "lower":
                    rank = RANKING_LOWER;
                    break;
                case "middle":
                    rank = RANKING_MIDDLE;
                    break;
                case "upper":
                    rank = RANKING_UPPER;
                    break;
            }
            ranking |= (rank << currentBit);
            currentBit -= 2;
        }

        // Pad the remaining ranks with "middle" class.
        while (currentBit >= 0) {
            ranking |= (RANKING_MIDDLE << currentBit);
            currentBit -= 2;
        }

        return ranking;
    }

    /**
     * Processes a single test case.
     * @param sc The scanner.
     */
    private static void processTestCase(Scanner sc) {
        final var people = new TreeSet<>(Comparator
                .comparingInt(Person::ranking)
                .reversed()
                .thenComparing(Person::name));

        final var numPeople = sc.nextInt();
        for (var i = 0; i < numPeople; ++i) {
            final var name = sc.next();
            final var ranking = calculateRanking(sc.next());

            sc.next();

            people.add(new Person(name, ranking));
        }

        people.stream().map(Person::name).forEach(System.out::println);
        System.out.println("==============================");
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var numTestCases = sc.nextInt();
            for (var i = 0; i < numTestCases; ++i) {
                processTestCase(sc);
            }
        }
    }

}
