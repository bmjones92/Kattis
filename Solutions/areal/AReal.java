import java.util.Scanner;

/**
 * Solution to the "A Real Challenge" problem on Kattis.
 * @author Brendan Jones
 */
public class AReal {
    
    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var area = sc.nextLong();
            final var length = 4 * Math.sqrt(area);
        
            System.out.println(length);
        }
    }
    
}
