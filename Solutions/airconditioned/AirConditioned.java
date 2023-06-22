import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Solution to the "Air Conditioned Minions" problem on Kattis.
 * @author Brendan Jones
 */
public class AirConditioned {

    private static class Range {
        /**
         * The minimum value of the range.
         */
        private final int min;

        /**
         * The maximum value of the range.
         */
        private final int max;

        public Range(int min, int max) {
            this.min = min;
            this.max = max;
        }

        @Override
        public boolean equals(Object other) {
            if (other instanceof Range) {
                Range o = (Range) other;
                return (min == o.min && max == o.max);
            }
            return false;
        }

        public int max() {
            return max;
        }

    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var ranges = new TreeSet<>(Comparator.comparing(Range::max));

            // The number of minions to read in.
            final var numMinions = sc.nextInt();
            for (var i = 0; i < numMinions; ++i) {
                final var range = new Range(sc.nextInt(), sc.nextInt());
                ranges.add(range);
            }

            var numRooms = 0;
            var currentMax = -1;

            for (final var range : ranges) {
                if (currentMax < range.min) {
                    numRooms++;
                    currentMax = range.max;
                }
            }

            System.out.println(numRooms);
        }
    }

}
