package saman.algorithms.sort;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import saman.algorithms.sort.impl.InsertionSort;
import saman.util.CoordinateGeometry.Point2D;

import java.util.Comparator;

import static org.junit.Assert.assertEquals;

public class SortTest {

    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    private final Sort sort = new InsertionSort();

    @Test
    public void testSortWithoutComparatorWhenElementsDoNotImplementComparable() {
        Object[] elements = new Object[]{new Point2D(0, 0), new Point2D(0, 1)};

        expectedException.expect(IllegalArgumentException.class);
        sort.apply(elements);
    }

    @Test
    public void testSortWithComparator() {
        Object[] elements = new Object[]{new Point2D(0, 2), new Point2D(0, 0), new Point2D(0, 1)};
        Comparator<Point2D> comparator = (point1, point2) -> point1.getY() < point2.getY() ? -1 :
                point1.getY() == point2.getY() ? 0 : 1;
        sort.apply(elements, Sort.Order.ASC, comparator);
        assertEquals(new Point2D(0,0), elements[0]);
        assertEquals(new Point2D(0,1), elements[1]);
        assertEquals(new Point2D(0,2), elements[2]);
    }
}
