import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Solution to the "Adding Words" problem on Kattis.
 * @author Brendan Jones
 */
public class AddingWords {

    /**
     * Output to produce when a "calc" operation produces an unknown output.
     */
    private static final String OUTPUT_UNKNOWN = "unknown";

    /**
     * Maps variable names to their values.
     */
    private static final Map<String, Integer> defsStringToInteger = new HashMap<>();

    /**
     * Maps variable values to their names.
     */
    private static final Map<Integer, String> defsIntegerToString = new HashMap<>();

    /**
     * Entry point of the program
     * @param args Unused
     */
    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            while (sc.hasNext()) {
                final var command = sc.next();
                switch (command) {
                    case "def":
                        commandDef(sc);
                        break;
                    case "calc":
                        commandCalc(sc);
                        break;
                    case "clear":
                        commandClear();
                        break;
                }
            }
        }
    }

    /**
     * Process a definition command.
     * @param sc The scanner instance.
     */
    private static void commandDef(Scanner sc) {
        // Read the variable name and value.
        final var name = sc.next();
        final var value = sc.nextInt();

        // Store the variable name and value in maps to retrieve later.
        final var oldValue = defsStringToInteger.get(name);
        if (oldValue != null) {
            defsIntegerToString.remove(oldValue);
        }

        defsStringToInteger.put(name, value);
        defsIntegerToString.put(value, name);
    }

    /**
     * Process a calculation command.
     * @param sc The scanner instance.
     */
    private static void commandCalc(Scanner sc) {
        // Read the calculation expression.
        final var line = sc.nextLine().trim();
        // Split the definition individual elements.
        final var tokens = line.split(" ");

        // The total value of this command.
        var total = 0;

        // Default operation is addition.
        var operator = "+";

        for (var i = 0; i < tokens.length; ++i) {
            final var isVariable = (i % 2) == 0;
            if (isVariable) {
                // Reading in a variable.
                final var value = defsStringToInteger.get(tokens[i]);
                if (value == null) {
                    // The variable is not registered, so return unknown.
                    total = Integer.MAX_VALUE;
                    break;
                }

                // Update the value based on the current operator.
                switch (operator) {
                    case "+":
                        total += value;
                        break;
                    case "-":
                        total -= value;
                        break;
                }
            } else {
                // Reading in an operator.
                operator = tokens[i];
            }
        }

        // Find the name of the variable mapped to the value.
        final var variableName = defsIntegerToString.get(total);
        if (variableName == null) {
            //Variable does not exist.
            total = Integer.MAX_VALUE;
        }

        // Print the calculation result.
        final var answer = (total == Integer.MAX_VALUE) ? OUTPUT_UNKNOWN : variableName;
        System.out.println(line + " " + answer);
    }

    /**
     * Process the clear command.
     */
    private static void commandClear() {
        defsStringToInteger.clear();
        defsIntegerToString.clear();
    }

}
