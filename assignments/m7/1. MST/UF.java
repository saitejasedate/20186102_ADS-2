/**
 * Class for uf.
 */
public class UF {
    /**
     * parent array.
     */
    private int[] parent;
    /**
     * rank array.
     */
    private byte[] rank;
    /**
     * count.
     */
    private int count;     // number of components
    /**
     * Initializes an empty union–find data structure with {@code n} sites
     * {@code 0} through {@code n-1}. Each site is initially in its own
     * component.
     *
     * @param  n the number of sites
     * @throws IllegalArgumentException if {@code n < 0}
     */
    public UF(final int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        count = n;
        parent = new int[n];
        rank = new byte[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    /**
     * Returns the component identifier for the component
     * containing site {@code p}.
     * @param  p the integer representing one site
     * @return the component identifier for the component
     * containing site {@code p}
     * @throws IllegalArgumentException unless {@code 0 <= p < n}
     * Time complexity for this method is O(p).
     */
    public int find(final int p) {
        int p1 = p;
        validate(p1);
        while (p1 != parent[p1]) {
            parent[p1] = parent[parent[p1]];    // path compression by halving
            p1 = parent[p1];
        }
        return p1;
    }

    /**
     * Returns the number of components.
     *
     * @return the number of components (between {@code 1} and {@code n})
     * Time complexity for this method is O(1).
     */
    public int count() {
        return count;
    }

    /**
     * Returns true if the the two sites are in the same component.
     *
     * @param  p the integer representing one site
     * @param  q the integer representing the other site
     * @return {@code true} if the two sites {@code p}
     * and {@code q} are in the same component;
     *         {@code false} otherwise
     * @throws IllegalArgumentException unless
     *         both {@code 0 <= p < n} and {@code 0 <= q < n}
     * Time complexity for this method is O(1).
     */
    public boolean connected(final int p, final int q) {
        return find(p) == find(q);
    }

    /**
     * Merges the component containing site {@code p} with the
     * the component containing site {@code q}.
     *
     * @param  p the integer representing one site
     * @param  q the integer representing the other site
     * @throws IllegalArgumentException unless
     *         both {@code 0 <= p < n} and {@code 0 <= q < n}
     * Time complexity for this method is O(log E).
     */
    public void union(final int p, final int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }
        // make root of smaller rank point to root of larger rank
        if (rank[rootP] < rank[rootQ]) {
            parent[rootP] = rootQ;
        } else if (rank[rootP] > rank[rootQ]) {
            parent[rootQ] = rootP;
        } else {
            parent[rootQ] = rootP;
            rank[rootP]++;
        }
        count--;
    }

    /**
     * validate method.
     * @param      p     one site.
     */
    private void validate(final int p) {
        int n = parent.length;
        if (p < 0 || p >= n) {
            throw new IllegalArgumentException("index " + p
             + " is not between 0 and " + (n - 1));
        }
    }
}
