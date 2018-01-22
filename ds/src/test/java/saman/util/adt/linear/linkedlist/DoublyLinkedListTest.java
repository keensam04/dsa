package saman.util.adt.linear.linkedlist;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by I311125 on 7/29/2017.
 */
public class DoublyLinkedListTest {

    @Test
    public void testInsertionAndDeletion() {
        LinkedList<Integer> linkedList = new DoublyLinkedList<>(0);
        assertEquals(1, linkedList.size());
        Arrays.asList(1,2,3,4,5).forEach(element -> linkedList.insertAt(element, element));
        assertEquals(6, linkedList.size());
        assertEquals("0 -> 1 -> 2 -> 3 -> 4 -> 5", linkedList.toString());
        while (!linkedList.isEmpty())
            linkedList.deleteAt(LinkedList.POSITION.HEAD);
        assertEquals(0, linkedList.size());
    }

    @Test
    public void testAllInserts() {
        LinkedList<Integer> linkedList = new DoublyLinkedList<>();
        assertEquals(0, linkedList.size());
        assertTrue(linkedList.isEmpty());

        linkedList.insertAt(1, LinkedList.POSITION.HEAD);
        assertEquals(1, linkedList.size());
        assertFalse(linkedList.isEmpty());
        assertEquals("1", linkedList.toString());

        linkedList.insertAt(3, LinkedList.POSITION.TAIL);
        assertEquals(2, linkedList.size());
        assertFalse(linkedList.isEmpty());
        assertEquals("1 -> 3", linkedList.toString());

        linkedList.insertAt(2, 1);
        assertEquals(3, linkedList.size());
        assertFalse(linkedList.isEmpty());
        assertEquals("1 -> 2 -> 3", linkedList.toString());

        linkedList.insertAt(0, 0);
        assertEquals(4, linkedList.size());
        assertFalse(linkedList.isEmpty());
        assertEquals("0 -> 1 -> 2 -> 3", linkedList.toString());

        linkedList.insertAt(4, 4);
        assertEquals(5, linkedList.size());
        assertFalse(linkedList.isEmpty());
        assertEquals("0 -> 1 -> 2 -> 3 -> 4", linkedList.toString());
    }

    @Test
    public void testAllDeletes() {
        LinkedList<Integer> linkedList = new DoublyLinkedList<>();
        Arrays.asList(5,4,3,2,1,0).forEach(element -> linkedList.insert(element));
        assertEquals(6, linkedList.size());
        assertFalse(linkedList.isEmpty());
        assertEquals("0 -> 1 -> 2 -> 3 -> 4 -> 5", linkedList.toString());

        assertEquals(Integer.valueOf(5), linkedList.deleteAt(5));
        assertEquals(5, linkedList.size());
        assertFalse(linkedList.isEmpty());
        assertEquals("0 -> 1 -> 2 -> 3 -> 4", linkedList.toString());

        assertEquals(Integer.valueOf(0), linkedList.deleteAt(LinkedList.POSITION.HEAD));
        assertEquals(4, linkedList.size());
        assertFalse(linkedList.isEmpty());
        assertEquals("1 -> 2 -> 3 -> 4", linkedList.toString());

        assertEquals(Integer.valueOf(4), linkedList.deleteAt(LinkedList.POSITION.TAIL));
        assertEquals(3, linkedList.size());
        assertFalse(linkedList.isEmpty());
        assertEquals("1 -> 2 -> 3", linkedList.toString());

        assertEquals(Integer.valueOf(2), linkedList.deleteAt(1));
        assertEquals(2, linkedList.size());
        assertFalse(linkedList.isEmpty());
        assertEquals("1 -> 3", linkedList.toString());

        assertEquals(Integer.valueOf(1), linkedList.deleteAt(0));
        assertEquals(1, linkedList.size());
        assertFalse(linkedList.isEmpty());
        assertEquals("3", linkedList.toString());

        assertEquals(Integer.valueOf(3), linkedList.deleteAt(0));
        assertEquals(0, linkedList.size());
        assertTrue(linkedList.isEmpty());
        assertEquals("", linkedList.toString());
    }

    @Test
    public void testAllGets() {
        LinkedList<Integer> linkedList = new DoublyLinkedList<>();
        Arrays.asList(3,2,1).forEach(element -> linkedList.insert(element));
        assertEquals(3, linkedList.size());
        assertFalse(linkedList.isEmpty());
        assertEquals("1 -> 2 -> 3", linkedList.toString());

        assertEquals("1 -> 2 -> 3", linkedList.head().toString());
        assertEquals(Integer.valueOf(1), linkedList.get(0));
        assertEquals(Integer.valueOf(2), linkedList.get(1));
        assertEquals(Integer.valueOf(3), linkedList.get(2));

    }

}
