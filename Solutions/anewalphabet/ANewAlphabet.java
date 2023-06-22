import java.util.Scanner;

public class ANewAlphabet {

    /**
     * The replacement alphabet.
     */
    private static final String[] NEW_ALPHABET = {
            "@", "8", "(", "|)", "3", "#", "6", "[-]", "|",
            "_|", "|<", "1", "[]\\/[]", "[]\\[]", "0", "|D",
            "(,)", "|Z", "$", "']['", "|_|", "\\/", "\\/\\/",
            "}{", "`/", "2"
    };

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var message = sc.nextLine();

            final var b = new StringBuilder();
            for(final var ch : message.toCharArray()) {
                // Character is out of range, so ignore it.
                if (ch != 9 && (ch < 32 || ch > 126)) {
                    continue;
                }

                if(Character.isLowerCase(ch)) {
                    b.append(NEW_ALPHABET[ch - 'a']);
                } else if(Character.isUpperCase(ch)) {
                    b.append(NEW_ALPHABET[ch - 'A']);
                } else {
                    b.append(ch);
                }
            }

            System.out.print(b);
        }
    }

}

