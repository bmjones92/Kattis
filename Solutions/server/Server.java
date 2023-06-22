import java.util.Scanner;

/**
 * Solution to the "Server" problem on Kattis.
 * @author Brendan Jones
 */
public class Server {

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var numTasks = sc.nextInt();
            var remainingTime = sc.nextInt();

            for (var i = 0; i < numTasks; ++i) {
                final var taskTime = sc.nextInt();

                remainingTime -= taskTime;
                if (remainingTime < 0) {
                    System.out.println(i);
                    return;
                }
            }

            System.out.println(numTasks);
        }
    }

}

