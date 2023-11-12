import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] array;
    private int size;
    private static final int INITIAL_CAPACITY = 8;

    public RandomizedQueue() {
        array = (Item[]) new Object[INITIAL_CAPACITY];
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void enqueue(Item item) {
        if (item == null) throw new IllegalArgumentException("Item cannot be null");
        if (size == array.length) resize(2 * array.length);
        array[size++] = item;
    }

    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("RandomizedQueue is empty");
        int randomIndex = getRandomIndex();
        Item item = array[randomIndex];
        array[randomIndex] = array[--size];
        array[size] = null;
        if (size > 0 && size == array.length / 4) resize(array.length / 2);
        return item;
    }

    public Item sample() {
        if (isEmpty()) throw new NoSuchElementException("RandomizedQueue is empty");
        return array[getRandomIndex()];
    }

    private int getRandomIndex() {
        Random rand = new Random();
        return rand.nextInt(size);
    }

    private void resize(int capacity) {
        Item[] newArray = (Item[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }

    private class RandomizedQueueIterator implements Iterator<Item> {
        private int currentIndex = 0;
        private final int[] shuffledIndices;

        public RandomizedQueueIterator() {
            shuffledIndices = new int[size];
            for (int i = 0; i < size; i++) {
                shuffledIndices[i] = i;
            }
            Random rand = new Random();
            for (int i = size - 1; i > 0; i--) {
                int j = rand.nextInt(i + 1);
                int temp = shuffledIndices[i];
                shuffledIndices[i] = shuffledIndices[j];
                shuffledIndices[j] = temp;
            }
        }

        public boolean hasNext() {
            return currentIndex < size;
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException("No more items to return");
            return array[shuffledIndices[currentIndex++]];
        }

        public void remove() {
            throw new UnsupportedOperationException("remove() is not supported");
        }
    }

    public static void main(String[] args) {
        // Your unit testing code here
    }
}
