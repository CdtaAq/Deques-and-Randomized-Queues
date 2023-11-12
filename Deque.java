import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int size;

    private class Node {
        Item item;
        Node next;
        Node prev;
    }

    public Deque() {
        first = null;
        last = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void addFirst(Item item) {
        if (item == null) throw new IllegalArgumentException("Item cannot be null");
        Node newNode = new Node();
        newNode.item = item;
        newNode.next = first;
        if (isEmpty()) {
            last = newNode;
        } else {
            first.prev = newNode;
        }
        first = newNode;
        size++;
    }

    public void addLast(Item item) {
        if (item == null) throw new IllegalArgumentException("Item cannot be null");
        Node newNode = new Node();
        newNode.item = item;
        newNode.prev = last;
        if (isEmpty()) {
            first = newNode;
        } else {
            last.next = newNode;
        }
        last = newNode;
        size++;
    }

    public Item removeFirst() {
        if (isEmpty()) throw new NoSuchElementException("Deque is empty");
        Item item = first.item;
        first = first.next;
        size--;
        if (isEmpty()) {
            last = null;
        } else {
            first.prev = null;
        }
        return item;
    }

    public Item removeLast() {
        if (isEmpty()) throw new NoSuchElementException("Deque is empty");
        Item item = last.item;
        last = last.prev;
        size--;
        if (isEmpty()) {
            first = null;
        } else {
            last.next = null;
        }
        return item;
    }

    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException("No more items to return");
            Item item = current.item;
            current = current.next;
            return item;
        }

        public void remove() {
            throw new UnsupportedOperationException("remove() is not supported");
        }
    }

    public static void main(String[] args) {
        // Your unit testing code here
    }
}
