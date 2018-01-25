package saman.util.adt.linear.linkedlist;

public class DoublyLinkedList<T> implements LinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size = 0;
    private volatile int hashCode;

    public DoublyLinkedList() {}

    public DoublyLinkedList(T node) {
        Node<T> head = new Node<>(node);
        this.head = head;
        this.tail = head;
        this.size = 1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Node<T> head() {
        return head;
    }

    @Override
    public Node<T> tail() {
        return tail;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("index " + index + " not available");

        Node<T> temp;
        if (index < size/2) {
            int i = 0;
            temp = head;
            while (i < index) {
                temp = temp.next();
                i++;
            }
        } else {
            int i = size - 1;
            temp = tail;
            while (i > index) {
                temp = temp.previous();
                i--;
            }
        }
        return temp.data();
    }

    @Override
    public void insertAt(T element, int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("index " + index + " not available");

        Node temp;
        if (index == 0) {
            temp = head;
            Node<T> newHead = new Node<>(element).withNext(temp);
            if (temp != null) temp.setPrevious(newHead);
            head = newHead;
        } else if (index == size) {
            temp = tail;
            Node<T> newTail = new Node<>(element).withPrevious(temp);
            if (temp != null) temp.setNext(newTail);
            tail = newTail;
        } else if (index <= size/2) {
            temp = head;
            int i = 0;
            Node prev = temp;
            while (i < index) {
                prev = temp;
                temp = temp.next();
                i += 1;
            }
            prev.setNext(new Node(element).withNext(temp).withPrevious(prev));
        } else {
            temp = tail;
            int i = size - 1;
            Node next = temp;
            while (i >= index) {
                next = temp;
                temp = temp.previous();
                i -= 1;
            }
            next.setPrevious(new Node(element).withPrevious(temp).withNext(next));
        }
        if (head != null && tail == null) {
            tail = head;
        } else if (head == null && tail != null) {
            head = tail;
        }
        size += 1;
    }

    @Override
    public T deleteAt(int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("index " + index + " not available");

        Node<T> temp = null;
        if (index == 0) {
            temp = head;
            head = head.next();
            if (head != null)
                head.setPrevious(null);
            else
                tail = null;
        } else if (index == size-1) {
            temp = tail;
            tail = tail.previous();
            if (tail != null)
                tail.setNext(null);
        } else if (index < size/2) {
            temp = head;
            Node prev = head;
            int i = 0;
            while (i < index) {
                prev = temp;
                temp = temp.next();
                i += 1;
            }
            prev.setNext(temp.next());
            temp.next().setPrevious(prev);
        } else {
            temp = tail;
            Node next = tail;
            int i = size - 1;
            while (i > index) {
                next = temp;
                temp = temp.previous();
                i -= 1;
            }
            next.setPrevious(temp.previous());
            temp.previous().setNext(next);
        }
        size -=1;
        return temp == null ? null : temp.data();
    }

    @Override
    public int hashCode() {
        if (this.hashCode == 0) {
            int hashCode = 17;
            hashCode = 31 * hashCode + head.hashCode();
            hashCode = 31 * hashCode + tail.hashCode();
            this.hashCode = hashCode;
        }
        return hashCode;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof DoublyLinkedList))
            return false;
        return head.equals(((DoublyLinkedList) obj).head) && tail.equals(((DoublyLinkedList) obj).tail);
    }

    @Override
    public String toString() {
        return head == null ? "" : head.toString();
    }

}
