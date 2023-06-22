import java.util.Scanner;

/**
 * Solution to the "Fizz Buzz" problem on Kattis.
 * @author Brendan Jones
 */
public class FizzBuzz {
    
    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var x = sc.nextInt();
            final var y = sc.nextInt();
            final var n = sc.nextInt();
            
            for (var i = 1; i <= n; ++i) {
                if (i % x == 0 && i % y == 0) {
                    System.out.println("FizzBuzz");
                } else if (i % x == 0) {
                    System.out.println("Fizz");
                } else if (i % y == 0) {
                    System.out.println("Buzz");
                } else {
                    System.out.println(i);
                }
            }
        }
    }
    
}

