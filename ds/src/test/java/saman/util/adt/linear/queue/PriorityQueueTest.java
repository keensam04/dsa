package saman.util.adt.linear.queue;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class PriorityQueueTest {

    @Test
    public void testPriorityQueue() {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.enqueue(1);
        assertEquals(1, queue.size());

        queue.enqueue(2);
        assertEquals(2, queue.size());

        queue.enqueue(3);
        assertEquals(3, queue.size());

        queue.enqueue(4);
        assertEquals(4, queue.size());

        queue.enqueue(5);
        assertEquals(5, queue.size());

        queue.enqueue(6);
        assertEquals(6, queue.size());

        queue.enqueue(7);
        assertEquals(7, queue.size());

        assertEquals(Integer.valueOf(7), queue.dequeue());
        assertEquals(6, queue.size());

        assertEquals(Integer.valueOf(6), queue.dequeue());
        assertEquals(5, queue.size());

        assertEquals(Integer.valueOf(5), queue.dequeue());
        assertEquals(4, queue.size());

        assertEquals(Integer.valueOf(4), queue.dequeue());
        assertEquals(3, queue.size());

        assertEquals(Integer.valueOf(3), queue.dequeue());
        assertEquals(2, queue.size());

        assertEquals(Integer.valueOf(2), queue.dequeue());
        assertEquals(1, queue.size());

        assertEquals(Integer.valueOf(1), queue.dequeue());
        assertEquals(0, queue.size());

        try {
            queue.dequeue();
            fail("Should have thrown an exception");
        } catch (UnsupportedOperationException e) {
            assertEquals(0, queue.size());
        }
    }

    @Test
    public void testPriorityQueueWithSamePriority() {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.enqueue(1);
        assertEquals(1, queue.size());

        queue.enqueue(2);
        assertEquals(2, queue.size());

        queue.enqueue(2);
        assertEquals(3, queue.size());

        queue.enqueue(1);
        assertEquals(4, queue.size());

        assertEquals(Integer.valueOf(2), queue.dequeue());
        assertEquals(3, queue.size());

        assertEquals(Integer.valueOf(2), queue.dequeue());
        assertEquals(2, queue.size());

        assertEquals(Integer.valueOf(1), queue.dequeue());
        assertEquals(1, queue.size());

        assertEquals(Integer.valueOf(1), queue.dequeue());
        assertEquals(0, queue.size());

    }
}
