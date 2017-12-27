package saman.algorithms.search;

import java.util.Optional;

public abstract class Search<E> {

    public abstract Optional<Item<E>> find(E element, E[] collection);

    protected Item<E> getItem(int index, E element) {
        return new Item<>(index, element);
    }

    public class Item<E> {

        public final int index;
        public final E element;

        private Item(int index, E element) {
            this.index = index;
            this.element = element;
        }
    }
}
