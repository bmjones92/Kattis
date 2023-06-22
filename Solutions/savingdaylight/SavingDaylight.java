import java.util.Scanner;

/**
 * Solution to the "Saving Daylight" problem on Kattis.
 * @author Brendan Jones
 */
public class SavingDaylight {
    
    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var bldr = new StringBuilder();
            while (sc.hasNext()) {
                final var month = sc.next();
                final var day = sc.nextInt();
                final var year = sc.nextInt();
                
                final var tokensRise = sc.next().split(":");
                final var tokensSet = sc.next().split(":");
                
                final var riseHours = Integer.parseInt(tokensRise[0]);
                final var riseMins = Integer.parseInt(tokensRise[1]);
                
                final var setHours = Integer.parseInt(tokensSet[0]);
                final var setMins = Integer.parseInt(tokensSet[1]);
                
                var resHours = setHours - riseHours;
                var resMins = setMins - riseMins;
                if (resMins < 0) {
                    resMins += 60;
                    resHours--;
                }
                
                bldr.append(
                    String.format("%s %d %d %d hours %d minutes%n", month, day, year, resHours, resMins)
                );
            }            
            System.out.print(bldr);
        }
    }

}

