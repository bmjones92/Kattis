import java.util.Scanner;

/**
 * Solution to the "Troll Hunt" problem on Kattis.
 * @author Brendan Jones
 */
public class TrollHunt {

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var numBridges = sc.nextInt() - 1;
            final var numKnights = sc.nextInt();
            final var minGroupSize = sc.nextInt();

            final var numGroups = numKnights / minGroupSize;

            var numDays = numBridges / numGroups;
            if (numBridges % numGroups != 0) {
                numDays++;
            }
            
            System.out.println(numDays);
        }
    }

}

