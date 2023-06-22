import java.util.Scanner;

/**
 * Solution to the "Seven Wonders" problem on Kattis.
 * @author Brendan Jones
 */
public class SevenWonders {

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            var numT = 0;
            var numC = 0;
            var numG = 0;

            final var line = sc.nextLine();
            for (var ch : line.toCharArray()) {
                switch(ch) {
                    case 'T':
                        numT++;
                        break;
                    case 'C':
                        numC++;
                        break;
                    case 'G':
                        numG++;
                        break;
                }
            }

            final var completedSets = Math.min(numT, Math.min(numC, numG));

            final var totalScore = numT * numT + numC * numC + numG * numG + completedSets * 7;
            System.out.println(totalScore);
        }
    }

}

