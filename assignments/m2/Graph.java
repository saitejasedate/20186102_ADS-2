
/**
 * Class for graph.
 */
public class Graph {
    /**
     * { var_description }.
     */
    private static final String NEWLINE = System.getProperty("line.separator");
    /**
     * { var_description }.
     */
    private final int ver;
    /**
     * { var_description }.
     */
    private int edge;
    /**
     * { var_description }.
     */
    private Bag<Integer>[] adj;

    /**
     * Initializes an empty graph with {@code ver} vertices and 0 edges. param
     * ver the number of vertices
     *
     * @param      v     { parameter_description }
     * @throws     IllegalArgumentException  if {@code ver < 0}.
     */
    public Graph(final int v) {
        if (v < 0) {
            throw new IllegalArgumentException(
                "Number of vertices must be nonnegative");
        }
        this.ver = v;
        this.edge = 0;
        adj = (Bag<Integer>[]) new Bag[ver];
        for (int i = 0; i < ver; i++) {
            adj[i] = new Bag<Integer>();
        }
    }

    /**
     * Returns the number of vertices in this graph.
     *
     * @return the number of vertices in this graph
     */
    public int v() {
        return ver;
    }

    /**
     * Returns the number of edges in this graph.
     *
     * @return the number of edges in this graph
     */
    public int e() {
        return edge;
    }

    /**
     * throw an IllegalArgumentException unless {@code 0 <= v < V}.
     *
     * @param      v     { parameter_description }.
     */
    private void validateVertex(final int v) {
        if (v < 0 || v >= ver) {
            throw new IllegalArgumentException(
                "vertex " + v + " is not between 0 and " + (ver - 1));
        }
    }

    /**
     * Adds the undirected edge v-w to this graph.
     *
     * @param  v one vertex in the edge
     * @param  w the other vertex in the edge
     * @throws IllegalArgumentException unless both
     * {@code 0 <= v < V} and {@code 0 <= w < V}
     */
    public void addEdge(final int v, final int w) {
        validateVertex(v);
        validateVertex(w);
        edge++;
        adj[v].add(w);
        adj[w].add(v);
    }

    /**
     * Determines if it has edge.
     *
     * @param      v     { parameter_description }
     * @param      w     { parameter_description }
     *
     * @return     True if has edge, False otherwise.
     */
    public boolean hasEdge(final int v, final int w) {
        for (int each : adj[w]) {
            if (each == v) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the vertices adjacent to vertex {@code v}.
     *
     * @param  v the vertex
     * @return the vertices adjacent to vertex {@code v}, as an iterable
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public Iterable<Integer> adj(final int v) {
        validateVertex(v);
        return adj[v];
    }

    /**
     * Returns the degree of vertex {@code v}.
     *
     * @param  v the vertex
     * @return the degree of vertex {@code v}
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public int degree(final int v) {
        validateVertex(v);
        return adj[v].size();
    }


    /**
     * Returns a string representation of this graph.
     *
     * @return the number of vertices <em>V</em>, followed
     * by the number of edges <em>E</em>,
     *         followed by the <em>V</em> adjacency lists
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(ver + " vertices, " + edge + " edges " + NEWLINE);
        for (int v = 0; v < ver; v++) {
            s.append(v + ": ");
            for (int w : adj[v]) {
                s.append(w + " ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }
}
