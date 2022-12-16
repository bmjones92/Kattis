import java.util.Scanner;

/**
 * Solution to the "Pot" problem on Kattis.
 * @author Brendan Jones
 */
public class Pot {
    
    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            var sum = 0;
            
            final var numAddends = sc.nextInt();
            for (var i = 0; i < numAddends; ++i) {
                final var number = sc.nextInt();
                sum += Math.pow(number / 10, number % 10);
            }
            System.out.println(sum);
        }
    }
    
}