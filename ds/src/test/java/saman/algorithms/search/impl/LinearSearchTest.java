package saman.algorithms.search.impl;

import org.junit.Assert;
import org.junit.Test;
import saman.algorithms.search.Search;

public class LinearSearchTest {

    private final Search<Integer> search = new LinearSearch<>();
    private final Integer[] testCollection = {31,41,59,26,41,58};

    @Test
    public void testFindWhenDistinctItemExists() {
        final int elementToFind = 59;
        final Search.Item item = search.find(elementToFind, testCollection).get();
        Assert.assertEquals(2, item.index);
        Assert.assertEquals(elementToFind, item.element);
    }

    @Test
    public void testFindWhenDuplicateItemExists() {
        final int elementToFind = 41;
        final Search.Item item = search.find(elementToFind, testCollection).get();
        Assert.assertEquals(1, item.index);
        Assert.assertEquals(elementToFind, item.element);
    }

    @Test
    public void testFindWhenItemDoesNotExist() {
        Assert.assertFalse(search.find(1, testCollection).isPresent());
    }

}
