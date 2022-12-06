import java.util.Scanner;

/**
 * Solution to the "Bit by Bit" problem on Kattis.
 * @author Brendan Jones
 */
public class BitByBit {

    /**
     * The width of the register.
     */
    private static final int REGISTER_SIZE = 32;

    private static void processTestCase(Scanner sc, int numInstructions) {
        // Using bit-twiddling would probably be more efficient, but it makes the code a lot more difficult to read.
        final var bits = new boolean[REGISTER_SIZE];
        final var known = new boolean[REGISTER_SIZE];

        for (var i = 0; i < numInstructions; ++i) {
            final var instruction = sc.next();
            switch (instruction) {
                case "SET": {
                    final var bit = sc.nextInt();
                    bits[bit] = true;
                    known[bit] = true;
                    break;
                }
                case "CLEAR": {
                    final var bit = sc.nextInt();
                    bits[bit] = false;
                    known[bit] = true;
                    break;
                }
                case "AND": {
                    final var a = sc.nextInt();
                    final var b = sc.nextInt();

                    if (known[a] && known[b]) {
                        bits[a] &= bits[b];
                    } else if (known[a] ^ known[b]) {
                        final var index = known[a] ? a : b;
                        if (bits[index]) {
                            known[a] = false;
                        } else {
                            bits[a] = false;
                            known[a] = true;
                        }
                    }
                    break;
                }
                case "OR": {
                    final var a = sc.nextInt();
                    final var b = sc.nextInt();
                    if (known[a] && known[b]) {
                        bits[a] |= bits[b];
                    } else if (known[a] ^ known[b]) {
                        final var index = known[a] ? a : b;
                        if (bits[index]) {
                            bits[a] = true;
                            known[a] = true;
                        } else {
                            known[a] = false;
                        }
                    }
                    break;
                }
            }
        }

        final var b = new StringBuilder();
        for (var i = REGISTER_SIZE - 1; i >= 0; --i) {
            if (known[i]) {
                b.append(bits[i] ? '1' : '0');
            } else {
                b.append('?');
            }
        }

        System.out.println(b);
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            int numInstructions;
            while ((numInstructions = sc.nextInt()) != 0) {
                processTestCase(sc, numInstructions);
            }
        }
    }

}