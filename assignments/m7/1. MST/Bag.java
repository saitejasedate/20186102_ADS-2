import java.util.Iterator;
import java.util.NoSuchElementException;

/**.
 * bag class
 *
 * @param      <Item>  The item
 */
public class Bag<Item> implements Iterable<Item> {
    /**.
     * variable N
     */
    private int n;         // number of elements in bag
    /**.
     * First Node
     */
    private Node first;    // beginning of bag
    /**.
     * Node class
     */
    private class Node {
        /**.
         * item
         */
        private Item item;
        /**.
         * next node
         */
        private Node next;
    }

    /**.
      * Create an empty stack.
      */
    public Bag() {
        first = null;
        n = 0;
    }

    /**.
     * method to check empty
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**.
     * size method
     *
     * @return     { int }
     */
    public int size() {
        return n;
    }

    /**.
     * { function_description }
     *
     * @param      item  Item
     */
    public void add(final Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        n++;
    }


    /**.
     * Iterator
     *
     * @return     { Iterator }
     */
    public Iterator<Item> iterator()  {
        return new ListIterator();
    }

    /**.
     * class LIste Iteraator
     */
    private class ListIterator implements Iterator<Item> {
        /**.
         * node
         */
        private Node current = first;
        /**.
         * method to check next
         *
         * @return     True if has next, False otherwise.
         */
        public boolean hasNext() {
            return current != null;
        }
        /**.
         * { function_description }
         */
        public void remove() {
            throw new UnsupportedOperationException();
        }
        /**.
         * method for next
         *
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
