package saman.algorithms.search.impl;

import saman.algorithms.search.Search;

import java.util.Optional;

public class LinearSearch<E> extends Search<E> {

    @Override
    public Optional<Item<E>> find(E element, E[] collection) {
        for (int index = 0; index < collection.length; index++) {
            if (collection[index].equals(element))
                return Optional.ofNullable(getItem(index, collection[index]));
        }
        return Optional.empty();
    }
}
