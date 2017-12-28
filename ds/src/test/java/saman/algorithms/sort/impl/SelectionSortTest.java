package saman.algorithms.sort.impl;

import org.junit.Assert;
import org.junit.Test;
import saman.algorithms.sort.Sort;

public class SelectionSortTest {

    private final Sort selectionSort = new SelectionSort<>();

    @Test
    public void testAscendingSortForInteger() {
        final Integer[] testArray = {31,41,59,26,41,58};
        selectionSort.apply(testArray);
        Assert.assertArrayEquals(new Integer[] {26,31,41,41,58,59}, testArray);
    }

    @Test
    public void testDescendingSortForInteger() {
        final Integer[] testArray = {5,2,4,6,1,3};
        selectionSort.apply(testArray, Sort.Order.DESC);
        Assert.assertArrayEquals(new Integer[] {6,5,4,3,2,1}, testArray);
    }

    @Test
    public void testAscendingSortForString() {
        final String[] testArray = {"e","b","d","f","a","c"};
        selectionSort.apply(testArray);
        Assert.assertArrayEquals(new String[] {"a","b","c","d","e","f"}, testArray);
    }

    @Test
    public void testDescendingSortForString() {
        final String[] testArray = {"e","b","d","f","a","c"};
        selectionSort.apply(testArray, Sort.Order.DESC);
        Assert.assertArrayEquals(new String[] {"f","e","d","c","b","a"}, testArray);
    }
}
