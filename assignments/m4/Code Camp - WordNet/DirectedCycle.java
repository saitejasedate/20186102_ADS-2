
/**
 * Class for directed cycle.
 */
public class DirectedCycle {
    /**
     * marked array of boolean type.
     */
    private boolean[] marked;
    /**
     * edgeTo array of integer type.
     */
    private int[] edgeTo;
    /**
     * onStack array of boolean type.
     */
    private boolean[] onStack;
    /**
     * directed cycle.
     */
    private Stack<Integer> cycle;
    /**
     * Determines whether the digraph {@code G} has a directed cycle and, if so,
     * finds such a cycle.
     * Time complexity : O(V).
     * @param g the digraph
     */
    public DirectedCycle(final Digraph g) {
        marked  = new boolean[g.v()];
        onStack = new boolean[g.v()];
        edgeTo  = new int[g.v()];
        for (int i = 0; i < g.v(); i++) {
            if (!marked[i] && cycle == null) {
                dfs(g, i);
            }
        }
    }
    /**
     * dfs method.
     *Time complexity : O(V).
     * @param      g digraph
     * @param      v integer variable.
     */
    public void dfs(final Digraph g, final int v) {
        onStack[v] = true;
        marked[v] = true;
        for (int w : g.adj(v)) {

            // short circuit if directed cycle found
            if (cycle != null) {
                return;
            } else if (!marked[w]) {
                edgeTo[w] = v;
                dfs(g, w);
            } else if (onStack[w]) {
                cycle = new Stack<Integer>();
                for (int x = v; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
                assert check();
            }
        }
        onStack[v] = false;
    }
    /**
     * Does the digraph have a directed cycle?
     * Time complexity : O(1).
     * @return {@code true} if
     *  the digraph has a directed cycle, {@code false} otherwise
     */
    public boolean hasCycle() {
        return cycle != null;
    }
    /**
     * Returns a directed cycle if
     * the digraph has a directed cycle, and {@code null} otherwise.
     * Time complexity : O(V).
     * @return a directed cycle (as an iterable)
     * if the digraph has a directed cycle,
     *    and {@code null} otherwise
     */
    public Iterable<Integer> cycle() {
        return cycle;
    }
    /**
     * check method.
     *Time complexity : O(V).
     * @return true or false.
     */
    private boolean check() {

        if (hasCycle()) {
            // verify cycle
            int first = -1, last = -1;
            for (int v : cycle()) {
                if (first == -1) {
                    first = v;
                }
                last = v;
            }
            if (first != last) {
                System.err.printf(
                    "cycle begins with %d and ends with %d\n", first, last);
                return false;
            }
        }
        return true;
    }
}



