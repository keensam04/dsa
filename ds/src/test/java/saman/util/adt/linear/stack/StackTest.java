package saman.util.adt.linear.stack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Created by I311125 on 7/31/2017.
 */
public class StackTest {

    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testAllFuction() throws StackOverflowException {
        Stack<Integer> stack = new StackImpl<>(3);
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
        assertFalse(stack.isFull());

        expectedException.expect(StackOverflowException.class);
        stack.pop();

        expectedException.expect(StackOverflowException.class);
        stack.top();

        stack.push(1);
        assertEquals(Integer.valueOf(1), stack.top());
        assertFalse(stack.isEmpty());
        assertEquals(1, stack.size());
        assertFalse(stack.isFull());

        stack.push(2);
        assertEquals(Integer.valueOf(2), stack.top());
        assertFalse(stack.isEmpty());
        assertEquals(2, stack.size());
        assertFalse(stack.isFull());

        assertEquals(Integer.valueOf(2), stack.pop());
        assertEquals(Integer.valueOf(1), stack.top());
        assertFalse(stack.isEmpty());
        assertEquals(1, stack.size());
        assertFalse(stack.isFull());

        stack.push(2);
        assertEquals(Integer.valueOf(2), stack.top());
        assertFalse(stack.isEmpty());
        assertEquals(2, stack.size());
        assertFalse(stack.isFull());

        stack.push(3);
        assertEquals(Integer.valueOf(3), stack.top());
        assertFalse(stack.isEmpty());
        assertEquals(3, stack.size());
        assertTrue(stack.isFull());

        expectedException.expect(StackOverflowException.class);
        expectedException.expectMessage("Stack is full");
        stack.push(4);
    }
}
