import java.util.Scanner;

/**
 * Solution to the "What does the Fox say?" problem on Kattis.
 * @author Brendan Jones
 */
public class WhatDoesTheFoxSay {

    /**
     * Processes a single test case.
     * @param sc The input scanner.
     * @param b The output builder.
     */
    private static void processTestCase(Scanner sc, StringBuilder b) {
        final var input = sc.nextLine().split(" ");
        final var isIdentified = new boolean[input.length];

        for (var line = sc.nextLine(); !line.equals("what does the fox say?"); line = sc.nextLine()) {
            final var tokens = line.split(" ");
            for (var i = 0; i < input.length; i++) {
                if (input[i].equals(tokens[2])) {
                    isIdentified[i] = true;
                }
            }
        }

        for (var i = 0; i < input.length; i++) {
            if (!isIdentified[i]) {
                b.append(input[i]).append(' ');
            }
        }
        b.append('\n');
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var b = new StringBuilder();

            final var numTestCases = Integer.parseInt(sc.nextLine());
            for (var i = 0; i < numTestCases; ++i) {
                processTestCase(sc, b);
            }

            System.out.print(b);
        }
    }

}
