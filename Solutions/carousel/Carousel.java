import java.util.Scanner;

/**
 * Solution to the "Carousel Rides" problem on Kattis.
 * @author Brendan Jones
 */
public class Carousel {

    /**
     * Processes a single test case.
     * @param sc The input scanner.
     * @return Whether another test case follows this one.
     */
    private static boolean processTestCase(Scanner sc) {
        final var numOffers = sc.nextInt();
        final var maxTickets = sc.nextInt();

        if (numOffers == 0 && maxTickets == 0) {
            return false;
        }

        var bestCount = -1;
        var bestPrice = -1;

        var bestCPT = Double.MAX_VALUE;

        for (var i = 0; i < numOffers; ++i) {
            final var numTickets = sc.nextInt();
            final var totalCost = sc.nextInt();
            if (numTickets <= maxTickets) {
                final var cpt = totalCost / (double) numTickets;
                if (cpt < bestCPT || cpt == bestCPT && numTickets > bestCount) {
                    bestCount = numTickets;
                    bestPrice = totalCost;
                    bestCPT = cpt;
                }
            }
        }

        if (bestCount == -1) {
            System.out.println("No suitable tickets offered");
        } else {
            System.out.println("Buy " + bestCount + " tickets for $" + bestPrice);
        }

        return true;
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            while (processTestCase(sc));
        }
    }

}