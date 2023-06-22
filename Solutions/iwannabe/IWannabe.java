import java.util.*;
import java.util.function.ToLongFunction;

/**
 * Solution to the "I Wanna Be The Very Best" problem on Kattis.
 * @author Brendan Jones
 */
public class IWannabe {

    private static class Pokenom {

        /**
         * The attack rating.
         */
        private final long attack;

        /**
         * The defense rating.
         */
        private final long defense;

        /**
         * The health rating.
         */
        private final long health;

        /**
         * Creates a new Pokenom.
         * @param atk The attack rating.
         * @param def The defense rating.
         * @param health The health rating.
         */
        private Pokenom(long atk, long def, long health) {
            this.attack = atk;
            this.defense = def;
            this.health = health;
        }
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            final var numPokemon = sc.nextInt();
            final var numToChoose = sc.nextInt();

            // Populate the roster of available Pokenoms.
            final var roster = new ArrayList<Pokenom>(numPokemon);
            for (var i = 0; i < numPokemon; ++i) {
                final var atk = sc.nextLong();
                final var def = sc.nextLong();
                final var health = sc.nextLong();
                roster.add(new Pokenom(atk, def, health));
            }

            // Create the team.
            final var team = new HashSet<Pokenom>();
            addToTeam(team, roster, numToChoose, x -> x.attack);
            addToTeam(team, roster, numToChoose, x -> x.defense);
            addToTeam(team, roster, numToChoose, x -> x.health);

            // Output the team size.
            System.out.println(team.size());
        }
    }

    private static void addToTeam(Set<Pokenom> team, List<Pokenom> roster, int count, ToLongFunction<Pokenom> func) {
        roster.sort(Comparator.comparingLong(func).reversed());
        for (var i = 0; i < count; ++i) {
            team.add(roster.get(i));
        }
    }

}

