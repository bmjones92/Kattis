import java.util.Scanner;

/**
 * Solution to the "Semafori" problem on Kattis.
 * @author Brendan Jones
 */
public class Semafori {

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var numLights = sc.nextInt();
            final var roadLength = sc.nextInt();

            var currentTime = 0;
            var lastPosition = 0;

            for (var i = 0; i < numLights; ++i) {
                final int lightPosition = sc.nextInt();
                final int redDuration = sc.nextInt();
                final int greenDuration = sc.nextInt();

                currentTime += lightPosition - lastPosition;

                final var cycleTime = currentTime % (redDuration + greenDuration);
                if (cycleTime < redDuration) {
                    currentTime += redDuration - cycleTime;
                }

                lastPosition = lightPosition;
            }

            currentTime += (roadLength - lastPosition);
            System.out.println(currentTime);
        }

    }

}

