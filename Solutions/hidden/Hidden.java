import java.util.Scanner;

/**
 * Solution to the "Hidden Password" problem on Kattis.
 * @author Brendan Jones
 */
public class Hidden {

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var password = sc.next();
            final var input = sc.next();

            var passwordIndex = 0;
            for (var i = 0; i < input.length() && passwordIndex != password.length() && passwordIndex != -1; ++i) {
                if (password.charAt(passwordIndex) == input.charAt(i)) {
                    passwordIndex++;
                } else {
                    for (var j = passwordIndex + 1; j < password.length(); ++j) {
                        if (password.charAt(j) == input.charAt(i)) {
                            passwordIndex = -1;
                            break;
                        }
                    }
                }
            }

            if (passwordIndex == password.length()) {
                System.out.println("PASS");
            } else {
                System.out.println("FAIL");
            }
        }
    }

}
