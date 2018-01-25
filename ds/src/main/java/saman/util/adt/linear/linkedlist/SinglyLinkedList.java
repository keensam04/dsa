package saman.util.adt.linear.linkedlist;

import java.util.function.Consumer;

/**
 * Created by I311125 on 7/28/2017.
 */
public class SinglyLinkedList<T> implements LinkedList<T> {

    private Node<T> head;
    private int size = 0;
    private volatile int hashCode;

    public SinglyLinkedList() {}

    public SinglyLinkedList(T head) {
        this.head = new Node<T>(head);
        size = 1;
    }

    public int size() {
        return size;
    }

    @Override
    public Node<T> head() {
        return head;
    }

    @Override
    public Node<T> tail() {
        throw new UnsupportedOperationException("Tail is not tracked in this implementation");
    }

    @Override
    public T get(int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("index " + index + " not available");

        int i = 0;
        Node<T> temp = head;
        while (i < index) {
            temp = temp.next();
            i++;
        }
        return temp.data();
    }

    public void insertAt(T element, int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("index " + index + " not available");

        Node temp = head;
        if (index == 0) {
            head = new Node(element).withNext(temp);
        } else {
            int i = 0;
            Node prev = temp;
            while (i < index) {
                prev = temp;
                temp = temp.next();
                i += 1;
            }
            prev.setNext(new Node(element).withNext(temp));
        }
        size += 1;
    }

    public T deleteAt(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("index " + index + " not available");

        Node<T> temp = head;
        if (index == 0) {
            head = head.next();
        } else {
            int i = 0;
            Node prev = head;
            while (i < index) {
                prev = temp;
                temp = temp.next();
                i += 1;
            }
            prev.setNext(temp.next());
        }
        size -=1;
        return temp.data();
    }

    @Override
    public int hashCode() {
        if (this.hashCode == 0) {
            int hashCode = 17;
            hashCode = 31 * hashCode + head.hashCode();
            this.hashCode = hashCode;
        }
        return hashCode;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof SinglyLinkedList))
            return false;
        return head.equals(((SinglyLinkedList) obj).head);
    }

    @Override
    public String toString() {
        return head == null ? "" : head.toString();
    }
}
