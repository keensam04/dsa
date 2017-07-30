package saman.util.adt.linear.linkedlist;

/**
 * Created by I311125 on 7/28/2017.
 */
class Node<T> {

    private final T data;
    private Node<T> next;
    private volatile int hashCode;

    Node(T data) {
        this.data = data;
    }

    T data() {
        return data;
    }

    Node<T> next() {
        return next;
    }

    void setNext(final Node<T> next) {
        this.next = next;
    }

    Node<T> withNext(final Node<T> next) {
        setNext(next);
        return this;
    }

    @Override
    public int hashCode() {
        if (this.hashCode == 0) {
            int hashCode = 17;
            hashCode = 31 * hashCode + data.hashCode();
            hashCode = 31 * hashCode + next.hashCode();
            this.hashCode = hashCode;
        }
        return this.hashCode;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof Node))
            return false;
        Node node = (Node)obj;
        return data.equals(node.data) && next.equals(node.next);
    }

    @Override
    public String toString() {
        return String.valueOf(data).concat(" -> ").concat(next != null ? next.toString() : "<end>");
    }
}
