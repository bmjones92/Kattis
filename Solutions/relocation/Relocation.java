import java.util.Scanner;

/**
 * Solution to the "Relocation" problem on Kattis.
 * @author Brendan Jones
 */
public class Relocation {

    /**
     * The ID of the command that relocates a company.
     */
    private static final int TYPE_RELOCATE = 1;

    /**
     * The ID of the command that calculates the distance between two companies.
     */
    private static final int TYPE_DISTANCE = 2;

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var numCompanies = sc.nextInt();
            final var numQueries = sc.nextInt();

            final var locations = new int[numCompanies];
            for (var i = 0; i < numCompanies; ++i) {
                locations[i] = sc.nextInt();
            }

            for (var i = 0; i < numQueries; ++i) {
                switch (sc.nextInt()) {
                    case TYPE_RELOCATE:
                        locations[sc.nextInt() - 1] = sc.nextInt();
                        break;
                    case TYPE_DISTANCE:
                        System.out.println(Math.abs(locations[sc.nextInt() - 1] - locations[sc.nextInt() - 1]));
                        break;
                }
            }
        }
    }

}
