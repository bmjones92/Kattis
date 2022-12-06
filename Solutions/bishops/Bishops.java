import java.util.Scanner;

/**
 * Solution to the "Bishops" problem on Kattis.
 * @author Brendan Jones
 */
public class Bishops {
    
    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var bldr = new StringBuilder();
            while (sc.hasNext()) {
                var numBishops = sc.nextInt();
                if( numBishops > 1) {
                    numBishops = (numBishops * 2) - 2;
                }
                bldr.append(numBishops).append('\n');
            }
            System.out.print(bldr);
        }
    }

}