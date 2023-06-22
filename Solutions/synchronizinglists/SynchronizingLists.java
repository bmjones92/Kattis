import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Solution to the "Synchronizing Lists" problem on Kattis.
 * @author Brendan Jones
 */
public class SynchronizingLists {

    /**
     * Represents a single list element.
     */
    private static class Element implements Comparable<Element> {

        /**
         * The comparator instance.
         */
        private static final Comparator<Element> COMPARATOR = Comparator.comparingInt(e -> e.value);

        /**
         * The value of this element.
         */
        private final int value;

        /**
         * The element's original index.
         */
        private final int index;

        /**
         * Creates a new Element instance.
         * @param index The index of the element.
         * @param value The value of the element.
         */
        private Element(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Element o) {
            return COMPARATOR.compare(this, o);
        }

        @Override
        public String toString() {
            return String.format("[index=%d, value=%d]", index, value);
        }

    }

    /**
     * Processes a single test case.
     * @param sc The input scanner.
     * @param b The output builder.
     * @return {@code true} if another test case follows this one.
     */
    private static boolean processTestCase(Scanner sc, StringBuilder b) {
        final var numElements = sc.nextInt();
        if (numElements == 0) {
            return false;
        }

        // Populate the index list (first list). These are sorted by value.
        final var indices = new TreeSet<>(Element.COMPARATOR);
        for (var i = 0; i < numElements; i++) {
            final var value = sc.nextInt();
            indices.add(new Element(i, value));
        }

        // Populate the value list (second list).
        final var values = new int[numElements];
        for (var i = 0; i < numElements; i++) {
            values[i] = sc.nextInt();
        }
        Arrays.sort(values);

        // Use a third list for writing output to. Could maybe do this in-place but probably not worth the effort to
        // figure out.
        final var result = new int[numElements];

        // Shuffle the second list so values are in the same order as the first list originally was.
        final var it = indices.iterator();
        for (var i = 0; it.hasNext(); i++) {
            final var index = it.next();
            result[index.index] = values[i];
        }

        // Write output to the string builder.
        for (final var value : result) {
            b.append(value).append('\n');
        }
        b.append('\n');

        return true;
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var b = new StringBuilder();
            while (processTestCase(sc, b));
            System.out.print(b);
        }
    }

}