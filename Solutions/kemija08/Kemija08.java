import java.util.Scanner;

/**
 * Solution to the "Kemija" problem on Kattis.
 * @author Brendan Jones
 */
public class Kemija08 {

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            var line = sc.nextLine();
            line = line.replaceAll("apa", "a");
            line = line.replaceAll("epe", "e");
            line = line.replaceAll("ipi", "i");
            line = line.replaceAll("opo", "o");
            line = line.replaceAll("upu", "u");

            System.out.println(line);
        }
    }

}

