import java.util.Scanner;

/**
 * Solution for the "Anthony and Diablo" problem on Kattis.
 * @author Brendan Jones
 */
public class AnthonyAndDiablo {
	
	public static void main(String[] args) {
		try (final var sc = new Scanner(System.in)) {
			final var area = sc.nextDouble();
			final var available = sc.nextDouble();
			
			
			final var radius = Math.sqrt(area / Math.PI);
			
			final var required = 2.0 * Math.PI * radius;
			if (required <= available) {
				System.out.println("Diablo is happy!");
			} else {
				System.out.println("Need more materials!");
			}
		}
	}

}
