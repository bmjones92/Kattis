import java.util.Scanner;

/**
 * Solution to the "Identifying Map Tiles" problem on Kattis.
 * @author Brendan Jones
 */
public class MapTiles2 {

    /**
     * Processes a single test case.
     * @param sc The input scanner.
     */
    private static void processTestCase(Scanner sc) {
        final var key = sc.next();

        var x = 0;
        var y = 0;

        var lod = (int) Math.pow(2.0, key.length()) >> 1;
        for(int i = 0; i < key.length(); ++i) {
            final var quad = key.charAt(i) - '0';
            switch(quad) {
                case 0:
                    break;
                case 1:
                    x += lod;
                    break;
                case 2:
                    y += lod;
                    break;
                case 3:
                    x += lod;
                    y += lod;
                    break;
            }
            lod >>= 1;
        }
        System.out.printf("%d %d %d%n", key.length(), x, y);
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            processTestCase(sc);
        }
    }

}

