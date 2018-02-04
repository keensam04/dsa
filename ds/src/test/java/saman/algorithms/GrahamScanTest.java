package saman.algorithms;

import org.junit.Assert;
import org.junit.Test;
import saman.algorithms.sort.impl.InsertionSort;
import saman.util.CoordinateGeometry;
import saman.util.CoordinateGeometry.Point2D;
import saman.util.adt.linear.stack.Stack;
import saman.util.adt.linear.stack.StackOverflowException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class GrahamScanTest {

    private final GrahamScan grahamScan = new GrahamScan(new InsertionSort<>());

    @Test
    public void testConvexHull() throws StackOverflowException {
        Point2D[] points = {new Point2D(1,4),
                            new Point2D(3,2),
                            new Point2D(3,3),
                            new Point2D(3,6),
                            new Point2D(4,9),
                            new Point2D(5,5),
                            new Point2D(6,7),
                            new Point2D(6,5),
                            new Point2D(7,7),
                            new Point2D(7,2),
                            new Point2D(9,4),
                            new Point2D(10,1),
                            new Point2D(10,8)};
        Stack<Point2D> boundaryPoints = grahamScan.getConvexHull(points);
        assertEquals(5, boundaryPoints.size());
        assertEquals(new Point2D(3,2), boundaryPoints.pop());
        assertEquals(new Point2D(1,4), boundaryPoints.pop());
        assertEquals(new Point2D(4,9), boundaryPoints.pop());
        assertEquals(new Point2D(10,8), boundaryPoints.pop());
        assertEquals(new Point2D(10,1), boundaryPoints.pop());
        assertTrue(boundaryPoints.isEmpty());
    }
}
