import java.util.*;
import java.util.stream.Collectors;

/**
 * Solution to the "Conversation Log" problem on Kattis.
 * @author Brendan Jones
 */
public class ConversationLog {

    /**
     * Processes a single test case.
     * @param sc The input Scanner.
     */
    private static void processTestCase(Scanner sc) {
        // Maps people to the set of words that they used.
        final var people = new HashMap<String, Set<String>>();
        // Maps words to the number of times it occurs.
        final var wordFrequency = new HashMap<String, Integer>();

        final var numPeople = sc.nextInt(); sc.nextLine();
        for (var person = 0; person < numPeople; person++) {
            final var line = sc.nextLine().split(" ");

            final var words = people.computeIfAbsent(line[0], key -> new TreeSet<>());
            for (var word = 1; word < line.length; word++) {
                // Add the word to the word list for this person.
                words.add(line[word]);

                // Increment the word frequency for the word.
                wordFrequency.merge(line[word], 1, Integer::sum);
            }
        }

        // Calculate the intersection of all words used by every person.
        people.values().stream().reduce((a, b) -> {
            a.retainAll(b);
            return a;
        }).ifPresent(words -> {
            if (words.isEmpty()) {
                System.out.println("ALL CLEAR");
            } else {
                // Words should appear by frequency, then alphabetically in case of a tie.
                final var cmp = Comparator
                        .comparingInt((String w) -> wordFrequency.get(w)).reversed()
                        .thenComparing(String::compareTo);

                // Calculate the result and print it.
                final var result = words.stream().sorted(cmp).collect(Collectors.joining("\n"));
                System.out.println(result);
            }
        });
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            processTestCase(sc);
        }
    }

}
