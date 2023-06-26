import java.util.Scanner;

/**
 * Solution to the "WERTYU" problem on Kattis.
 * @author Brendan Jones
 */
public class WERTYU {

    /**
     * Maps keyboard characters to the character to its left.
     */
    private static final char[] MAPPINGS = new char[128];
    
    static {
        MAPPINGS[' '] = ' ';
        MAPPINGS['1'] = '`';
        MAPPINGS['2'] = '1';
        MAPPINGS['3'] = '2';
        MAPPINGS['4'] = '3';
        MAPPINGS['5'] = '4';
        MAPPINGS['6'] = '5';
        MAPPINGS['7'] = '6';
        MAPPINGS['8'] = '7';
        MAPPINGS['9'] = '8';
        MAPPINGS['0'] = '9';
        MAPPINGS['-'] = '0';
        MAPPINGS['='] = '-';
        MAPPINGS['W'] = 'Q';
        MAPPINGS['E'] = 'W';
        MAPPINGS['R'] = 'E';
        MAPPINGS['T'] = 'R';
        MAPPINGS['Y'] = 'T';
        MAPPINGS['U'] = 'Y';
        MAPPINGS['I'] = 'U';
        MAPPINGS['O'] = 'I';
        MAPPINGS['P'] = 'O';
        MAPPINGS['['] = 'P';
        MAPPINGS[']'] = '[';
        MAPPINGS['\\'] = ']';
        MAPPINGS['S'] = 'A';
        MAPPINGS['D'] = 'S';
        MAPPINGS['F'] = 'D';
        MAPPINGS['G'] = 'F';
        MAPPINGS['H'] = 'G';
        MAPPINGS['J'] = 'H';
        MAPPINGS['K'] = 'J';
        MAPPINGS['L'] = 'K';
        MAPPINGS[';'] = 'L';
        MAPPINGS['\''] = ';';
        MAPPINGS['X'] = 'Z';
        MAPPINGS['C'] = 'X';
        MAPPINGS['V'] = 'C';
        MAPPINGS['B'] = 'V';
        MAPPINGS['N'] = 'B';
        MAPPINGS['M'] = 'N';
        MAPPINGS[','] = 'M';
        MAPPINGS['.'] = ',';
        MAPPINGS['/'] = '.';
    }

    /**
     * Processes a single test case.
     * @param sc The input scanner.
     * @param b The output builder.
     */
    private static void processTestCase(Scanner sc, StringBuilder b) {
        final var line = sc.nextLine();
        line.chars().map(ch -> MAPPINGS[ch]).forEach(b::appendCodePoint);
        b.append('\n');
    }


    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var b = new StringBuilder();
            while (sc.hasNextLine()) {
                processTestCase(sc, b);
            }
            System.out.print(b);
        }
    }
}

