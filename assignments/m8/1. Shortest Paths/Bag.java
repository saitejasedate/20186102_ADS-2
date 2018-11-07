import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * Class for bag.
 *
 * @param      <Item>  The item
 */
public class Bag<Item> implements Iterable<Item> {
    /**
     * number of elements in bag.
     */
    private int n;
    /**
     * beginning of bag.
     */
    private Node first;

    /**
     * Class for node.
     */
    private class Node {
        /**
         * attribute of item type.
         */
        private Item item;
        /**.
         * attribute of node type.
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
      * Is the BAG empty?
      *By the analysis the the time constant of the following method
      *is O(1).
      *The statment of the method executes only once when the method calls.
      * @return     True if empty, False otherwise.
      */
    public boolean isEmpty() {
        return first == null;
    }

    /**
      * Return the number of items in the bag.
      *By the analysis the the time constant of the following method
      *is O(1).
      *The statment of the method executes only once when the method calls.
      *
      * @return    integer value
      */
    public int size() {
        return n;
    }

    /**
      *Add the item to the bag.
      *By the analysis the the time constant of the following method
      *is O(1).
      *The statment of the method executes only once when the method calls.
      * @param      item  The item.
      */
    public void add(final Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        n++;
    }

    /**
     **By the analysis the the time constant of the following method
      *is O(N).As the iterator class iterator upto the values in the
      *bag.
     * @return     items.
     */
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    /**
     * Class for list iterator.
     */
    private class ListIterator implements Iterator<Item> {
        /**
         * current Node.
         */
        private Node current = first;

        /**
         * Determines if it has next.
         *
         * @return     True if has next, False otherwise.
         */
        public boolean hasNext() {
            return current != null;
        }
        /**
         *
         */
        public void remove() {
            throw new UnsupportedOperationException();
        }

        /**
         * @return     next item.
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









