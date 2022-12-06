import java.util.Scanner;

/**
 * Solution to the "Doorman" problem on Kattis.
 * @author Brendan Jones
 */
public class Doorman {

    /**
     * Queue that allows for the first or second element to be polled.
     */
    private static class WaitingQueue {

        /**
         * The items in the queue.
         */
        private final char[] items;

        /**
         * The position of the first element.
         */
        private int first = 0;

        /**
         * The position of the second element.
         */
        private int second = 1;

        /**
         * Creates a new waiting queue.
         * @param queue The queue elements.
         */
        public WaitingQueue(String queue) {
            this.items = queue.toCharArray();
        }

        /**
         * Peeks the first element in the queue.
         * @return The first element, or `\0` if no element exists.
         */
        public char peekFirst() {
            return (first < items.length) ? items[first] : '\0';
        }

        /**
         * Peeks the second element in the queue.
         * @return The second element, or '\0' if no element exists.
         */
        public char peekSecond() {
            return (second < items.length) ? items[second] : '\0';
        }

        /**
         * Removes the first element from the queue.
         */
        public void removeFirst() {
            first = second;
            second++;
        }

        /**
         * Removes the second element from the queue.
         */
        public void removeSecond() {
            second++;
        }

        /**
         * Calculates the number of elements that were polled.
         * @return The number of elements.
         */
        public int totalPolled() {
            return second - 1;
        }

        /**
         * Checks whether the queue is empty.
         * @return True if the queue is empty.
         */
        public boolean isEmpty() {
            return first == items.length;
        }

    }

    /**
     * Gets the delta for the specified character.
     * @param ch The character to check.
     * @return -1 if the character is 'W', +1 if the character is 'M', otherwise 2^31-1.
     */
    private static int delta(char ch) {
        return ch == 'W' ? -1 : ch == 'M' ? 1 : Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var maxDifference = sc.nextInt();

            var currentDifference = 0;

            final var queue = new WaitingQueue(sc.next());
            while (!queue.isEmpty() && Math.abs(currentDifference) <= maxDifference) {
                var newDifference = currentDifference + delta(queue.peekFirst());
                if (Math.abs(newDifference) > maxDifference) {
                    newDifference = currentDifference + delta(queue.peekSecond());
                    if (Math.abs(newDifference) <= maxDifference) {
                        queue.removeSecond();
                    }
                } else {
                    queue.removeFirst();
                }
                currentDifference = newDifference;
            }

            System.out.println(queue.totalPolled());
        }
    }

}