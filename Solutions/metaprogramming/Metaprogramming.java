import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Solution to the "Metaprogramming" problem on Kattis.
 * @author Brendan Jones
 */
public class Metaprogramming {

    /**
     * Runs a "define" command.
     * @param command The command string.
     * @param variables The current variable mappings.
     */
    private static void define(String[] command, Map<String, Integer> variables) {
        variables.put(command[2], Integer.parseInt(command[1]));
    }

    /**
     * Runs an "eval" command.
     * @param command The command string.
     * @param variables The current variable mappings.
     */
    private static void eval(String[] command, Map<String, Integer> variables) {
        final var x = variables.get(command[1]);
        final var y = variables.get(command[3]);

        if (x == null || y == null) {
            System.out.println("undefined");
        } else {
            switch (command[2]) {
                case "<":
                    System.out.println(x < y);
                    break;
                case ">":
                    System.out.println(x > y);
                    break;
                case "=":
                    System.out.println(x.equals(y));
                    break;
                default:
                    throw new RuntimeException("Unexpected comparison operator: " + command[2]);
            }
        }
    }

    public static void main(String[] args) {
        try(final var sc = new Scanner(System.in)) {
            final var variables = new HashMap<String, Integer>();
            while (sc.hasNextLine()) {
                final var command = sc.nextLine().split(" ");
                switch (command[0]) {
                    case "define":
                        define(command, variables);
                        break;
                    case "eval":
                        eval(command, variables);
                        break;
                    default:
                        throw new RuntimeException("Unexpected command: " + command[0]);
                }
            }
        }
    }

}
