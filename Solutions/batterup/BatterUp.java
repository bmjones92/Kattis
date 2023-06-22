import java.util.Scanner;

/**
 * Solution to the "Batter Up" problem on Kattis.
 * @author Brendan Jones
 */
public class BatterUp {
    
    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var numAtBats = sc.nextInt();
            
            final var numerator = 0;
            final var denominator = 0;
            
            for (var i = 0; i < numAtBats; ++i) {
                final var value = sc.nextInt();
                if (value != -1) {
                    numerator += value;
                    denominator++;
                }
            }
            
            System.out.println((double) numerator / denominator);
        }
    }

}