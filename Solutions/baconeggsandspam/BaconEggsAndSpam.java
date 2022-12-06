import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class BaconEggsAndSpam {

    private static void processCustomersForDay(Scanner sc, int numOrders) {
        // Maps foods to the set of customers that ordered them.
        final var orders = new TreeMap<String, Set<String>>();

        // Orders are space-delimited lists. The first element is the customer's name, and every other element is a
        // food item that they purchased.
        for (var order = 0; order < numOrders; ++order) {
            final var tokens = sc.nextLine().split(" ");

            final var customer = tokens[0];
            for (var i = 1; i < tokens.length; ++i) {
                orders.computeIfAbsent(tokens[i], t -> new TreeSet<>()).add(customer);
            }
        }

        // Output the list of customers that purchased each food item.
        orders.forEach((food, customers) -> System.out.println(food + " " + String.join(" ", customers)));

        // Output for each day is separated by an empty line.
        System.out.println();
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            var numCustomers = 0;

            while ((numCustomers = sc.nextInt()) != 0) {
                // Scanner.nextInt() doesn't discard the `\n` character which causes Scanner.nextLine() to return an
                // empty string. So call it here. :)
                sc.nextLine();
                processCustomersForDay(sc, numCustomers);
            }
        }
    }

}

