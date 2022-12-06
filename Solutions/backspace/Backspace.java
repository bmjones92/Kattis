import java.util.Scanner;

/**
 * Solution to the "Backspace" problem on Kattis.
 * @author Brendan Jones
 */
public class Backspace {

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var input = sc.nextLine();

            var length = 0;
            var chars = new char[input.length()];

            for (final var ch : input.toCharArray()) {
                if (ch != '<') {
                    chars[length++] = ch;
                } else {
                    length--;
                }
            }

            final var result = new String(chars, 0, length);
            System.out.println(result);
        }
    }

}