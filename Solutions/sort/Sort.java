import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Solution to the "Sort" problem on Kattis.
 * @author Brendan Jones
 */
public class Sort {

    /**
     * Represents a number that appears in a message.
     */
    private static class MessageNumber implements Comparable<MessageNumber> {

        /**
         * The default comparator for message numbers.
         */
        private static final Comparator<MessageNumber> COMPARATOR = Comparator
                .<MessageNumber>comparingInt(m -> -m.frequency)
                .thenComparing(m -> m.firstOccurrence);

        /**
         * The value of this message number.
         */
        private final int number;

        /**
         * The position of the first occurrence of this number.
         */
        private final int firstOccurrence;

        /**
         * The number of times this number has appeared in the message.
         */
        private int frequency = 0;

        /**
         * Creates a new MessageNumber instance.
         * @param number The number value.
         * @param firstOccurrence The postion of the first occurrence of this number.
         */
        private MessageNumber(int number, int firstOccurrence) {
            this.number = number;
            this.firstOccurrence = firstOccurrence;
        }

        @Override
        public String toString() {
            return (number + " ").repeat(frequency);
        }

        @Override
        public int compareTo(MessageNumber o) {
            return COMPARATOR.compare(this, o);
        }
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var messageLength = sc.nextInt();

            // The largest number that the message can contain. This could be used for counting sort or radix sort,
            // but the upper bound is so large that we'll potentially run out of memory.
            sc.nextInt();

            final var numbers = new HashMap<Integer, MessageNumber>();
            for (var i = 0; i < messageLength; i++) {
                final var index = i;
                final var number = sc.nextInt();

                // Increment the frequency.
                numbers.computeIfAbsent(number, integer -> new MessageNumber(number, index)).frequency++;
            }

            numbers.values().stream()
                    .sorted()
                    .map(MessageNumber::toString)
                    .forEach(System.out::print);
        }
    }

}

