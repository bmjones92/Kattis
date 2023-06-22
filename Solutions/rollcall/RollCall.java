import java.util.*;

/**
 * Solution to the "Roll Call" problem on Kattis.
 * @author Brendan Jones
 */
public class RollCall {

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var nameCounts = new HashMap<String, Integer>();
            final var names = new ArrayList<String[]>();

            while (sc.hasNextLine()) {
                final var name = sc.nextLine().split(" ");
                final var count = nameCounts.getOrDefault(name[0], 0) + 1;
                nameCounts.put(name[0], count);
                names.add(name);
            }

            names.sort(Comparator.comparing((String[] a) -> a[1]).thenComparing(a -> a[0]));

            final var b = new StringBuilder();
            for (final var name : names) {
                b.append(name[0]);
                if(nameCounts.get(name[0]) != 1) {
                    b.append(' ').append(name[1]);
                }
                b.append('\n');
            }
            System.out.print(b);
        }
    }

}
