package saman.util.adt.linear.linkedlist;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by I311125 on 7/29/2017.
 */
public class SinglyLinkedListTest {

    @Test
    public void testInsertionAndDeletion() {
        LinkedList<Integer> linkedList = new SinglyLinkedList<>(0);
        assertEquals(1, linkedList.size());
        Arrays.asList(1,2,3,4,5).forEach(element -> linkedList.insertAt(element, element));
        assertEquals(6, linkedList.size());
        assertEquals("0 -> 1 -> 2 -> 3 -> 4 -> 5 -> <end>", linkedList.toString());
        while (!linkedList.isEmpty())
            linkedList.deleteAt(LinkedList.POSITION.HEAD);
        assertEquals(0, linkedList.size());
    }

    @Test
    public void testAllInserts() {
        LinkedList<Integer> linkedList = new SinglyLinkedList<>();
        assertEquals(0, linkedList.size());
        assertTrue(linkedList.isEmpty());

        linkedList.insertAt(1, LinkedList.POSITION.HEAD);
        assertEquals(1, linkedList.size());
        assertFalse(linkedList.isEmpty());
        assertEquals("1 -> <end>", linkedList.toString());

        linkedList.insertAt(3, LinkedList.POSITION.TAIL);
        assertEquals(2, linkedList.size());
        assertFalse(linkedList.isEmpty());
        assertEquals("1 -> 3 -> <end>", linkedList.toString());

        linkedList.insertAt(2, 1);
        assertEquals(3, linkedList.size());
        assertFalse(linkedList.isEmpty());
        assertEquals("1 -> 2 -> 3 -> <end>", linkedList.toString());

        linkedList.insertAt(0, 0);
        assertEquals(4, linkedList.size());
        assertFalse(linkedList.isEmpty());
        assertEquals("0 -> 1 -> 2 -> 3 -> <end>", linkedList.toString());

        linkedList.insertAt(4, 4);
        assertEquals(5, linkedList.size());
        assertFalse(linkedList.isEmpty());
        assertEquals("0 -> 1 -> 2 -> 3 -> 4 -> <end>", linkedList.toString());
    }

    @Test
    public void testAllDeletes() {
        LinkedList<Integer> linkedList = new SinglyLinkedList<>();
        Arrays.asList(5,4,3,2,1,0).forEach(element -> linkedList.insert(element));
        assertEquals(6, linkedList.size());
        assertFalse(linkedList.isEmpty());
        assertEquals("0 -> 1 -> 2 -> 3 -> 4 -> 5 -> <end>", linkedList.toString());

        linkedList.deleteAt(5);
        assertEquals(5, linkedList.size());
        assertFalse(linkedList.isEmpty());
        assertEquals("0 -> 1 -> 2 -> 3 -> 4 -> <end>", linkedList.toString());

        linkedList.deleteAt(LinkedList.POSITION.HEAD);
        assertEquals(4, linkedList.size());
        assertFalse(linkedList.isEmpty());
        assertEquals("1 -> 2 -> 3 -> 4 -> <end>", linkedList.toString());

        linkedList.deleteAt(LinkedList.POSITION.TAIL);
        assertEquals(3, linkedList.size());
        assertFalse(linkedList.isEmpty());
        assertEquals("1 -> 2 -> 3 -> <end>", linkedList.toString());

        linkedList.deleteAt(1);
        assertEquals(2, linkedList.size());
        assertFalse(linkedList.isEmpty());
        assertEquals("1 -> 3 -> <end>", linkedList.toString());

        linkedList.deleteAt(0);
        assertEquals(1, linkedList.size());
        assertFalse(linkedList.isEmpty());
        assertEquals("3 -> <end>", linkedList.toString());

        linkedList.deleteAt(0);
        assertEquals(0, linkedList.size());
        assertTrue(linkedList.isEmpty());
        assertEquals("", linkedList.toString());
    }

    @Test
    public void testAllGets() {
        LinkedList<Integer> linkedList = new SinglyLinkedList<>();
        Arrays.asList(3,2,1).forEach(element -> linkedList.insert(element));
        assertEquals(3, linkedList.size());
        assertFalse(linkedList.isEmpty());
        assertEquals("1 -> 2 -> 3 -> <end>", linkedList.toString());

        assertEquals("1 -> 2 -> 3 -> <end>", linkedList.head().toString());
        assertEquals(Integer.valueOf(1), linkedList.get(0));
        assertEquals(Integer.valueOf(2), linkedList.get(1));
        assertEquals(Integer.valueOf(3), linkedList.get(2));

    }

}
