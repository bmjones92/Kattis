import java.util.Scanner;

/**
 * Solution to the "Faktor" problem on Kattis.
 * @author Brendan Jones
 */
public class Faktor {
    
    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var numArticles = sc.nextFloat();
            final var requiredImpact = sc.nextFloat() - 1.0f;
            
            final var result = (int) (Math.ceil(numArticles * requiredImpact) + 1);
            
            System.out.println(result);
        }
    }

}

