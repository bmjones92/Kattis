import java.util.Scanner;

/**
 * Solution to the "Missing Numbers" problem on Kattis.
 * @author Brendan Jones
 */
public class MissingNumbers {

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var numNumbers = sc.nextInt();

            var maxNumber = 0;
            final var numbers = new boolean[200];
            for (var i = 0; i < numNumbers; ++i) {
                final var number = sc.nextInt();
                numbers[number - 1] = true;
                maxNumber = Math.max(maxNumber, number);
            }

            if (numNumbers == maxNumber) {
                System.out.println("good job");
            } else {
                for (var i = 0; i < maxNumber; ++i) {
                    if (!numbers[i]) {
                        System.out.println(i + 1);
                    }
                }
            }
        }
    }

}

