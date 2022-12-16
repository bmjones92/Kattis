import java.util.Scanner;

/**
 * Solution to the "Quality-Adjusted Life-Year" problem on Kattis.
 * @author Brendan Jones
 */
public class QALY {
    
    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            var result = 0.0f;
            
            final var numEntries = sc.nextInt();
            for (var i = 0; i < numEntries; ++i) {
                result += (sc.nextFloat() * sc.nextFloat());
            }
            System.out.println(result);
        }
    }
    
}
