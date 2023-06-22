import java.util.Scanner;

/**
 * Solution to the "Digital Display" problem on Kattis.
 * @author Brendan Jones
 */
public class Display {

    /**
     * The height of a character.
     */
    private static final int CHAR_HEIGHT = 7;

    /**
     * The representations for each digital character.
     */
    private static final String[][] CHAR_VALUES = {
            {
                    "+---+",
                    "|   |",
                    "|   |",
                    "+   +",
                    "|   |",
                    "|   |",
                    "+---+",
            },
            {
                    "    +",
                    "    |",
                    "    |",
                    "    +",
                    "    |",
                    "    |",
                    "    +"
            },
            {
                    "+---+",
                    "    |",
                    "    |",
                    "+---+",
                    "|    ",
                    "|    ",
                    "+---+"
            },
            {
                    "+---+",
                    "    |",
                    "    |",
                    "+---+",
                    "    |",
                    "    |",
                    "+---+",
            },
            {
                    "+   +",
                    "|   |",
                    "|   |",
                    "+---+",
                    "    |",
                    "    |",
                    "    +"
            },
            {
                    "+---+",
                    "|    ",
                    "|    ",
                    "+---+",
                    "    |",
                    "    |",
                    "+---+"
            },
            {
                    "+---+",
                    "|    ",
                    "|    ",
                    "+---+",
                    "|   |",
                    "|   |",
                    "+---+"
            },
            {
                    "+---+",
                    "    |",
                    "    |",
                    "    +",
                    "    |",
                    "    |",
                    "    +"
            },
            {
                    "+---+",
                    "|   |",
                    "|   |",
                    "+---+",
                    "|   |",
                    "|   |",
                    "+---+"
            },
            {
                    "+---+",
                    "|   |",
                    "|   |",
                    "+---+",
                    "    |",
                    "    |",
                    "+---+"
            },
            {
                    " ",
                    " ",
                    "o",
                    " ",
                    "o",
                    " ",
                    " "
            }
    };

    /**
     * Processes a single test case.
     * @param sc The input scanner.
     * @return Whether another test case follows this one.
     */
    private static boolean processTestCase(Scanner sc) {
        final var line = sc.next();
        if (line.equals("end")) {
            System.out.println("end");
            return false;
        }

        final var b = new StringBuilder();
        for (var row = 0; row < CHAR_HEIGHT; ++row) {
            for (var i = 0; i < line.length(); ++i) {
                final var ch = line.charAt(i);

                final var index = Character.isDigit(ch) ? ch - '0' : CHAR_VALUES.length - 1;

                b.append(CHAR_VALUES[index][row]);

                if (i != line.length() - 1) {
                    b.append("  ");
                }
            }
            b.append('\n');
        }
        b.append("\n\n");

        System.out.print(b);
        return true;
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            while (processTestCase(sc));
        }
    }

}

