import java.util.Scanner;

public class Bijele {

    /**
     * The number of kings required to complete a set.
     */
    private static final int NUM_KINGS = 1;

    /**
     * The number of queens required to complete a set.
     */
    private static final int NUM_QUEENS = 1;

    /**
     * The number of rooks required to complete a set.
     */
    private static final int NUM_ROOKS = 2;

    /**
     * The number of bishops required to complete a set.
     */
    private static final int NUM_BISHOPS = 2;

    /**
     * The number of knights required to complete a set.
     */
    private static final int NUM_KNIGHTS = 2;

    /**
     * The number of pawns required to complete a set.
     */
    private static final int NUM_PAWNS = 8;

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var numKingsRequired = NUM_KINGS - sc.nextInt();
            final var numQueensRequired = NUM_QUEENS - sc.nextInt();
            final var numRooksRequired = NUM_ROOKS - sc.nextInt();
            final var numBishopsRequired = NUM_BISHOPS - sc.nextInt();
            final var numKnightsRequired = NUM_KNIGHTS - sc.nextInt();
            final var numPawnsRequired = NUM_PAWNS - sc.nextInt();
            System.out.printf("%d %d %d %d %d %d", numKingsRequired, numQueensRequired, numRooksRequired, numBishopsRequired, numKnightsRequired, numPawnsRequired);
        }
    }

}

