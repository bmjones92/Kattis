import java.util.*;

/**
 * Solution to the "Best Relay Team" problem on Kattis.
 * @author Brendan Jones
 */
public class BestRelayTeam {

    /**
     * The size of a team.
     */
    private static final int TEAM_SIZE = 4;

    /**
     * A member of the team.
     */
    private static class Runner {

        /**
         * The Runner's name.
         */
        private final String name;

        /**
         * The time to complete the first leg of the race.
         */
        private final double timeFirst;

        /**
         * The time to complete any other leg of the race.
         */
        private final double timeOther;

        /**
         * Creates a new Runner instance from input.
         * @param sc The input Scanner.
         */
        private Runner(Scanner sc) {
            this.name = sc.next();
            this.timeFirst = sc.nextDouble();
            this.timeOther = sc.nextDouble();
        }

        @Override
        public String toString() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof Runner) {
                final var runner = (Runner) o;
                return runner.name.equals(name);
            }
            return false;
        }

    }

    private static void processTestCase(Scanner sc) {
        final var firstRunners = new ArrayList<Runner>();
        final var otherRunners = new ArrayList<Runner>();

        final var numRacers = sc.nextInt();
        for (var i = 0; i < numRacers; ++i) {
            final var runner = new Runner(sc);
            firstRunners.add(runner);
            otherRunners.add(runner);
        }

        firstRunners.sort(Comparator.comparingDouble(a -> a.timeFirst));
        otherRunners.sort(Comparator.comparingDouble(a -> a.timeOther));

        var fastestTime = Double.MAX_VALUE;
        List<Runner> fastest = null;
        for (final var first : firstRunners) {
            var currentTime = 0.0;
            final var current = new ArrayList<Runner>();

            currentTime += first.timeFirst;
            current.add(first);

            final var it = otherRunners.iterator();
            while (it.hasNext() && current.size() < TEAM_SIZE) {
                final var other = it.next();
                if (other.equals(first)) {
                    continue;
                }

                currentTime += other.timeOther;
                current.add(other);
            }

            if (current.size() == TEAM_SIZE && currentTime < fastestTime) {
                fastestTime = currentTime;
                fastest = current;
            }

        }

        System.out.println(fastestTime);
        fastest.forEach(System.out::println);
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            processTestCase(sc);
        }
    }

}

