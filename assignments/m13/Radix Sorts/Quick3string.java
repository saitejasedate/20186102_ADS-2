/**
 * Quick String Class.
 */
public final class Quick3string {
    /**
     * Constructs the object.
     */
    protected Quick3string() {
        /**
         * protected counstructor.
         */
    }
    /**
     * integer value.
     */
    private static final int CUTOFF =  15;   // cutoff to insertion sort
    /**
     *The time complexiy of the following method is O(N).
     * Rearranges the array of strings in ascending order.
     * @param      a     the array to be sorted.
     */
    public static void sort(final String[] a) {
        //StdRandom.shuffle(a);
        sort(a, 0, a.length - 1, 0);
        assert isSorted(a);
    }
    /**
     *The time complexity of the below method is constant.
     *As the statment of the method executes only once when
     *the method calls.
     * @param      s   String s
     * @param      d   integer value.
     * @return integer value.
     */
    private static int charAt(final String s, final int d) {
        assert d >= 0 && d <= s.length();
        if (d == s.length()) {
            return -1;
        }
        return s.charAt(d);
    }
    /**
     * @param      a     integer value.
     * @param      lo    The lower.
     * @param      hi    The higher.
     * @param      d     integer value
     * *The time complexity of the following method is O(N).
     *As the sort()method is called N times.i.e recursion.
     */
    private static void sort(final String[] a, final int lo, final int hi,
                             final int d) {

        /**
        * cutoff to insertion sort for small subarrays
        */
        if (hi <= lo + CUTOFF) {
            insertion(a, lo, hi, d);
            return;
        }

        int lt = lo, gt = hi;
        int v = charAt(a[lo], d);
        int i = lo + 1;
        while (i <= gt) {
            int t = charAt(a[i], d);
            if      (t < v) {
                exch(a, lt++, i++);
            } else if (t > v) {
                exch(a, i, gt--);
            } else {
                i++;
            }
        }
        /**
        * a[lo..lt-1] < v = a[lt..gt] < a[gt+1..hi].
        */
        sort(a, lo, lt - 1, d);
        if (v >= 0) {
            sort(a, lt, gt, d + 1);
        }
        sort(a, gt + 1, hi, d);
    }
    /**
     *The time complexity of the following method is O(N^2).
     *As the for loop iterates upto the length of the array.
     * @param      a     String array.
     * @param      lo    The lower.
     * @param      hi    The higher.
     * @param      d     integer value.
     */
    private static void insertion(final String[] a, final int lo, final int hi,
                                  final int d) {
        for (int i = lo; i <= hi; i++) {
            for (int j = i; j > lo && less(a[j], a[j - 1], d); j--) {
                exch(a, j, j - 1);
            }
        }
    }
    /**
     *The time complexity of the following method is Constant.
     *As the each statment of the method executes only once when
     *the method calls.
     * @param      a     String array.
     * @param      i     integer value.
     * @param      j     integer value.
     */
    private static void exch(final String[] a, final int i, final int j) {
        String temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    /**
     * @param      v   String.
     * @param      w   integer value.
     * @param      d   integer value.
     *The time complexity of the following method is O(N).
     *As the for loop iterates upto the length of the array.
     * @return   boolen value.
     */
    private static boolean less(final String v, final String w, final int d) {
        assert v.substring(0, d).equals(w.substring(0, d));
        for (int i = d; i < Math.min(v.length(), w.length()); i++) {
            if (v.charAt(i) < w.charAt(i)) {
                return true;
            }
            if (v.charAt(i) > w.charAt(i)) {
                return false;
            }
        }
        return v.length() < w.length();
    }
    /**
     * Determines if sorted.
     *The time complexity of the below method is O(N).
     *As the for loop iterates upto the total no.of elements
     *present in the array.
     * @param      a     String array.
     * @return     True if sorted, False otherwise.
     */
    private static boolean isSorted(final String[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i].compareTo(a[i - 1]) < 0) {
                return false;
            }
        }
        return true;
    }
}
