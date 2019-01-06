import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdRandom;


public class RandomizedQueue<Item> implements Iterable<Item> {

    private Node first = new Node();
    private Node last = new Node();
    private int size;
    private class Node {
        Item item;
        Node next, pre;
    }

    public RandomizedQueue()                 // construct an empty randomized queue
    {
        size = 0;

    }
    public boolean isEmpty()                 // is the randomized queue empty?
    {
        return (size == 0);
    }
    public int size()                        // return the number of items on the randomized queue
    {
        return size;
    }
    public void enqueue(Item item)           // add the item
    {
        if (item == null) {
            throw new IllegalArgumentException("You cannot add a null value");
        }
        if (size == 0)
        {
            first.pre = null;
            last.next = null;
            first.item = item;
            last.item = item;
        }
        else if (size == 1)
        {
            last.item = item;
            last.pre = first;
            first.next = last;
        }
        else
        {
            Node oldlast = new Node();
            oldlast.item = last.item;
            oldlast.pre = last.pre;
            last.pre.next = oldlast;
            last.item = item;
            oldlast.next = last;
            last.pre = oldlast;
        }
        size++;
    }
    public Item dequeue()                   // remove and return a random item
    {
        if (size == 0) {
            throw new NoSuchElementException("You cannot remove from an empty list");
        }
        int a = StdRandom.uniform(size);
        Node sample = first;

        if (a == 0)
        {
            Item val = first.item;
            if (size == 1)
            {
                first = new Node();
                last = new Node();
                size--;
                return val;
            }
            else {
                first = first.next;
                size--;
                return val;
            }
        }
        else if (a == size-1)
        {
            Item val = last.item;
            if (size == 1)
            {
                first = new Node();
                last = new Node();
                size--;
                return val;
            }
            else {
                last = last.pre;
                size--;
                return val;
            }
        }
        else {
            for (int i = 0; i < a; i++) {
                sample = sample.next;
            }
            sample.next.pre = sample.pre;
            sample.pre.next = sample.next;
            size--;
            return sample.item;
        }

    }
    public Item sample()       // return a random item (but do not remove it)
    {
        if (size == 0) {
            throw new NoSuchElementException("You cannot remove from an empty list");
        }
        int a = StdRandom.uniform(size);
        Node sample = first;
        for (int i = 0; i < a; i++)
        {
            sample = sample.next;
        }
        return sample.item;
    }

    @Override
    public Iterator<Item> iterator()         // return an independent iterator over items in random order
    {
        return new RandomIterator();
    }
    private class RandomIterator implements Iterator<Item> {
        Node a = first;

        @Override
        public boolean hasNext() {
            if (size()==0)
            {
                return false;
            }
            else
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