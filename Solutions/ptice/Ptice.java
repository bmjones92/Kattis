import java.util.Scanner;

/**
 * Solution to the "Ptice" problem on Kattis.
 * @author Brendan Jones
 */
public class Ptice {

    /**
     * The sequence that Adrian thinks is best.
     */
    private static final char[] PATTERN_ADRIAN = { 'A', 'B', 'C' };

    /**
     * The sequence that Bruno thinks is best.
     */
    private static final char[] PATTERN_BRUNO = { 'B', 'A', 'B', 'C' };

    /**
     * The sequence that Goran thinks is best.
     */
    private static final char[] PATTERN_GORAN = { 'C', 'C', 'A', 'A', 'B', 'B' };

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var numAnswers = sc.nextInt();
            final var answers = sc.next();

            var numCorrectAdrian = 0;
            var numCorrectBruno = 0;
            var numCorrectGoran = 0;

            for (var i = 0; i < numAnswers; ++i) {
                final var ch = answers.charAt(i);
                if (PATTERN_ADRIAN[i % PATTERN_ADRIAN.length] == ch) {
                    numCorrectAdrian++;
                }
                if(PATTERN_BRUNO[i % PATTERN_BRUNO.length] == ch) {
                    numCorrectBruno++;
                }
                if(PATTERN_GORAN[i % PATTERN_GORAN.length] == ch) {
                    numCorrectGoran++;
                }
            }

            final var numCorrectMax = Math.max(numCorrectAdrian, Math.max(numCorrectBruno, numCorrectGoran));
            System.out.println(numCorrectMax);

            if (numCorrectAdrian == numCorrectMax) {
                System.out.println("Adrian");
            }
            if (numCorrectBruno == numCorrectMax) {
                System.out.println("Bruno");
            }
            if (numCorrectGoran == numCorrectMax) {
                System.out.println("Goran");
            }
        }
    }

}
