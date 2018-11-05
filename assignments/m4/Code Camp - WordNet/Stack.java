import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * List of .
 *
 * @param      <Item>  The item
 */
public class Stack<Item> implements Iterable<Item> {
    /**
     * integer variable.
     */
    private int n;
    /**
     * node type.
     */
    private Node first;     // top of stack
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
     * Create an empty stack.
     */
    public Stack() {
        first = null;
        n = 0;
    }

   /**
     * Is the stack empty?
     * @return true/false
     */
    public boolean isEmpty() {
        return first == null;
    }

   /**
     * Return the number of items in the stack.
     * @return size.
     */
    public int size() {
        return n;
    }

   /**
     * Add the item to the stack.
     * @param item item.
     */
    public void push(final Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        n++;
    }

   /**
     * Delete and return the item most recently added to the stack.
     * Throw an exception if no such item exists because the stack is empty.
     * @return item most recently added item to the stack.
     */
    public Item pop() {
        Item item = first.item;        // save item to return
        first = first.next;            // delete first node
        n--;
        return item;                   // return the saved item
    }


   /**
     * Return the item most recently added to the stack.
     * Throw an exception if no such item exists because the stack is empty.
     * @return item most recently added item to the stack.
     */
    public Item peek() {
        return first.item;
    }

   /**
     * Return string representation.
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
     * Return an iterator to the stack
     * that iterates through the items in LIFO order.
     * @return iterator of item type.
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
         *
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
         *
         * @return returns item.
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





