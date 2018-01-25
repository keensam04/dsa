package saman.algorithms.shuffle.impl;

import org.junit.Test;

public class KnuthShuffleTest {

    private final KnuthShuffle<Integer> shuffle = new KnuthShuffle<>();

    @Test
    public void testShuffle() {
        Integer[] array = {0,1,2,3,4,5,6,7,8,9};

        shuffle.apply(array);
        System.out.println(arrayAsString(array));

        shuffle.apply(array);
        System.out.println(arrayAsString(array));

        shuffle.apply(array);
        System.out.println(arrayAsString(array));
    }

    private <T> String arrayAsString(T[] array) {
        StringBuilder builder = new StringBuilder("{");
        String delimiter = "";
        for (int i=0; i<array.length; i++) {
            builder.append(delimiter);
            builder.append(array[i]);
            delimiter = ", ";
        }
        return builder.append("}").toString();
    }
}
