import java.util.Scanner;
import java.util.TreeSet;

/**
 * Solution to the "No Duplicates" problem on Kattis.
 * @author Brendan Jones
 */
public class NoDup {
    
    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var words = new TreeSet<String>();
            while (sc.hasNext()) {
                if (!words.add(sc.next())) {
                    System.out.println("no");
                    return;
                }
            }
            System.out.println("yes");
        }
    }

}