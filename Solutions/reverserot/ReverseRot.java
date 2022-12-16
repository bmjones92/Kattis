import java.util.Scanner;

/**
 * Solution to the "Reverse Rot" problem on Kattis.
 * @author Brendan Jones
 */
public class ReverseRot {

    /**
     * The list of valid characters.
     */
    private static final String VALID_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ_.";
    
    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            int rot;
            while ((rot = sc.nextInt()) != 0) {
                final var message = sc.next();

                final var b = new StringBuilder();
                for (var i = message.length() - 1; i >= 0; --i) {
                    final var ch = message.charAt(i);
                    final var index = (VALID_CHARS.indexOf(ch) + rot) % VALID_CHARS.length();
                    b.append(VALID_CHARS.charAt(index));
                }
                
                System.out.println(b);
            }
        }
    }
    
}
