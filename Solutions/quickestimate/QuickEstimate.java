import java.util.Scanner;

/**
 * Solution to the "Quick Estimates" problem on Kattis.
 * @author Brendan Jones
 */
public class QuickEstimate {
    
    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var numLines = sc.nextInt();
            for (var i = 0; i < numLines; ++i) {
                System.out.println(sc.next().length());
            }
        }
    }

}
