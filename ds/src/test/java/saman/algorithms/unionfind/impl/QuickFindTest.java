package saman.algorithms.unionfind.impl;

import org.junit.Test;
import saman.algorithms.unionfind.UnionFind;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class QuickFindTest {

    private final Integer[] array = {0,1,2,3,4,5,6,7,8,9};
    private final UnionFind<Integer> unionFind = new QuickFind<>(array);

    @Test
    public void testQuickFind() {
        for(int i=0; i<array.length; i++) {
            for(int j=(i+1); j<array.length; j++) {
                assertFalse(unionFind.isConnected(i,j));
            }
        }

        unionFind.union(4,3);
        assertTrue(unionFind.isConnected(4,3));
        assertTrue(unionFind.isConnected(3,4));

        unionFind.union(3,8);
        assertTrue(unionFind.isConnected(3,4));
        assertTrue(unionFind.isConnected(3,8));
        assertTrue(unionFind.isConnected(4,8));

        unionFind.union(6,5);
        assertTrue(unionFind.isConnected(5,6));
        assertFalse(unionFind.isConnected(3,5));

        unionFind.union(9,4);
        assertTrue(unionFind.isConnected(3,4));
        assertTrue(unionFind.isConnected(3,8));
        assertTrue(unionFind.isConnected(3,9));
        assertTrue(unionFind.isConnected(4,8));
        assertTrue(unionFind.isConnected(4,9));
        assertTrue(unionFind.isConnected(8,9));
        assertFalse(unionFind.isConnected(5,9));

        unionFind.union(2,1);
        assertTrue(unionFind.isConnected(1,2));
        assertFalse(unionFind.isConnected(1,3));
        assertFalse(unionFind.isConnected(1,5));

        unionFind.union(5,0);
        assertTrue(unionFind.isConnected(0,5));
        assertTrue(unionFind.isConnected(0,6));
        assertFalse(unionFind.isConnected(5,9));

        unionFind.union(7,2);
        assertTrue(unionFind.isConnected(1,2));
        assertTrue(unionFind.isConnected(1,7));
        assertTrue(unionFind.isConnected(2,7));
        assertFalse(unionFind.isConnected(1,6));
        assertFalse(unionFind.isConnected(1,9));
        assertFalse(unionFind.isConnected(5,9));

        unionFind.union(6,1);
        assertTrue(unionFind.isConnected(1,6));
        assertFalse(unionFind.isConnected(1,9));

        unionFind.union(7,3);
        for(int i=0; i<array.length; i++) {
            for(int j=(i+1); j<array.length; j++) {
                assertTrue(unionFind.isConnected(i,j));
            }
        }
    }
}
