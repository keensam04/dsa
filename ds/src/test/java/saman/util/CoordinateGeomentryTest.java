package saman.util;

import org.junit.Test;
import saman.util.CoordinateGeometry.Point2D;

import static org.junit.Assert.assertEquals;

public class CoordinateGeomentryTest {

    @Test
    public void testPolarAngleOfSamePoint() {
        Point2D a = new Point2D(3,3);
        assertEquals(0.0, CoordinateGeometry.polarAngle(a, a, a), 0.0);
    }

    @Test
    public void testPolarAngleOfTwoPoints() {
        Point2D a = new Point2D(1,1);
        Point2D b = new Point2D(3,3);
        assertEquals(0.0, CoordinateGeometry.polarAngle(a, a, b), 0.0);
        assertEquals(0.0, CoordinateGeometry.polarAngle(a, b, a), 0.0);
        assertEquals(0.0, CoordinateGeometry.polarAngle(a, b, b), 0.0);
        assertEquals(0.0, CoordinateGeometry.polarAngle(b, a, a), 0.0);
        assertEquals(0.0, CoordinateGeometry.polarAngle(b, a, b), 0.0);
        assertEquals(0.0, CoordinateGeometry.polarAngle(b, b, a), 0.0);
    }

    @Test
    public void testPolarAngleOfThreeCollinearPoints() {
        Point2D a = new Point2D(1,1);
        Point2D b = new Point2D(3,3);
        Point2D c = new Point2D(5,5);
        assertEquals(0.0, CoordinateGeometry.polarAngle(a, b, c), 0.0);
        assertEquals(0.0, CoordinateGeometry.polarAngle(c, b, a), 0.0);

        assertEquals(0.0, CoordinateGeometry.polarAngle(b, c, a), 0.0);
        assertEquals(0.0, CoordinateGeometry.polarAngle(a, c, b), 0.0);

        assertEquals(0.0, CoordinateGeometry.polarAngle(c, a, b), 0.0);
        assertEquals(0.0, CoordinateGeometry.polarAngle(b, a, c), 0.0);
    }

    @Test
    public void testPolarAngleOfThreeAcutePoints() {
        Point2D a = new Point2D(0,0);
        Point2D b = new Point2D(4,10);
        Point2D c = new Point2D(8,0);
        assertEquals(-80.0, CoordinateGeometry.polarAngle(a, b, c), 0.0);
        assertEquals(80.0, CoordinateGeometry.polarAngle(c, b, a), 0.0);

        assertEquals(-80.0, CoordinateGeometry.polarAngle(b, c, a), 0.0);
        assertEquals(80.0, CoordinateGeometry.polarAngle(a, c, b), 0.0);

        assertEquals(-80.0, CoordinateGeometry.polarAngle(c, a, b), 0.0);
        assertEquals(80.0, CoordinateGeometry.polarAngle(b, a, c), 0.0);
    }

    @Test
    public void testPolarAngleOfThreeRightAngledPoints() {
        Point2D a = new Point2D(0,0);
        Point2D b = new Point2D(0,10);
        Point2D c = new Point2D(8,0);
        assertEquals(-80.0, CoordinateGeometry.polarAngle(a, b, c), 0.0);
        assertEquals(80.0, CoordinateGeometry.polarAngle(c, b, a), 0.0);

        assertEquals(-80.0, CoordinateGeometry.polarAngle(b, c, a), 0.0);
        assertEquals(80.0, CoordinateGeometry.polarAngle(a, c, b), 0.0);

        assertEquals(-80.0, CoordinateGeometry.polarAngle(c, a, b), 0.0);
        assertEquals(80.0, CoordinateGeometry.polarAngle(b, a, c), 0.0);
    }

    @Test
    public void testPolarAngleOfThreeObtusePoints() {
        Point2D a = new Point2D(2,0);
        Point2D b = new Point2D(0,10);
        Point2D c = new Point2D(8,0);
        assertEquals(-60.0, CoordinateGeometry.polarAngle(a, b, c), 0.0);
        assertEquals(60.0, CoordinateGeometry.polarAngle(c, b, a), 0.0);

        assertEquals(-60.0, CoordinateGeometry.polarAngle(b, c, a), 0.0);
        assertEquals(60.0, CoordinateGeometry.polarAngle(a, c, b), 0.0);

        assertEquals(-60.0, CoordinateGeometry.polarAngle(c, a, b), 0.0);
        assertEquals(60.0, CoordinateGeometry.polarAngle(b, a, c), 0.0);
    }
}
