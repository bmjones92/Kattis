import java.util.Scanner;
import java.util.Stack;

/**
 * Solution to the "Game of Throwns" problem on Kattis.
 * @author Brendan Jones
 */
public class Throwns {

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var numStudents = sc.nextInt();
            final var numCommands = sc.nextInt();

            final var state = new Stack<Integer>();
            state.push(0);

            for (var i = 0; i < numCommands; ++i) {
                if (sc.hasNextInt()) {
                    state.push(state.peek() + sc.nextInt());
                } else {
                    sc.next(); // Discard "undo"
                    final var numPops = sc.nextInt();
                    for (var j = 0; j < numPops; ++j) {
                        state.pop();
                    }
                }
            }

            var position = state.pop();
            if (position > 0) {
                position %= numStudents;
            } else if (position < 0) {
                while (position < 0) {
                    position += numStudents;
                }
            }
            System.out.println(position);
        }
    }

}

