import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Solution to the "Abandoned Animal" problem on Kattis.
 * @author Brendan Jones
 */
public class AbandonedAnimal {

    private static class StoreEntry implements Comparable<StoreEntry> {

        /**
         * The id of the store.
         */
        private final int id;

        /**
         * The number of paths that reached this store.
         */
        private int numPaths;

        private StoreEntry(int id) {
            this(id, 1);
        }

        private StoreEntry(int id, int count) {
            this.id = id;
            this.numPaths = count;
        }

        @Override
        public int compareTo(StoreEntry other) {
            return Integer.compare(id, other.id);
        }

        @Override
        public boolean equals(Object other) {
            if (other instanceof StoreEntry) {
                final var entry = (StoreEntry) other;
                return this.id == entry.id;
            }
            return false;
        }

    }

    private static void processTestCase(Scanner sc) {
        // Number of stores, not used.
        sc.nextInt();

        // Maps items to the set of stores that stock them.
        final var inventories = new HashMap<String, Set<Integer>>();

        // Populates the mapping described above.
        final var numInventoryListings = sc.nextInt();
        for (var i = 0; i < numInventoryListings; ++i) {
            final var store = sc.nextInt();
            final var item = sc.next();

            inventories.computeIfAbsent(item, key -> new TreeSet<>()).add(store);
        }

        // Tracks the set of stores that the sister can be at for the most recently processed item.
        final var currentStores = new TreeSet<StoreEntry>();

        // Walk through every purchased item in order and calculate the number of possible paths.
        final var numPurchasedItems = sc.nextInt();
        for (var i = 0; i < numPurchasedItems; ++i) {
            // Get the list of stores that stock the next item.
            final var storesThatStockNextItem = new TreeSet<>(inventories.get(sc.next()));

            if (currentStores.isEmpty()) {
                // No items have been purchased so far, so all stores that stock the first item form a valid path.
                storesThatStockNextItem.stream().map(StoreEntry::new).forEach(currentStores::add);
            } else {
                // Maps a store to the number of paths that lead to it.
                final var nextStores = new HashMap<Integer, StoreEntry>();

                // For every store the sister could be at for the current grocery item, find all possible stores she
                // could have gone to for the next item.
                for (final var currentStore : currentStores) {
                    // Remove any stores that were visited before the current store. Since the set of "current" stores
                    // are visited in ascending order, this reduces some computation complexity by removing redundant
                    // checks for stores that have already been visited.
                    storesThatStockNextItem.removeIf(store -> store < currentStore.id);

                    for (final var next : storesThatStockNextItem) {
                        if (!nextStores.containsKey(next)) {
                            // First time the store has been visited during this iteration.
                            nextStores.put(next, new StoreEntry(next, currentStore.numPaths));
                        } else {
                            // Store has already been visited during this iteration, so "merge" this path with the
                            // existing ones.
                            nextStores.get(next).numPaths += currentStore.numPaths;
                        }
                    }
                }

                // Update the set of "current" paths.
                currentStores.clear();
                currentStores.addAll(nextStores.values());

                // Result is guaranteed to be "impossible" if there are no valid paths, so we can ignore the remainder
                // of the input and bail out early.
                if (currentStores.isEmpty()) {
                    break;
                }
            }
        }

        // Calculate the total number of paths.
        var totalPaths = 0;
        for (var store : currentStores) {
            totalPaths += store.numPaths;
        }

        // Print the result.
        if (totalPaths == 0) {
            System.out.println("impossible");
        } else if (totalPaths == 1) {
            System.out.println("unique");
        } else {
            System.out.println("ambiguous");
        }
    }

    public static void main(String[] args) {
        try (var sc = new Scanner(System.in)) {
            processTestCase(sc);
        }
    }

}
