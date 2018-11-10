/**.
 * Class for edge weighted graph.
 */
class EdgeWeightedGraph {
    /**.
     * String.
     */
    private static final String NEWLINE = System.getProperty("line.separator");
    /**.
     * integr value.
     */
    private final int vert;
    /**.
     * integer value.
     */
    private int edge;
    /**.
     * adjacent array of Edge type.
     */
    private Bag<Edge>[] adj;

    /**.
     * Initializes an empty edge-weighted graph with
     * {@code V} vertices and 0
     * edges.
      *By the analysis the the time constant of the following method
      *is O(1).
      *The statment of the method executes only once when the method calls.
      *By the analysis the the time constant of the following method
      *is O(V).Here V is the total no.of vertices.
      *The statment of the method executes only once when the method calls.
     * @param      v     { parameter_description }
     * @throws     IllegalArgumentException  if {@code V < 0}
     */
    EdgeWeightedGraph(final int v) {
        if (v < 0) {
            throw new IllegalArgumentException(
                "Number of vertices must be nonnegative");
        }
        this.vert = v;
        this.edge = 0;
        adj = (Bag<Edge>[]) new Bag[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new Bag<Edge>();
        }
    }
    /**
     * Returns the number of vertices in this edge-weighted graph.
     *By the analysis the the time constant of the following method
     *is O(1).
      *The statment of the method executes only once when the method calls.
     * @return the number of vertices in this edge-weighted graph
     */
    public int vert() {
        return vert;
    }

    /**
     * Returns the number of edges in this edge-weighted graph.
      *By the analysis the the time constant of the following method
      *is O(1).
      *The statment of the method executes only once when the method calls.
     * @return the number of edges in this edge-weighted graph
     */
    public int edge() {
        return edge;
    }

    // throw an IllegalArgumentException unless {@code 0 <= v < V}
    /**.
     *By the analysis the the time constant of the following method
     *is O(1).
     *The statment of the method executes only once when the method calls.
     *
     * @param      v     vertex
     */
    private void validateVertex(final int v) {
        if (v < 0 || v >= vert) {
            throw new IllegalArgumentException(
                "vertex " + v + " is not between 0 and " + (vert - 1));
        }
    }

    /**.
     * Adds the undirected edge {@code e} to this edge-weighted graph.
     *By the analysis the the time constant of the following method
     *is O(1).
     *The statment of the method executes only once when the method calls.
     * @param  e the edge
     * @throws IllegalArgumentException unless both endpoints are
     *          between {@code 0} and {@code V-1}
     */
    public void addEdge(final Edge e) {
        int v = e.either();
        int w = e.other(v);
        validateVertex(v);
        validateVertex(w);
        adj[v].add(e);
        adj[w].add(e);
        edge++;
    }

    /**
     * Returns the edges incident on vertex {@code v}.
      *By the analysis the the time constant of the following method
      *is O(E).As E is the totoal no.of edges present in it.
     *The iteratoe method iterates upto the all the edge values.
     * @param  v the vertex
     * @return the edges incident on vertex {@code v} as an Iterable
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public Iterable<Edge> adj(final int v) {
        validateVertex(v);
        return adj[v];
    }

    /**
     * Returns the degree of vertex {@code v}.
      *By the analysis the the time constant of the following method
      *is O(1).
      *The statment of the method executes only once when the method calls.
     * @param  v the vertex
     * @return the degree of vertex {@code v}
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public int degreedge(final int v) {
        validateVertex(v);
        return adj[v].size();
    }

    /**
     * Returns all edges in this edge-weighted graph.
      *By the analysis the the time constant of the following method
      *is O(E+V).
     *As the two for loop iterates upto the total no.of edge vales
     *and the vertices.
     * To iterate over the edges in this edge-weighted graph,
     *  use foreach notation:
     * {@code for (Edge e : G.edges())}.
     *
     * @return all edges in this edge-weighted graph, as an iterable
     */
    public Iterable<Edge> edges() {
        Bag<Edge> list = new Bag<Edge>();
        for (int v = 0; v < vert; v++) {
            int selfLoops = 0;
            for (Edge e : adj(v)) {
                if (e.other(v) > v) {
                    list.add(e);
                } else if (e.other(v) == v) {
                    if (selfLoops % 2 == 0) {
                        list.add(e);
                    }
                    selfLoops++;
                }
            }
        }
        return list;
    }

    /**
     * Returns a string representation of the edge-weighted graph.
     * This method takes time proportional to <em>E</em> + <em>V</em>.
     *By the analysis the the time constant of the following method
      *is O(E+V).
     * @return the number of vertices <em>V</em>, followed by
     *          the number of edges <em>E</em>,
     *         followed by the <em>V</em> adjacency lists of edges
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(vert + " " + "vertices" + " " + edge + " " + "edges" + NEWLINE);
        for (int v = 0; v < vert; v++) {
            s.append(v + ": ");
            for (Edge e : adj[v]) {
                s.append(e + "  ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }
}


