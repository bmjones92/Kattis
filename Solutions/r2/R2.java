import java.util.Scanner;

/**
 * Solution to the "R2" problem on Kattis.
 * @author Brendan Jones
 */
public class R2 {
    
    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            System.out.println(-sc.nextInt() + 2 * sc.nextInt());
        }
    }

}
