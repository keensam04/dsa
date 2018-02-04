package saman.util.adt.linear.heap;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class BinaryHeapTest {

    @Test
    public void testBinaryHeap() {
        BinaryHeap<Integer> heap = new BinaryHeap<>();
        heap.insert(1);
        assertEquals(1, heap.size());

        heap.insert(2);
        assertEquals(2, heap.size());

        heap.insert(3);
        assertEquals(3, heap.size());

        heap.insert(4);
        assertEquals(4, heap.size());

        heap.insert(5);
        assertEquals(5, heap.size());

        heap.insert(6);
        assertEquals(6, heap.size());

        heap.insert(7);
        assertEquals(7, heap.size());

        assertEquals(Integer.valueOf(7), heap.removeRoot());
        assertEquals(6, heap.size());

        assertEquals(Integer.valueOf(6), heap.removeRoot());
        assertEquals(5, heap.size());

        assertEquals(Integer.valueOf(5), heap.removeRoot());
        assertEquals(4, heap.size());

        assertEquals(Integer.valueOf(4), heap.removeRoot());
        assertEquals(3, heap.size());

        assertEquals(Integer.valueOf(3), heap.removeRoot());
        assertEquals(2, heap.size());

        assertEquals(Integer.valueOf(2), heap.removeRoot());
        assertEquals(1, heap.size());

        assertEquals(Integer.valueOf(1), heap.removeRoot());
        assertEquals(0, heap.size());

        try {
            heap.removeRoot();
            fail("Should have thrown an exception");
        } catch (UnsupportedOperationException e) {
            assertEquals(0, heap.size());
        }
    }
}
