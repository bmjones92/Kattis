import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Solution to the "Busy Schedule" problem on Kattis.
 * @author Brendan Jones
 */
public class BusySchedule {

    /**
     * The number of bits to shift minutes in a timestamp.
     */
    private static final int SHIFT_MINUTES = 0;

    /**
     * The number of bits to shift hours in a timestamp.
     */
    private static final int SHIFT_HOURS = 6;

    /**
     * The number of bits to shift the period in a timestamp.
     */
    private static final int SHIFT_PERIOD = 11;

    /**
     * A timestamp.
     */
    private static class Timestamp implements Comparable<Timestamp> {

        /**
         * The time string.
         */
        private final String time;

        /**
         * The encoded timestamp.
         */
        private final int encodedTime;

        private Timestamp(String timeString, String periodString) {
            this.time = timeString + " " + periodString;

            final var tokens = timeString.split(":");

            final var period = periodString.equals("a.m.") ? 0 : 1;
            final var hours = Integer.parseInt(tokens[0]) % 12;
            final var minutes = Integer.parseInt(tokens[1]);
            this.encodedTime = (period << SHIFT_PERIOD) | (hours << SHIFT_HOURS) | (minutes << SHIFT_MINUTES);
        }

        @Override
        public int compareTo(Timestamp o) {
            return encodedTime - o.encodedTime;
        }

        @Override
        public String toString() {
            return time;
        }

    }

    private static boolean processTestCase(Scanner sc) {
        final var numElements = sc.nextInt();
        if (numElements == 0) {
            return false;
        }

        final var timestamps = new ArrayList<Timestamp>();
        for (var i = 0; i < numElements; ++i) {
            final var timeString = sc.next();
            final var periodString = sc.next();
            timestamps.add(new Timestamp(timeString, periodString));
        }
        timestamps.sort(null);

        timestamps.forEach(System.out::println);
        System.out.println();

        return true;
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            while (processTestCase(sc));
        }
    }

}
