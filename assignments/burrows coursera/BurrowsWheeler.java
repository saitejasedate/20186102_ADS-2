import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;
/**
 * Class for burrows wheeler.
 */
public class BurrowsWheeler {
    /**
     * { var_description }
     */
    private static final int R = 8;
    /**
     * { function_description }
     */
    public static void transform() {
        String input = BinaryStdIn.readString();
        CircularSuffixArray suffixArray = new CircularSuffixArray(input);
        int n = suffixArray.length();

        for (int i = 0; i < n; i++) {
            if (suffixArray.index(i) == 0) {
                BinaryStdOut.write(i);
                break;
            }
        }

        for (int i = 0; i < n; i++) {
            int position = (suffixArray.index(i) + n - 1) % n;
            if (position < 0) {
                position += n;
            }
            BinaryStdOut.write(input.charAt(position), R);
        }

        BinaryStdOut.close();
    }
    /**
     * { function_description }
     */
    public static void inverseTransform() {
        int first = BinaryStdIn.readInt();
        String s = BinaryStdIn.readString();
        char[] t = s.toCharArray();


        Map<Character, Deque<Integer>> positions = new HashMap<Character, Deque<Integer>>();
        for (int i = 0; i < t.length; i++) {
            Deque<Integer> li = positions.get(t[i]);
            if (li == null) {
                li = new LinkedList<Integer>();
                positions.put(t[i], li);
            }
            li.add(i);
        }


        Arrays.sort(t);


        int[] next = new int[t.length];
        for (int i = 0; i < t.length; i++) {
            Deque<Integer> li = positions.get(t[i]);
            next[i] = li.removeFirst();
        }


        int cur = first;
        for (int i = 0; i < t.length; i++) {
            char c = t[cur];
            BinaryStdOut.write(c);
            cur = next[cur];
        }

        BinaryStdOut.close();
    }
    /**
     * { function_description }
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        if (args[0].equals("-")) {
            transform();
        } else if (args[0].equals("+")) {
            inverseTransform();
        }
    }
}
