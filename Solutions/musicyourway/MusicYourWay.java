import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * Solution to the "Music Your Way" problem on Kattis.
 * @author Brendan Jones
 */
public class MusicYourWay {

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var attributes = readAttributes(sc);
            final var songs = readSongs(sc, attributes.size());

            final var numSorts = sc.nextInt();
            for (var i = 0; i < numSorts; ++i) {
                final var index = attributes.indexOf(sc.next());

                songs.sort(Comparator.comparing(a -> a.get(index)));

                System.out.println(String.join(" ", attributes));
                songs.forEach(song -> System.out.println(String.join(" ", song)));
                System.out.println();
            }
        }
    }

    private static List<String> readAttributes(Scanner sc) {
        final var attributes = new ArrayList<String>();
        while (!sc.hasNextInt()) {
            attributes.add(sc.next());
        }
        return attributes;
    }

    private static List<List<String>> readSongs(Scanner sc, int numAttributes) {
        final var songs = new ArrayList<List<String>>();

        final var numSongs = sc.nextInt();
        for (var i = 0; i < numSongs; ++i) {
            final var song = new ArrayList<String>();
            for (var j = 0; j < numAttributes; ++j) {
                song.add(sc.next());
            }
            songs.add(song);
        }
        return songs;
    }

}

