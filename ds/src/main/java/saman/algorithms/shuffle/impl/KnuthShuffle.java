package saman.algorithms.shuffle.impl;

import saman.algorithms.shuffle.Shuffle;
import saman.util.BinaryOperations;

import java.util.Random;

public class KnuthShuffle<T> implements Shuffle<T> {

    private static final Random random = new Random();

    @Override
    public void apply(T[] elements) {
        for (int i=0; i<elements.length; i++) {
            int r = random.nextInt(i+1);
            BinaryOperations.swap(elements, i, r);
        }
    }
}
