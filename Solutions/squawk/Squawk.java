import java.util.Scanner;

/**
 * Solution to the "Squawk Virus" problem on Kattis.
 * @author Brendan Jones
 */
public class Squawk {

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var numUsers = sc.nextInt();
            final var numEdges = sc.nextInt();
            final var initialInfection = sc.nextInt();
            final var numMinutes = sc.nextInt();

            final var edges = new boolean[numUsers][numUsers];
            for (var i = 0; i < numEdges; ++i) {
                final var userA = sc.nextInt();
                final var userB = sc.nextInt();
                edges[userA][userB] = true;
                edges[userB][userA] = true;
            }

            var currentInfectionState = new long[numUsers];
            currentInfectionState[initialInfection] = 1;

            var numInfectionsSent = 0L;

            for (var currentMinute = 1; currentMinute <= numMinutes; currentMinute++) {
                final var newInfectionState = new long[numUsers];

                numInfectionsSent = 0;

                for (var currentUser = 0; currentUser < numUsers; ++currentUser) {
                    // Only infect connected users if we are currently infected.
                    final var currentUserInfections = currentInfectionState[currentUser];
                    if (currentUserInfections != 0) {
                        for (var connectedUser = 0; connectedUser < numUsers; connectedUser++) {
                            if (edges[currentUser][connectedUser]) {
                                newInfectionState[connectedUser] += currentUserInfections;
                                numInfectionsSent += currentUserInfections;
                            }
                        }
                    }
                }

                currentInfectionState = newInfectionState;
            }

            System.out.println(numInfectionsSent);
        }
    }

}
