/**
 * Class for breadth first directed paths.
 */
public class BreadthFirstDirectedPaths {
    /**
     * infinity.
     */
    private static final int INFINITY = Integer.MAX_VALUE;
    /**
     * marked array.
     */
    private boolean[] marked;  // marked[v] = is there an s->v path?
    /**
     * edge to array.
     */
    private int[] edgeTo;      // edgeTo[v] = last edge on shortest s->v path
    /**
     * distTo array.
     */
    private int[] distTo;      // distTo[v] = length of shortest s->v path

    /**
     * Computes the shortest path from
     *  {@code s} and every other vertex in graph {@code G}.
     * @param g the digraph
     * @param s the source vertex
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public BreadthFirstDirectedPaths(final Digraph g, final int s) {
        marked = new boolean[g.v()];
        distTo = new int[g.v()];
        edgeTo = new int[g.v()];
        for (int v = 0; v < g.v(); v++) {
            distTo[v] = INFINITY;
        }
        validateVertex(s);
        bfs(g, s);
    }

    /**
     * Computes the shortest path from
     * any one of the source vertices in {@code sources}
     * to every other vertex in graph {@code G}.
     * @param g the digraph
     * @param sources the source vertices
     * @throws IllegalArgumentException unless each vertex {@code v} in
     *         {@code sources} satisfies {@code 0 <= v < V}
     */
    public BreadthFirstDirectedPaths(final
        Digraph g, final Iterable<Integer> sources) {
        marked = new boolean[g.v()];
        distTo = new int[g.v()];
        edgeTo = new int[g.v()];
        for (int v = 0; v < g.v(); v++) {
            distTo[v] = INFINITY;
        }
        validateVertices(sources);
        bfs(g, sources);
    }
    /**
     * bfs method.
     *
     * @param      g    digraph.
     * @param      s    integer variable.
     */
    private void bfs(final Digraph g, final int s) {
        Queue<Integer> q = new Queue<Integer>();
        marked[s] = true;
        distTo[s] = 0;
        q.enqueue(s);
        while (!q.isEmpty()) {
            int v = q.dequeue();
            for (int w : g.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    distTo[w] = distTo[v] + 1;
                    marked[w] = true;
                    q.enqueue(w);
                }
            }
        }
    }
    /**
     * bfs method.
     *
     * @param      g  digraph.
     * @param      sources  The sources
     */
    private void bfs(final Digraph g,
                     final Iterable<Integer> sources) {
        Queue<Integer> q = new Queue<Integer>();
        for (int s : sources) {
            marked[s] = true;
            distTo[s] = 0;
            q.enqueue(s);
        }
        while (!q.isEmpty()) {
            int v = q.dequeue();
            for (int w : g.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    distTo[w] = distTo[v] + 1;
                    marked[w] = true;
                    q.enqueue(w);
                }
            }
        }
    }

    /**
     * Is there a directed path from the
     * source {@code s} (or sources) to vertex {@code v}?
     * @param v the vertex
     * @return {@code true} if there is a directed path, {@code false} otherwise
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public boolean hasPathTo(final int v) {
        validateVertex(v);
        return marked[v];
    }

    /**
     * Returns the number of edges in a shortest path from the source {@code s}
     * (or sources) to vertex {@code v}?
     * @param v the vertex
     * @return the number of edges in a shortest path
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public int distTo(final int v) {
        validateVertex(v);
        return distTo[v];
    }

    /**
     * Returns a shortest path from {@code s} (or sources) to {@code v}, or
     * {@code null} if no such path.
     * @param v the vertex
     * @return the sequence of vertices on a shortest path, as an Iterable
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public Iterable<Integer> pathTo(final int v) {
        validateVertex(v);

        if (!hasPathTo(v)) {
            return null;
        }
        Stack<Integer> path = new Stack<Integer>();
        int x;
        for (x = v; distTo[x] != 0; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(x);
        return path;
    }

    /**
     * validate vertex method.
     *
     * @param      v   integer variable.
     */
    private void validateVertex(final int v) {
        int ve = marked.length;
        if (v < 0 || v >= ve) {
            throw new IllegalArgumentException("vertex "
             + v + " is not between 0 and " + (v - 1));
        }
    }
    /**
     * validate vertices.
     *
     * @param      vertices  The vertices
     */
    private void validateVertices(final Iterable<Integer> vertices) {
        if (vertices == null) {
            throw new IllegalArgumentException("argument is null");
        }
        int ve = marked.length;
        for (int v : vertices) {
            if (v < 0 || v >= v) {
                throw new IllegalArgumentException("vertex "
                 + v + " is not between 0 and " + (ve - 1));
            }
        }
    }
}
