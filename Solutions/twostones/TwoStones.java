import java.util.Scanner;

/**
 * Solution to the "Take Two Stones" problem on Kattis.
 * @author Brendan Jones
 */
public class TakeTwoStones {
    
    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            System.out.println((sc.nextInt() % 2 == 1) ? "Alice" : "Bob");
        }
    }

}
