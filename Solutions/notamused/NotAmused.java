import java.text.NumberFormat;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Solution to the "Not Amused" problem on Kattis.
 * @author Brendan Jones
 */
public class NotAmused {

    /**
     * The default currency format.
     */
    private static final NumberFormat CURRENCY_FORMAT = NumberFormat.getCurrencyInstance();

    /**
     * Procesess a single test case.
     * @param sc The input scanner.
     * @param day The day.
     */
    private static void processTestCase(Scanner sc, int day) {
        sc.nextLine(); //"OPEN";

        final var entryTimes = new TreeMap<String, Integer>();
        final var totalTime = new TreeMap<String, Integer>();

        String line;
        while (!(line = sc.nextLine()).equals("CLOSE")) {
            final var tokens = line.split(" ");
            if (tokens[0].equals("ENTER")) {
                entryTimes.put(tokens[1], Integer.parseInt(tokens[2]));
                totalTime.putIfAbsent(tokens[1], 0);
            } else {
                final var duration = Integer.parseInt(tokens[2]) - entryTimes.get(tokens[1]);
                totalTime.put(tokens[1], totalTime.get(tokens[1]) + duration);
            }
        }

        final var b = new StringBuilder("Day ").append(day).append('\n');
        for(final var time : totalTime.entrySet()) {
            b.append(time.getKey()).append(' ')
                    .append(CURRENCY_FORMAT.format(time.getValue() * 0.1))
                    .append('\n');
        }

        System.out.println(b);
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            var day = 1;
            while (sc.hasNextLine()) {
                processTestCase(sc, day++);
            }
        }
    }

}

