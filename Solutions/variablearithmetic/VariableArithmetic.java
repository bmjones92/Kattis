import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Solution to the "Variable Arithmetic" problem on Kattis
 * @author Brendan Jones
 */
public class VariableArithmetic {

    private static void processTestCase(Scanner sc) {
        final var definitions = new HashMap<String, Integer>();

        for (var line = sc.nextLine(); !line.equals("0"); line = sc.nextLine()) {
            final var tokens = line.split(" ");
            if (tokens.length > 1 && tokens[1].equals("=")) {
                definitions.put(tokens[0], Integer.parseInt(tokens[2]));
            } else {
                final var variables = new ArrayList<String>();

                var number = 0;
                for (final var token : tokens) {
                    if (token.equals("+")) {
                        continue;
                    }

                    try {
                        number += Integer.parseInt(token);
                    } catch (NumberFormatException e) {
                        final var value = definitions.get(token);
                        if (value == null) {
                            variables.add(token);
                        } else {
                            number += value;
                        }
                    }
                }

                final var b = new StringBuilder();
                if (number != 0) {
                    b.append(number);
                    if (!variables.isEmpty()) {
                        b.append(" + ");
                    }
                }

                for (var i = 0; i < variables.size(); ++i) {
                    b.append(variables.get(i));
                    if (i != variables.size() - 1) {
                        b.append(" + ");
                    }
                }

                System.out.println(b);
            }
        }
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            processTestCase(sc);
        }
    }

}
