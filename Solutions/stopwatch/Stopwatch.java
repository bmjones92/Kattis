import java.util.Scanner;

/**
 * Solution to the "Stopwatch" problem on Kattis.
 * @author Brendan Jones
 */
public class Stopwatch {

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            var lastTime = -1;
            var duration = 0;

            final var numPresses = sc.nextInt();
            for (var i = 0; i < numPresses; ++i) {
                final var time = sc.nextInt();
                if (lastTime == -1) {
                    lastTime = time;
                } else {
                    duration += (time - lastTime);
                    lastTime = -1;
                }
            }

            if (lastTime == -1) {
                System.out.println(duration);
            } else {
                System.out.println("still running");
            }
        }
    }

}
