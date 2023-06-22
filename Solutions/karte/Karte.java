import java.util.HashSet;
import java.util.Scanner;

/**
 * Solution to the "Karte" problem on Kattis.
 * @author Brendan Jones
 */
public class Karte {

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var cards = new HashSet<String>();


            var missingP = 13;
            var missingK = 13;
            var missingH = 13;
            var missingT = 13;

            final var line = sc.next();
            for (int i = 0; i < line.length() / 3; ++i) {
                final var card = line.substring(i * 3, (i + 1) * 3);
                if (!cards.add(card)) {
                    System.out.println("GRESKA");
                    return;
                }

                switch(card.charAt(0)) {
                    case 'P':
                        missingP--;
                        break;
                    case 'K':
                        missingK--;
                        break;
                    case 'H':
                        missingH--;
                        break;
                    case 'T':
                        missingT--;
                        break;
                }
            }

            System.out.println(missingP + " " + missingK + " " + missingH + " " + missingT);
        }
    }

}

