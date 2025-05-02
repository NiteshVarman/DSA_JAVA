import java.util.*;

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class ClosestPair {

    // Function to calculate distance between two points
    private static double distance(Point p1, Point p2) {
        return Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y));
    }

    // Brute force method to find minimum distance
    private static double bruteForce(ArrayList<Point> points, int n) {
        double min = Double.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double dist = distance(points.get(i), points.get(j));
                if (dist < min) {
                    min = dist;
                }
            }
        }
        return min;
    }

    // Function to find the minimum of two double values
    private static double min(double x, double y) {
        return (x < y) ? x : y;
    }

    // A utility function to find the distance between the closest points of
    // strip of a given size. All points in strip[] are sorted according to y
    // coordinate.
    private static double stripClosest(ArrayList<Point> strip, int size, double d) {
        double min = d;

        for (int i = 0; i < size; ++i) {
            for (int j = i + 1; j < size && (strip.get(j).y - strip.get(i).y) < min; ++j) {
                double dist = distance(strip.get(i), strip.get(j));
                if (dist < min) {
                    min = dist;
                }
            }
        }

        return min;
    }

    // A recursive function to find the smallest distance
    private static double closestUtil(ArrayList<Point> pointsSortedX, ArrayList<Point> pointsSortedY, int n) {
        if (n <= 3) {
            return bruteForce(pointsSortedX, n);
        }

        int mid = n / 2;
        Point midPoint = pointsSortedX.get(mid);

        ArrayList<Point> pointsSortedYLeft = new ArrayList<>();
        ArrayList<Point> pointsSortedYRight = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (pointsSortedY.get(i).x <= midPoint.x) {
                pointsSortedYLeft.add(pointsSortedY.get(i));
            } else {
                pointsSortedYRight.add(pointsSortedY.get(i));
            }
        }

        double dl = closestUtil(new ArrayList<>(pointsSortedX.subList(0, mid)), pointsSortedYLeft, mid);
        double dr = closestUtil(new ArrayList<>(pointsSortedX.subList(mid, n)), pointsSortedYRight, n - mid);

        double d = min(dl, dr);

        ArrayList<Point> strip = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (Math.abs(pointsSortedY.get(i).x - midPoint.x) < d) {
                strip.add(pointsSortedY.get(i));
            }
        }

        return min(d, stripClosest(strip, strip.size(), d));
    }

    // The main function that finds the smallest distance
    public static double closest(ArrayList<Point> points) {
        int n = points.size();
        ArrayList<Point> pointsSortedX = new ArrayList<>(points);
        ArrayList<Point> pointsSortedY = new ArrayList<>(points);

        pointsSortedX.sort((a, b) -> a.x - b.x);
        pointsSortedY.sort((a, b) -> a.y - b.y);

        return closestUtil(pointsSortedX, pointsSortedY, n);
    }

    public static void main(String[] args) {
        ArrayList<Point> points = new ArrayList<>();
        points.add(new Point(2, 3));
        points.add(new Point(12, 30));
        points.add(new Point(40, 50));
        points.add(new Point(5, 1));
        points.add(new Point(12, 10));
        points.add(new Point(3, 4));

        System.out.println("The smallest distance is " + closest(points));
    }
}