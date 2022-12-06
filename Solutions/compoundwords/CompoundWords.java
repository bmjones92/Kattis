import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Solution to the "Compound Words" problem on Kattis.
 * @author Brendan Jones
 */
public class CompoundWords {

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            // Read the list of words.
            final var words = new ArrayList<String>();
            while (sc.hasNext()) {
                words.add(sc.next());
            }

            // Build the set of compound words.
            final var compound = new TreeSet<String>();
            for (var i = 0; i < words.size(); ++i) {
                for(var j = 0; j < words.size(); ++j) {
                    if (i != j) {
                        compound.add(words.get(i) + words.get(j));
                    }
                }
            }

            // Print the compound words.
            compound.forEach(System.out::println);
        }
    }

}

