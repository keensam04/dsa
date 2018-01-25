package saman.util;

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
     * @return -1 if <ABC > 180, 0 if <ABC = 180 and -1 if <ABC < 180
     */
    public static int polarAngle(Point2D a, Point2D b, Point2D c) {
        double area = (b.x - a.x)*(c.y - a.y) - (b.y - a.y)*(c.x - a.x);
        return (area < 0) ? -1 : (area > 0) ? 1 : 0;
    }
}
