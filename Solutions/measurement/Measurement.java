import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Solution to the "Imperial Measurement" problem on Kattis.
 */
public class Measurement {

    /**
     * Maps each unit to its measurement in thou.
     */
    private static final Map<String, Integer> measurements = new HashMap<>();

    static {
        var scale = 1;
        measurements.put("thou", scale);
        measurements.put("th", scale);

        scale *= 1000;
        measurements.put("inch", scale);
        measurements.put("in", scale);

        scale *= 12;
        measurements.put("foot", scale);
        measurements.put("ft", scale);

        scale *= 3;
        measurements.put("yard", scale);
        measurements.put("yd", scale);

        scale *= 22;
        measurements.put("chain", scale);
        measurements.put("ch", scale);

        scale *= 10;
        measurements.put("furlong", scale);
        measurements.put("fur", scale);

        scale *= 8;
        measurements.put("mile", scale);
        measurements.put("mi", scale);

        scale *= 3;
        measurements.put("league", scale);
        measurements.put("lea", scale);
    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var units = sc.nextInt();

            final var fromUnits = measurements.get(sc.next());

            // Always "in". Can safely be ignored.
            sc.next();

            final var toUnits = measurements.get(sc.next());

            System.out.println((double) fromUnits / toUnits * units);
        }
    }

}
