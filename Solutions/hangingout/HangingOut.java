import java.util.Scanner;

/**
 * Solution to the "Hanging Out on the Terrace" problem on Kattis.
 * @author Brendan Jones
 */
public class HangingOut {

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var capacity = sc.nextInt();
            final var numEvents = sc.nextInt();

            // The number of times people were turned away.
            var numRejected = 0;
            // The number of people currently in the terrace.
            var numPeople = 0;

            for (var i = 0; i < numEvents; ++i) {
                final var event = sc.next();
                final var amount = sc.nextInt();
                switch (event) {
                    case "enter":
                        if (numPeople + amount > capacity) {
                            numRejected++;
                        } else {
                            numPeople += amount;
                        }
                        break;
                    case "leave":
                        numPeople -= amount;
                        break;
                }
            }
            System.out.println(numRejected);
        }
    }

}
