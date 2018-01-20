package saman.util.adt.linear.queue;

import org.junit.Test;

import static org.junit.Assert.*;

public class QueueUsing2StacksTest {

    @Test
    public void testQueue() throws QueueOverflowException {
        Queue<Integer> queue = new QueueUsing2Stacks(5);

        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());
        assertFalse(queue.isFull());

        queue.enqueue(0);
        assertFalse(queue.isEmpty());
        assertEquals(1, queue.size());
        assertFalse(queue.isFull());

        queue.enqueue(1);
        assertFalse(queue.isEmpty());
        assertEquals(2, queue.size());
        assertFalse(queue.isFull());

        queue.enqueue(2);
        assertFalse(queue.isEmpty());
        assertEquals(3, queue.size());
        assertFalse(queue.isFull());

        queue.enqueue(3);
        assertFalse(queue.isEmpty());
        assertEquals(4, queue.size());
        assertFalse(queue.isFull());

        queue.enqueue(4);
        assertFalse(queue.isEmpty());
        assertEquals(5, queue.size());
        assertTrue(queue.isFull());

        try {
            queue.enqueue(5);
            fail("Enqueue should not be allowed in already filled queue");
        } catch (QueueOverflowException e) {
            assertNotNull(e);
        }

        assertEquals(Integer.valueOf(0), queue.dequeue());
        assertFalse(queue.isEmpty());
        assertEquals(4, queue.size());
        assertFalse(queue.isFull());

        queue.enqueue(5);
        assertFalse(queue.isEmpty());
        assertEquals(5, queue.size());
        assertTrue(queue.isFull());

        assertEquals(Integer.valueOf(1), queue.dequeue());
        assertFalse(queue.isEmpty());
        assertEquals(4, queue.size());
        assertFalse(queue.isFull());

        assertEquals(Integer.valueOf(2), queue.dequeue());
        assertFalse(queue.isEmpty());
        assertEquals(3, queue.size());
        assertFalse(queue.isFull());

        assertEquals(Integer.valueOf(3), queue.dequeue());
        assertFalse(queue.isEmpty());
        assertEquals(2, queue.size());
        assertFalse(queue.isFull());

        assertEquals(Integer.valueOf(4), queue.dequeue());
        assertFalse(queue.isEmpty());
        assertEquals(1, queue.size());
        assertFalse(queue.isFull());

        assertEquals(Integer.valueOf(5), queue.dequeue());
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());
        assertFalse(queue.isFull());

        try {
            queue.dequeue();
            fail("Dequeue should not be allowed on empty queue");
        } catch (QueueOverflowException e) {
            assertNotNull(e);
        }
    }
}
