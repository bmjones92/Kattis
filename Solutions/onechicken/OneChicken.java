import java.util.Scanner;

/**
 * Solution to the "One Chicken Per Person!" problem on Kattis.
 * @author Brendan Jones
 */
public class OneChicken {
    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var numPeople = sc.nextInt();
            final var numChicken = sc.nextInt();

            final var remaining = numChicken - numPeople;
            if (remaining < 0) {
                System.out.printf("Dr. Chaz needs %d more %s of chicken!", -remaining, (remaining == -1) ? "piece" : "pieces");
            } else {
                System.out.printf("Dr. Chaz will have %d %s of chicken left over!", remaining, (remaining == 1) ? "piece" : "pieces");
            }
        }
    }

}
