import java.util.Scanner;

/**
 * Solution to the "Stuck in a Time Loop" problem on Kattis.
 * @author Brendan Jones
 */
public class TimeLoop {

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            final var b = new StringBuilder();

            final var numLoops = sc.nextInt();
            for (int i = 1; i <= numLoops; i++) {
                b.append(i).append(" Abracadabra").append('\n');
            }
            System.out.print(b);
        }
    }

}