import java.util.HashMap;
import java.util.Scanner;

/**
 * Solution to the "Recount" problem on Kattis.
 * @author Brendan Jones
 */
public class Recount {

    /**
     * The result string if the winner is contested.
     */
    private static final String WINNER_CONTESTED = "Runoff!";

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var candidates = new HashMap<String, Integer>();

            var winnerName = WINNER_CONTESTED;
            var winnerVotes = 0;
            
            String name;
            while (!(name = sc.nextLine()).equals("***")) {
                var numVotes = candidates.get(name);
                if (numVotes == null) {
                    numVotes = 0;
                }
                numVotes++;
                
                if (numVotes > winnerVotes) {
                    winnerName = name;
                    winnerVotes = numVotes;
                } else if (numVotes == winnerVotes) {
                    winnerName = WINNER_CONTESTED;
                }
                candidates.put(name, numVotes + 1);
            }
            System.out.println(winnerName);
        }
    }

}
