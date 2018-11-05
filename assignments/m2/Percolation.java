/**
 * import java Scanner class.
 */
import java.util.*;
/**
 * Class for percolation.
 */
class Percolation {
	/**
	 * int openSiteCount.
	 */
    int openSiteCount;
    /**
     * boolean two dimensional array.
     */
    boolean[][] arr;
    /**
     * Graph graph.
     */
    Graph graph;
    /**
     * int n;
     */
    int n;

    // create n-by-n grid, with all sites blocked

    /**
     * Constructs the object.
     *
     * @param      n     { parameter_description }
     */
    public Percolation(int n) {
        this.n = n;
        arr = new boolean[n][n];
        graph = new Graph((n)*(n) + 2);
   }

   // open site (row, col) if it is not open already

   /**
    * { function_description }
    *
    * @param      i     { parameter_description }
    * @param      j     { parameter_description }
    */
   public void open(int i, int j) {
        arr[i][j] = true;

        // Top site.
        if(i == 0) graph.addEdge(n*n, cal(i,j));

        // Bottom site.
        if(i == n-1) graph.addEdge(n*n+1, cal(i,j));

        // bottom site
        if (i < n-1 && arr[i+1][j] == true)
            graph.addEdge(cal(i, j), cal(i+1, j));

        // top site
        if (i > 0   && arr[i-1][j] == true)
            graph.addEdge(cal(i, j), cal(i-1, j));

        // right site
        if (j < n-1 && arr[i][j+1] == true)
            graph.addEdge(cal(i, j), cal(i, j+1));

        // left site
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

   // does the system Percolates?

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
