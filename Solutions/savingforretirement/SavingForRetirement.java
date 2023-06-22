import java.util.Scanner;

/**
 * Solution to the "Saving for Retirement" problem on Kattis.
 * @author Brendan Jones
 */
public class SavingForRetirement {

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var bobAge = sc.nextInt();
            final var bobRetire = sc.nextInt();
            final var bobAnnualSavings = sc.nextInt();
            final var aliceAge = sc.nextInt();
            final var aliceAnnualSavings = sc.nextInt();
            
            final var bobFinalSavings = (bobRetire - bobAge) * bobAnnualSavings + 1;
            
            final var requiredYears = (int) Math.ceil((double) bobFinalSavings / aliceAnnualSavings);
            
            System.out.println(aliceAge + requiredYears);
        }
    }
    
}

