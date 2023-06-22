import java.util.Scanner;

/**
 * Solution to the "Kornislav" problem on Kattis.
 * @author Brendan Jones
 */
public class Kornislav {

    private static int calculateArea(int right, int up, int left, int down) {
        if (right >= left && down >= up) {
            return left * up;
        }
        return -1;
    }

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            final var d1 = sc.nextInt();
            final var d2 = sc.nextInt();
            final var d3 = sc.nextInt();
            final var d4 = sc.nextInt();

            var area = 0;

            area = Math.max(calculateArea(d1, d2, d3, d4), area);
            area = Math.max(calculateArea(d1, d2, d4, d3), area);
            area = Math.max(calculateArea(d1, d3, d2, d4), area);
            area = Math.max(calculateArea(d1, d3, d4, d2), area);
            area = Math.max(calculateArea(d1, d4, d2, d3), area);
            area = Math.max(calculateArea(d1, d4, d3, d2), area);

            area = Math.max(calculateArea(d2, d1, d3, d4), area);
            area = Math.max(calculateArea(d2, d1, d4, d3), area);
            area = Math.max(calculateArea(d2, d3, d1, d4), area);
            area = Math.max(calculateArea(d2, d3, d4, d1), area);
            area = Math.max(calculateArea(d2, d4, d1, d3), area);
            area = Math.max(calculateArea(d2, d4, d3, d1), area);

            area = Math.max(calculateArea(d3, d1, d2, d4), area);
            area = Math.max(calculateArea(d3, d1, d4, d2), area);
            area = Math.max(calculateArea(d3, d2, d1, d4), area);
            area = Math.max(calculateArea(d3, d2, d4, d1), area);
            area = Math.max(calculateArea(d3, d4, d1, d2), area);
            area = Math.max(calculateArea(d3, d4, d2, d1), area);

            area = Math.max(calculateArea(d4, d1, d2, d3), area);
            area = Math.max(calculateArea(d4, d1, d3, d2), area);
            area = Math.max(calculateArea(d4, d2, d1, d3), area);
            area = Math.max(calculateArea(d4, d2, d3, d1), area);
            area = Math.max(calculateArea(d4, d3, d1, d2), area);
            area = Math.max(calculateArea(d4, d3, d2, d1), area);

            System.out.println(area);
        }
    }

}

