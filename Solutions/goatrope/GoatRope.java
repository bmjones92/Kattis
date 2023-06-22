import java.util.Scanner;

/**
 * Solution to the "Goat Rope" problem on Kattis.
 * @author Brendan Jones
 */
public class GoatRope {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            final var x = sc.nextInt();
            final var y = sc.nextInt();

            final var x1 = sc.nextInt();
            final var y1 = sc.nextInt();
            final var x2 = sc.nextInt();
            final var y2 = sc.nextInt();

            final var width = x2 - x1;
            final var height = y2 - y1;

            final var centerX = x1 + (width / 2);
            final var centerY = y1 + (height / 2);

            final var dx = Math.max(Math.abs(x - centerX) - width / 2, 0);
            final var dy = Math.max(Math.abs(y - centerY) - height / 2, 0);

            final var dist = Math.sqrt(dx * dx + dy * dy);
            System.out.println(dist);
        }
    }

}

