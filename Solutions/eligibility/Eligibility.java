import java.util.Scanner;

/**
 * Solution to the "Eligibility" problem on Kattis.
 * @author Brendan Jones
 */
public class Eligibility {

    /**
     * Represents a date.
     */
    private static class Date {

        /**
         * The year.
         */
        private final int year;

        /**
         * The month.
         */
        private final int month;

        /**
         * The day.
         */
        private final int day;

        /**
         * Creates a new date from a "YYYY/MM/DD" date string.
         * @param date The date string.
         */
        public Date(String date) {
            final var tokens = date.split("/");
            this.year = Integer.parseInt(tokens[0]);
            this.month = Integer.parseInt(tokens[1]);
            this.day = Integer.parseInt(tokens[2]);
        }

    }

    /**
     * Processes a single test case.
     * @param sc The input Scanner.
     */
    private static void processTestCase(Scanner sc) {
        final var name = sc.next();
        final var dateBeganStudies = new Date(sc.next());
        final var dateBirth = new Date(sc.next());
        final var numCourses = sc.nextInt();

        String status;
        if (dateBeganStudies.year >= 2010 || dateBirth.year >= 1991) {
            status = "eligible";
        } else if (numCourses > 40) {
            status = "ineligible";
        } else {
            status = "coach petitions";
        }

        System.out.println(name + " " + status);
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var numContestants = sc.nextInt();
            for (var i = 0; i < numContestants; ++i) {
                processTestCase(sc);
            }
        }
    }

}

