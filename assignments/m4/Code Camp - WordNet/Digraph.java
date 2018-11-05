/**
 * Class for digraph.
 */
public class Digraph {
    /**
     * string for new line.
     */
    private static final String NEWLINE = System.getProperty("line.separator");
    /**
     * integer variable.
     */
    private final int v;
    /**
     * integer variable.
     */
    private int e;
    /**
     * matrix of bag type.
     */
    private Bag<Integer>[] adj;
    /**
     * integer array.
     */
    private int[] indegree;
    /**
     * Initializes an empty digraph with <em>V</em> vertices.
     * Time complexity : O(V).
     * @param  ve the number of vertices
     * @throws IllegalArgumentException if {@code V < 0}
     */
    public Digraph(final int ve) {
        if (ve < 0) {
            throw new IllegalArgumentException(
                "Number of vertices in a Digraph must be nonnegative");
        }
        this.v = ve;
        this.e = 0;
        indegree = new int[ve];
        adj = (Bag<Integer>[]) new Bag[ve];
        for (int i = 0; i < ve; i++) {
            adj[i] = new Bag<Integer>();
        }
    }
    /**
     * Returns the number of vertices in this digraph.
     *Time complexity : O(1).
     * @return the number of vertices in this digraph
     */
    public int v() {
        return v;
    }

    /**
     * Returns the number of edges in this digraph.
     *Time complexity : O(1).
     * @return the number of edges in this digraph
     */
    public int e() {
        return e;
    }
    /**
     * validate vertex method.
     *Time complexity : O(1).
     * @param      vertex  The vertex
     */
    private void validateVertex(final int vertex) {
        if (vertex < 0 || vertex >= v) {
            throw new IllegalArgumentException(
                "vertex " + vertex + " is not between 0 and " + (v - 1));
        }
    }

    /**
     * Adds the directed edge v→w to this digraph.
     *Time complexity : O(1).
     * @param  ve the tail vertex
     * @param  w the head vertex
     * @throws IllegalArgumentException
     *  unless both {@code 0 <= v < V} and {@code 0 <= w < V}
     */
    public void addEdge(final int ve, final int w) {
        validateVertex(ve);
        validateVertex(w);
        adj[ve].add(w);
        indegree[w]++;
        e++;
    }

    /**
     * Returns the vertices adjacent from vertex
     *  {@code v} in this digraph.
     *Time complexity : O(V).
     * @param  ve the vertex
     * @return the vertices adjacent from vertex
     *  {@code v} in this digraph, as an iterable
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public Iterable<Integer> adj(final int ve) {
        validateVertex(ve);
        return adj[ve];
    }

    /**
     * Returns the number of directed edges incident from vertex {@code v}.
     * This is known as the <em>outdegree</em> of vertex {@code v}.
     *Time complexity : O(1).
     * @param  ve the vertex
     * @return the outdegree of vertex {@code v}
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public int outdegree(final int ve) {
        validateVertex(ve);
        return adj[ve].size();
    }
    /**
     * Returns the number of directed edges incident to vertex {@code v}.
     * This is known as the <em>indegree</em> of vertex {@code v}.
     *Time complexity : O(1).
     * @param  ve the vertex
     * @return the indegree of vertex {@code v}
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public int indegree(final int ve) {
        validateVertex(ve);
        return indegree[ve];
    }

    /**
     * Returns the reverse of the digraph.
     *Time complexity : O(V^2).
     * @return the reverse of the digraph
     */
    public Digraph reverse() {
        Digraph reverse = new Digraph(v);
        for (int i = 0; i < v; i++) {
            for (int w : adj(i)) {
                reverse.addEdge(w, i);
            }
        }
        return reverse;
    }

    /**
     * Returns a string representation of the graph.
     *Time complexity : O(V^2).
     * @return the number of vertices
     *  <em>V</em>, followed by the number of edges <em>E</em>,
     *         followed by the <em>V</em> adjacency lists
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(v + " vertices, " + e + " edges " + NEWLINE);
        for (int i = 0; i < v; i++) {
            s.append(String.format("%d: ", i));
            for (int w : adj[i]) {
                s.append(String.format("%d ", w));
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }
}




