package saman.algorithms;

import saman.algorithms.sort.Sort;
import saman.util.CoordinateGeometry.Point2D;
import saman.util.adt.linear.stack.Stack;
import saman.util.adt.linear.stack.StackImpl;
import saman.util.adt.linear.stack.StackOverflowException;

import java.util.Comparator;

import static saman.util.CoordinateGeometry.cosine;
import static saman.util.CoordinateGeometry.polarAngle;

/**
 * An algorithm to find convex hull
 * A convex hull of a set of N points is the smallest perimeter fence enclosing the points
 * Details here: https://www.coursera.org/learn/algorithms-part1/lecture/KHJ1t/convex-hull
 */
public final class GrahamScan {

    private final Sort<Point2D> sort;


    public GrahamScan(Sort<Point2D> sortingAlgorithm) {
        sort = sortingAlgorithm;
    }

    public Stack<Point2D> getConvexHull(Point2D[] points) {
        Stack<Point2D> hull = new StackImpl<>();
        sort.apply(points, getYCoordinateComparator());
        sort.apply(points, getCosineComparator(points[0]));

        try {
            hull.push(points[0]);
            hull.push(points[1]);
            for (int i=2; i<points.length; i++) {
                Point2D top = hull.pop();
                while (polarAngle(hull.top(), top, points[i]) <= 0) {
                    top = hull.pop();
                }
                hull.push(top);
                hull.push(points[i]);
            }
        } catch (StackOverflowException e) {
            e.printStackTrace();
        }
        return hull;
    }

    private Comparator<Point2D> getYCoordinateComparator() {
        return (point1, point2) -> point1.getY() < point2.getY() ? -1 : point1.getY() > point2.getY() ? 1 : point1.getX() > point2.getX() ? -1 : 1;
    }

    private Comparator<Point2D> getCosineComparator(Point2D referencePoint) {
        return Comparator.comparingDouble(point -> {
            Point2D pointA = new Point2D(point.getX(), referencePoint.getY());
            if (referencePoint.equals(point) || referencePoint.equals(pointA))
                return Double.NEGATIVE_INFINITY;
            else {
                double cos = cosine(pointA, referencePoint, point);
                cos = point.getX() < referencePoint.getX() ? -cos : cos;
                return cos;
            }
        });
    }

}
