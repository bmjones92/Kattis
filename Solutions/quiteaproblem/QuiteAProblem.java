import java.util.Scanner;

/**
 * Solution to the "Quite a Problem" problem on Kattis.
 * @author Brendan Jones
 */
public class QuiteAProblem {
    
    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            while (sc.hasNextLine()) {
                final var line = sc.nextLine().toLowerCase();
                if (line.contains("problem")) {
                    System.out.println("yes");
                } else {
                    System.out.println("no");
                }
            }
        }
    }

}
