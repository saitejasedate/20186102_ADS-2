/**
 * Class for directed cycle.
 */
public class DirectedCycle {
    /**
     * { var_description }.
     */
    private boolean[] marked;
    /**
     * { var_description }.
     */
    private int[] edgeTo;
    /**
     * { var_description }.
     */
    private boolean[] onStack;
    /**
     * { var_description }.
     */
    private Stack<Integer> cycle;
    /**
     * { var_description }.
     */
    private int vertices;
    /**
     * { var_description }.
     */
    private boolean isbipartite = false;
    /**
     * Determines whether the digraph {@code G} has a directed cycle and, if so
     * finds such a cycle.
     * @param graph the digraph
     */
    public DirectedCycle(final Graph graph) {
        this.vertices = 0;
        marked  = new boolean[graph.vertices()];
        onStack = new boolean[graph.vertices()];
        edgeTo  = new int[graph.vertices()];
        for (int v = 0; v < graph.vertices(); v++) {
            if (!marked[v] && cycle == null) {
                dfs(graph, v);
            }
        }
    }
    /**
     * { function_description }.
     *
     * @param      graph     { parameter_description }
     * @param      v     { parameter_description }
     */
    private void dfs(final Graph graph, final int v) {
        isbipartite = !isbipartite;
        onStack[v] = true;
        marked[v] = true;
        for (int w : graph.adj(v)) {

            // short circuit if directed cycle found
            if (cycle != null) {
                return;
            } else if (!marked[w]) {
                edgeTo[w] = v;
                dfs(graph, w);
            } else if (onStack[w]) {
                cycle = new Stack<Integer>();
                for (int x = v; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
            }
        }
        onStack[v] = false;
    }

    /**
     * Determines if it has cycle.
     *
     * @return     True if has cycle, False otherwise.
     */
    public boolean hasCycle() {
        return cycle != null;
    }

    /**
     * Determines if bipartite.
     *
     * @return     True if bipartite, False otherwise.
     */
    public boolean isBipartite() {
        return isbipartite;
    }
}
