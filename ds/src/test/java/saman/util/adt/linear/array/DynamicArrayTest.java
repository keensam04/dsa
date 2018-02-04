package saman.util.adt.linear.array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class DynamicArrayTest {

    @Test
    public void testDynamicArray() {
        final DynamicArray<Integer> dynamicArray = new DynamicArray<>();
        assertEquals(8, dynamicArray.capacity());
        assertEquals(0, dynamicArray.size());

        dynamicArray.add(0);
        assertEquals(8, dynamicArray.capacity());
        assertEquals(1, dynamicArray.size());

        dynamicArray.add(1);
        assertEquals(8, dynamicArray.capacity());
        assertEquals(2, dynamicArray.size());

        dynamicArray.add(2);
        assertEquals(8, dynamicArray.capacity());
        assertEquals(3, dynamicArray.size());

        dynamicArray.add(3);
        assertEquals(8, dynamicArray.capacity());
        assertEquals(4, dynamicArray.size());

        dynamicArray.add(4);
        assertEquals(8, dynamicArray.capacity());
        assertEquals(5, dynamicArray.size());

        dynamicArray.add(5);
        assertEquals(8, dynamicArray.capacity());
        assertEquals(6, dynamicArray.size());

        dynamicArray.add(6);
        assertEquals(8, dynamicArray.capacity());
        assertEquals(7, dynamicArray.size());

        dynamicArray.add(7);
        assertEquals(16, dynamicArray.capacity());
        assertEquals(8, dynamicArray.size());

        dynamicArray.add(8);
        assertEquals(16, dynamicArray.capacity());
        assertEquals(9, dynamicArray.size());

        dynamicArray.removeLast();
        assertEquals(16, dynamicArray.capacity());
        assertEquals(8, dynamicArray.size());

        dynamicArray.removeLast();
        assertEquals(16, dynamicArray.capacity());
        assertEquals(7, dynamicArray.size());

        dynamicArray.removeLast();
        assertEquals(16, dynamicArray.capacity());
        assertEquals(6, dynamicArray.size());
        dynamicArray.removeLast();
        assertEquals(16, dynamicArray.capacity());
        assertEquals(5, dynamicArray.size());
        dynamicArray.removeLast();
        assertEquals(8, dynamicArray.capacity());
        assertEquals(4, dynamicArray.size());

        dynamicArray.removeLast();
        assertEquals(8, dynamicArray.capacity());
        assertEquals(3, dynamicArray.size());
        dynamicArray.removeLast();

        assertEquals(4, dynamicArray.capacity());
        assertEquals(2, dynamicArray.size());

        dynamicArray.removeLast();
        assertEquals(2, dynamicArray.capacity());
        assertEquals(1, dynamicArray.size());

        dynamicArray.removeLast();
        assertEquals(1, dynamicArray.capacity());
        assertEquals(0, dynamicArray.size());

        try {
            dynamicArray.removeLast();
            fail("Should have thrown exception");
        } catch (UnsupportedOperationException e) {
            assertEquals("Cannot remove element from an empty array", e.getMessage());
            assertEquals(1, dynamicArray.capacity());
            assertEquals(0, dynamicArray.size());
        }

        dynamicArray.add(0);
        assertEquals(2, dynamicArray.capacity());
        assertEquals(1, dynamicArray.size());

        dynamicArray.add(1);
        assertEquals(4, dynamicArray.capacity());
        assertEquals(2, dynamicArray.size());

        dynamicArray.add(2);
        assertEquals(4, dynamicArray.capacity());
        assertEquals(3, dynamicArray.size());

        dynamicArray.add(3);
        assertEquals(8, dynamicArray.capacity());
        assertEquals(4, dynamicArray.size());

        dynamicArray.add(4);
        assertEquals(8, dynamicArray.capacity());
        assertEquals(5, dynamicArray.size());

        dynamicArray.add(5);
        assertEquals(8, dynamicArray.capacity());
        assertEquals(6, dynamicArray.size());

        dynamicArray.add(6);
        assertEquals(8, dynamicArray.capacity());
        assertEquals(7, dynamicArray.size());

        dynamicArray.add(7);
        assertEquals(16, dynamicArray.capacity());
        assertEquals(8, dynamicArray.size());

        dynamicArray.add(8);
        assertEquals(16, dynamicArray.capacity());
        assertEquals(9, dynamicArray.size());
    }
}
