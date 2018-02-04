package saman.util;

import static java.lang.Math.sqrt;
import static saman.util.Math.power;

public final class CoordinateGeometry {

    private CoordinateGeometry() {}

    public static class Point2D {

        private final double x;
        private final double y;

        public Point2D(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }

        @Override
        public int hashCode() {
            int hashCode = 17;
            hashCode = 31 * hashCode + (int)x;
            hashCode = 31 * hashCode + (int)y;
            return hashCode;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this)
                return true;
            if (!(obj instanceof Point2D))
                return false;
            Point2D point = (Point2D)obj;
            return x == point.x && y == point.y;
        }

        @Override
        public String toString() {
            return "(" + x + "," + y + ")";
        }
    }

    /**
     *
     * @param a the first coordinate point
     * @param b the second coordinate point
     * @param c the third coordinate point
     * @return negative value if <ABC > 180, 0 if <ABC = 180 and positive value if <ABC < 180
     */
    public static double polarAngle(Point2D a, Point2D b, Point2D c) {
        return (b.x - a.x)*(c.y - a.y) - (b.y - a.y)*(c.x - a.x);
    }

    public static double cosine(Point2D a, Point2D b, Point2D c) {
        double hypotenuse = distance(a, b);
        return hypotenuse == 0 ? 0.0 : distance(c, b)/hypotenuse;
    }

    public static double distance(Point2D a, Point2D b) {
        return sqrt(power((a.getX() - b.getX()), 2) + power((a.getY() - b.getY()), 2));
    }
}
