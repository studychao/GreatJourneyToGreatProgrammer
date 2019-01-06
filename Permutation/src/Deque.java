
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private Node first, last;
    private int size;

    private class Node {
        Item item;
        Node next;
    }

    public Deque() {
        // construct an empty deque
        size = 0;

    }

    public boolean isEmpty() {               // is the deque empty?
        return (size == 0);
    }

    public int size() {
                 // return the number of items on the deque
        return size;

}
    public void addFirst(Item item) {       // add the item to the front
        if (item == null) {
            throw new IllegalArgumentException("You cannot add a null value");
        }
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        size++;
        if (size == 1) {
            last = first;
        }
    }
    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("You cannot add a null value");
        }
        // add the item to the end
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        size++;
        if (size == 1) {
            first = last;
        }
        else
        {
            oldlast.next = last;
        }
    }
    public Item removeFirst() {               // remove and return the item from the front
        if (size == 0) {
            throw new NoSuchElementException("You cannot remove from an empty list");
        }
        Item val = first.item;
        if (size == 1)
        {
            first = null;
            last = null;
        }
        else {
            Node newfirst = first.next;
            first = newfirst;
        }
        size--;
        return val;
    }
    public Item removeLast() {               // remove and return the item from the end
        if (size == 0) {
            throw new NoSuchElementException("You cannot remove from an empty list");
        }
        Node newlast = first;
        Item val = last.item;
        if (size == 1) {
            first = null;
            last = null;
        }
        else {
            while (newlast.next != last) {
                newlast = newlast.next;
            }
            newlast.next = null;
            last = newlast;
        }
        size--;
        return val;
    }

    @Override

    public Iterator<Item> iterator()   {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item> {
        Node a = first;

        @Override
        public boolean hasNext() {
            return (a != null);
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("We don't have remove function in this program, sorry.");

        }

        @Override

        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException("You cannot access the next from an empty list!");
            }
            else {
                Item val = a.item;
                a = a.next;
                return val;
            }

        }

    }

}
