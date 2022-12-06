import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Solution to the "Get to Work" problem on Kattis.
 * @author Brendan Jones
 */
public class GetToWork {

    private static class Town {
        int numEmployees;
        PriorityQueue<Integer> vehicles = new PriorityQueue<>(8, Comparator.reverseOrder());
    }

    private static void processTestCase(Scanner sc, StringBuilder bldr) {
        final var numTowns = sc.nextInt();
        final var towns = new Town[numTowns];
        for (var i = 0; i < numTowns; ++i) {
            towns[i] = new Town();
        }

        final var officeTown = sc.nextInt() - 1;

        final var numEmployees = sc.nextInt();
        for (var i = 0; i < numEmployees; ++i) {
            final var town = towns[sc.nextInt() - 1];
            town.numEmployees++;

            var capacity = sc.nextInt();
            if (capacity > 0) {
                town.vehicles.add(capacity);
            }
        }

        towns[officeTown].numEmployees = 0;

        final var b = new StringBuilder();
        for (final var town : towns) {
            var numVehicles = 0;
            while (town.numEmployees > 0 && !town.vehicles.isEmpty()) {
                town.numEmployees -= town.vehicles.poll();
                numVehicles++;
            }

            if (town.numEmployees > 0) {
                bldr.append(" IMPOSSIBLE");
                return;
            } else {
                b.append(' ').append(numVehicles);
            }
        }
        bldr.append(b);
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var b = new StringBuilder();
            var numTestCases = sc.nextInt();
            for (var i = 0; i < numTestCases; ++i) {
                b.append("Case #").append(i + 1).append(":");
                processTestCase(sc, b);
                b.append('\n');
            }
            System.out.print(b);
        }
    }

}

