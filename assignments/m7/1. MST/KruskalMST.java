/**.
 * kruskal class for mst implimentation
 * Complexity O(ElogE)
 */
class KruskalMST {
    /**.
     * weight variable
     */
    private Double weight = 0.0;
    /**.
     * Queue for implementing mst
     */
    private Queue<Edge> mst = new Queue<Edge>();
    /**.
     * Krushkal constructor
     * Complexity is O(E*logE)
     *
     * @param      g     { of type edge eighted graph }
     */
    KruskalMST(final EdgeWeightedGraph g) {
        //weight = 0.0;
        MinPQ<Edge> pq = new MinPQ<Edge>();
        for (Edge e : g.edges()) {
            pq.insert(e);
        }
        UF uf = new UF(g.vertices());
        while (!pq.isEmpty() && mst.size() < g.vertices() - 1) {
            Edge e = pq.delMin();
            int v = e.either();
            int w = e.other(v);
            if (!uf.connected(v, w)) {
                uf.union(v, w);
                //this is mst
                mst.enqueue(e);
                weight += e.weight();
            }
        }
    }
    /**.
     * method to get the total weight
     * complexity is O(1)
     *
     * @return     { Double }
     */
    public Double totalWeight() {
        return weight;
    }
    /**.
     * method to return the edges
     * complexity is O(1)
     *
     * @return     { Iterator }
     */
    public Iterable<Edge> edges() {
        return mst;
    }
}
