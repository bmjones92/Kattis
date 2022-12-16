import java.util.Arrays;
import java.util.Scanner;

/**
 * Solution to the "Cetiri" problem on Kattis.
 * @author Brendan Jones
 */
public class Cetiri {
    
    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var numbers = new int[3];
            for (var i = 0; i < numbers.length; ++i) {
                numbers[i] = sc.nextInt();
            }
            Arrays.sort(numbers);
            
            final var d10 = numbers[1] - numbers[0];
            final var d21 = numbers[2] - numbers[1];
            if (d10 < d21) {
                System.out.println(numbers[1] + d10);
            } else if (d21 < d10) {
                System.out.println(numbers[0] + d21);
            } else {
                System.out.println(numbers[2] + d21);
            }
        }
    }

}
