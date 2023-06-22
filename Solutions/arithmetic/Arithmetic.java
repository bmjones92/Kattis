import java.util.Scanner;

/**
 * Solution to the "Arithmetic" problem on Kattis.
 * @author Brendan Jones
 */
public class Arithmetic {

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var input = sc.next();
            if (input.equals("0")) {
                System.out.println(0);
            }

            // The total number of bits to represent the number.
            final var totalBits = (input.length() * 3);

            // The number of bits in the first hex character.
            var requiredBits = (totalBits % 4);
            if (requiredBits == 0) {
                requiredBits = 4;
            }

            // Whether a character has been extracted and written yet.
            final var b = new StringBuilder();

            // The number of bits currently available to read.
            var availableBits = 0;

            // Stores the bit data as we convert between characters.
            var storage = 0;

            // Loop through each character in the octal string and construct the hex string from it.
            for (var i = 0; i < input.length(); ++i) {
                // 'Normalize' the octal character in the range [0,7]
                final var ch = input.charAt(i) - '0';

                // An octal character uses 3 bits.
                storage = (storage << 3) | ch;
                availableBits += 3;

                // Determine if we have enough data buffered to extract a character.
                if (availableBits >= requiredBits) {
                    // Isolate the bits that are relevant to the character we are currently trying to extract.
                    final var mask = (storage >> (availableBits - requiredBits)) % 16;

                    // Clear the data that we just extracted from the mask.
                    storage &= (1 << (availableBits - requiredBits)) - 1;

                    // Avoid printing out any leading zeros.
                    if (b.length() != 0 || mask != 0) {
                        if (mask < 10) {
                            b.append(mask);
                        } else {
                            b.append((char) ('A' + (mask - 10)));
                        }
                    }

                    availableBits -= requiredBits;

                    requiredBits = 4;
                }
            }

            System.out.println(b);
        }
    }
}
