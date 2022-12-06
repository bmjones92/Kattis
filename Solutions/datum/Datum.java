import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * Solution to the "Datum" problem on Kattis.
 * @author Brendan Jones
 */
public class Datum {
    
    /**
     * String reprentations for the days of the week.
     */
    private static String[] DAYS_OF_WEEK = {
        "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"
    };
    
    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var calendar = new GregorianCalendar();
            calendar.set(GregorianCalendar.YEAR, 2009);
            calendar.set(GregorianCalendar.DAY_OF_MONTH, sc.nextInt());
            calendar.set(GregorianCalendar.MONTH, sc.nextInt() - 1);
            
            System.out.println(DAYS_OF_WEEK[calendar.get(GregorianCalendar.DAY_OF_WEEK) - 1]);
        }
    }

}
