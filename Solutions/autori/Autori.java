import java.util.Scanner;

/**
 * Solution to the "Autori" problem on Kattis.
 * @author Brendan Jones
 */
public class Autori {
    
    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var line = sc.next();
            final var tokens = line.split("-");
            for (final var token : tokens) {
                System.out.print(token.charAt(0));
            }
            System.out.println();
        }
    }

}