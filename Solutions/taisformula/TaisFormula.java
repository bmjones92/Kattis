import java.util.Scanner;

/**
 * Solution to the "Tai's Formula" problem on Kattis.
 * @author Brendan Jones
 */
public class TaisFormula {

    /**
     * Represents a result.
     */
    private static class Result {

        /**
         * The time of the last sample.
         */
        private long time;

        /**
         * The value of the last sample.
         */
        private double value;

        /**
         * The running area of the samples.
         */
        private double area;

        /**
         * Creates a new Result with an initial sample.
         * @param time The time of the sample.
         * @param value The value of the sample.
         */
        public Result(long time, double value) {
            this.time = time;
            this.value = value;
        }

        /**
         * Adds a new sample to the result.
         * @param time The time of the sample.
         * @param value The value of the sample.
         */
        private void addSample(long time, double value) {
            area += ((this.value + value) / 2.0) * (time - this.time);
            this.time = time;
            this.value = value;
        }

    }

    public static void main(String[] args) {
        try (final var sc = new Scanner(System.in)) {
            final var numSamples = sc.nextInt();

            final var result = new Result(sc.nextLong(), sc.nextDouble());
            for (var i = 1; i < numSamples; i++) {
                result.addSample(sc.nextLong(), sc.nextDouble());
            }

            System.out.println(result.area / 1000.0);
        }
    }

}
