import java.util.Scanner;
import java.util.Stack;

/**
 * Solution to the "Circuit Math" problem on Kattis.
 * @author Brendan Jones
 */
public class CircuitMath {

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var inputs = new boolean[sc.nextInt()];
            for (var i = 0; i < inputs.length; ++i) {
                inputs[i] = sc.next().equals("T");
            }

            final var operands = new Stack<Boolean>();
            while (sc.hasNext()) {
                final var ch = sc.next().charAt(0);
                switch (ch) {
                    case '*':
                        operands.push(operands.pop() & operands.pop());
                        break;
                    case '+':
                        operands.push(operands.pop() | operands.pop());
                        break;
                    case '-':
                        operands.push(!operands.pop());
                        break;
                    default:
                        operands.push(inputs[ch - 'A']);
                        break;
                }
            }

            System.out.println(operands.pop() ? "T" : "F");
        }
    }

}

