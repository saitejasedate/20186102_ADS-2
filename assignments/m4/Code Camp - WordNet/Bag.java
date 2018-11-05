import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class for bag.
 *
 * @param      <Item>  The item
 */
public class Bag<Item> implements Iterable<Item> {
    /**
     * integer.
     */
    private int n;     // number of elements in bag
    /**
     * node.
     */
    private Node first;    // beginning of bag
    /**
     * Class for node.
     */
    private class Node {
        /**
         * item.
         */
        private Item item;
        /**
         * node.
         */
        private Node next;
    }

    /**
      * Create an empty stack.
      */
    public Bag() {
        first = null;
        n = 0;
    }
    /**
     * Determines if empty.
     *Time complexity : O(1).
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
      * Return the number of items in the bag.
      * Time complexity : O(1).
      * @return size.
      */
    public int size() {
        return n;
    }

    /**
     * add method.
     *Time complexity : O(1).
     * @param      item  The item
     */
    public void add(final Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        n++;
    }


    /**
      * Return an iterator that iterates over the items in the bag.
      * Time complexity : O(V).
      * @return list iterator.
      */
    public Iterator<Item> iterator()  {
        return new ListIterator();
    }

    /**
     * Class for list iterator.
     */
    private class ListIterator implements Iterator<Item> {
        /**
         * node.
         */
        private Node current = first;
        /**
         * Determines if it has next.
         *Time complexity : O(1).
         * @return     True if has next, False otherwise.
         */
        public boolean hasNext() {
            return current != null;
        }
        /**
         * remove method.
         */
        public void remove() {
            throw new UnsupportedOperationException();
        }
        /**
         * next method.
         *Time complexity : O(V).
         * @return  item.
         */
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

}






