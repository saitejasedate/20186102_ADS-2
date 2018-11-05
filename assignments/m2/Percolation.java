/**
 * Class for percolation.
 */
class Percolation {
	/**
	 * int openSite.
	 */
	int openSite;
	/**
	 * boolean two - dimensional array.
	 */
	boolean[][] arr;
	/**
	 * Graph graph.
	 */
	Graph graph;
	/**
	 * int n.
	 */
	int n;
	/**
	 * Constructs the object.
	 *
	 * @param      n1    The n 1
	 */
	public Percolation(int n1) {
		this.n = n1;
		arr = new boolean[n][n];
		Graph graph = new Graph((n)*(n)+2);
	}
	/**
	 * { function_description }
	 *
	 * @param      i     { parameter_description }
	 * @param      j     { parameter_description }
	 */
   public void open(int i, int j) {
        arr[i][j] = true;

        // Top site.
        if(i == 0) graph.addEdge(n*n, cal(i, j));

        // Bottom site.
        if(i == n-1) graph.addEdge(n*n+1, cal(i, j));

        // bottom site.
        if (i < n-1 && arr[i+1][j] == true)
            graph.addEdge(cal(i, j), cal(i+1, j));

        // top site.
        if (i > 0   && arr[i-1][j] == true)
            graph.addEdge(cal(i, j), cal(i-1, j));

        // right site.
        if (j < n-1 && arr[i][j+1] == true)
            graph.addEdge(cal(i, j), cal(i, j+1));

        // left site.
        if (j > 0   && arr[i][j-1] == true)
            graph.addEdge(cal(i, j), cal(i, j-1));
   }
   /**
    * { function_description }
    *
    * @param      i     { parameter_description }
    * @param      j     { parameter_description }
    *
    * @return     { description_of_the_return_value }
    */
   public int cal(int i, int j) {
        return (n*i)+j;
   }
   /**
    * { function_description }
    *
    * @return     { description_of_the_return_value }
    */
   public boolean percolates() {
        CC cc = new CC(graph);
        if (cc.connected(n*n, n*n+1))
            return true;
        return false;
    }
}
