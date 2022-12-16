import java.util.Scanner;

/**
 * Solution to the "3D Printed Statues" problem on Kattis.
 * @author Brendan Jones
 */
public class Printer3D {

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var numStatues = sc.nextInt();

            final var numMachines = (int) Math.pow(2.0, Math.floor(Math.log(numStatues) / Math.log(2)));

            var numDays = 0;
            for (var i = 0; (numMachines >> i) != 1; ++i) {
                numDays++;
            }

            System.out.println(numDays + (int) Math.ceil((numStatues / (float) numMachines)));
        }
    }

}
