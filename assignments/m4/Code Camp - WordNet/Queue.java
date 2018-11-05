import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * List of .
 *
 * @param      <Item>  The item
 */
public class Queue<Item> implements Iterable<Item> {
    /**
     * integer variable.
     */
    private int n;         // number of elements on queue
    /**
     * node variable.
     */
    private Node first;    // beginning of queue
    /**
     * node variable.
     */
    private Node last;     // end of queue
    /**
     * Class for node.
     */
    private class Node {
        /**
         * item variable of item type.
         */
        private Item item;
        /**
         * next variable of node type.
         */
        private Node next;
    }

    /**
      * Create an empty queue.
      */
    public Queue() {
        first = null;
        last  = null;
    }

    /**
      * Is the queue empty?
      * Time Complexity : O(1).
      * @return boolean.
      */
    public boolean isEmpty() {
        return first == null;
    }

    /**
      * Return the number of items in the queue.
      * Time Complexity : O(1).
      * @return size.
      */
    public int size() {
        return n;
    }

    /**
      * Return the item least recently added to the queue.
      * Throw an exception if the queue is empty.
      * Time Complexity : O(1).
      * @return item type.
      */
    public Item peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue underflow");
        }
        return first.item;
    }

    /**
      * Add the item to the queue.
      * Time Complexity : O(1).
      * @param item item.
      */
    public void enqueue(final Item item) {
        Node x = new Node();
        x.item = item;
        if (isEmpty()) {
            first = x;
            last = x;
        } else {
            last.next = x;
            last = x;
        }
        n++;
    }

    /**
      * Remove and return the item on the queue least recently added.
      * Throw an exception if the queue is empty.
      * Time Complexity : O(1).
      * @return item.
      */
    public Item dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue underflow");
        }
        Item item = first.item;
        first = first.next;
        n--;
        if (isEmpty()) {
            last = null;  // to avoid loitering
        }
        return item;
    }

    /**
      * Return string representation.
      * Time Complexity : O(N).
      * @return string representation.
      */
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this) {
            s.append(item + " ");
        }
        return s.toString();
    }


    /**
      * Return an iterator that iterates over the
      *  items on the queue in FIFO order.
      *  Time Complexity : O(N).
      *  @return item array.
      */
    public Iterator<Item> iterator()  {
        return new ListIterator();
    }
    /**
     * Class for list iterator.
     */
    private class ListIterator implements Iterator<Item> {
        /**
         * node variable.
         */
        private Node current = first;
        /**
         * Determines if it has next.
         *Time Complexity : O(1).
         * @return     True if has next, False otherwise.
         */
        public boolean hasNext() {
            return current != null;
        }
        /**
         * remove method.
         * Time Complexity : O(1).
         */
        public void remove() {
            throw new UnsupportedOperationException();
        }
        /**
         * next method.
         *Time Complexity : O(N).
         * @return     { description_of_the_return_value }
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


