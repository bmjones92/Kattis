import java.util.Scanner;

/**
 * Solution to the "IsItHalloween.com" problem on Kattis.
 * @author Brendan Jones
 */
public class IsItHalloween {
    
    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var date = sc.nextLine();
            System.out.println((date.equals("OCT 31") || date.equals("DEC 25")) ? "yup" : "nope");
        }
    }
    
}