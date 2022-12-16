import java.util.Scanner;

/**
 * Solution to the "Primary Register" problem on Kattis.
 * @author Brendan Jones
 */
public class PrimaryRegister {
    
    /**
     * The places values for each digit in the reigster.
     */
    private static final int[] PRIMES = { 2, 3, 5, 7, 11, 13, 17, 19 };
    
    /**
     * The maximum possible value.
     */
    private static final int MAX_VALUE = 9699689;
    
    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            var value = 0L;
            var placeValue = 1L;
            
            for (final var prime : PRIMES) {
                value += (sc.nextInt() * placeValue);
                placeValue *= prime;
            }
            System.out.println(MAX_VALUE - value);
        }
    }

}

