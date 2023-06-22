import java.util.Scanner;

/**
 * Solution to the "Quadrant Selection" problem on Kattis.
 * @author Brendan Jones
 */
public class Quadrant {
    
    public static void main(String[] args ) {
        try (final var sc = new Scanner(System.in)) {
            final var x = sc.nextInt();
            final var y = sc.nextInt();
            if (x > 0) {
                if (y > 0) {
                    System.out.println(1);
                } else {
                    System.out.println(4);
                }
            } else {
                if (y > 0) {
                    System.out.println(2);
                } else {
                    System.out.println(3);
                }
            }
        }
    }
    
}
