import java.util.Scanner;

/**
 * Solution to the "Natrij" problem on Kattis.
 * @author Brendan Jones
 */
public class Natrij {

    private static class Time {

        private int hours;

        private int minutes;

        private final int seconds;

        private Time(String time) {
            final var tokens = time.split(":");
            this.hours = Integer.parseInt(tokens[0], 10);
            this.minutes = Integer.parseInt(tokens[1], 10);
            this.seconds = Integer.parseInt(tokens[2], 10);
        }

    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            final var current = new Time(sc.next());
            final var target = new Time(sc.next());

            var seconds = target.seconds - current.seconds;
            if (seconds < 0) {
                seconds += 60;
                target.minutes--;
            }
            
            var minutes = target.minutes - current.minutes;
            if(minutes < 0) {
                minutes += 60;
                target.hours--;
            }
            
            var hours = target.hours - current.hours;
            if(hours < 0) {
                hours += 24;
            }

            if(hours == 0 && minutes == 0 && seconds == 0) {
                hours += 24;
            }

            System.out.printf("%02d:%02d:%02d", hours, minutes, seconds);
        }
    }

}