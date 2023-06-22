import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Solution to the "Counting Triangles" problem on Kattis.
 * @author Brendan Jones
 */
public class CountingTriangles {

    private static class Point {

        private final double x;

        private final double y;

        private Point(Scanner sc) {
            this(sc.nextDouble(), sc.nextDouble());
        }

        private Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public Point sub(Point other) {
            return new Point(x - other.x, y - other.y);
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof Point) {
                final var p = (Point) o;
                return x == p.x && y == p.y;
            }
            return false;
        }

    }

    private static class LineSegment {

        private final Point start;

        private final Point end;

        private final boolean[] neighbors;

        private LineSegment(Scanner sc, int numSegments) {
            this.neighbors = new boolean[numSegments];

            final var start = new Point(sc);
            final var end = new Point(sc);

            if (end.x < start.x) {
                this.start = end;
                this.end = start;
            } else {
                this.start = start;
                this.end = end;
            }
        }

    }

    private static boolean intersects(LineSegment a, LineSegment b) {
        final var s1 = a.end.sub(a.start);
        final var s2 = b.end.sub(b.start);

        double det = (-s2.x * s1.y + s1.x * s2.y);

        double s = (-s1.y * (a.start.x - b.start.x) + s1.x * (a.start.y - b.start.y)) / det;
        if(s < 0.0 || s > 1.0) {
            return false;
        }

        double t = ( s2.x * (a.start.y - b.start.y) - s2.y * (a.start.x - b.start.x)) / det;
        return (t >= 0.0 && t <= 1.0);
    }

    private static boolean processTestCase(Scanner sc) {
        final var numSegments = sc.nextInt();
        if (numSegments == 0) {
            return false;
        }

        final var segments = new ArrayList<LineSegment>(numSegments);

        for (var i = 0; i < numSegments; ++i) {
            final var segment = new LineSegment(sc, numSegments);

            for (var j = 0; j < i; ++j) {
                final var other = segments.get(j);
                if (intersects(segment, other)) {
                    other.neighbors[i] = true;
                    segment.neighbors[j] = true;
                }
            }

            segments.add(segment);
        }

        var totalTriangles = 0;
        for (var i = 0; i < numSegments; ++i) {
            totalTriangles += countTriangles(segments, i);
        }
        System.out.println(totalTriangles);

        return true;
    }

    private static int countTriangles(List<LineSegment> segments, int current) {
        var numTriangles = 0;
        for (var i = current + 1; i < segments.size(); ++i) {
            LineSegment segment = segments.get(i);

            // Skip segments that do not intersect the current one.
            if (!segment.neighbors[current]) {
                continue;
            }

            for (int j = i + 1; j < segments.size(); ++j) {
                if (segment.neighbors[j] && segments.get(j).neighbors[current]) {
                    numTriangles++;
                }
            }
        }
        return numTriangles;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            while (processTestCase(sc)) ;
        }
    }
    
}
