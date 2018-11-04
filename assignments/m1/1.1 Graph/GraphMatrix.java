import java.util.Scanner;
/**
 * Class for graph matrix.
 */
class GraphMatrix {
    /**
     * array declaration.
     */
    private String[] tokens;
    /**
     * 2d array declaration.
     */
    private int[][] matrix;
    /**
     * variable declaration.
     */
    private int v;
    /**
     * variable declaration.
     */
    private int e;
    /**
     * Constructs the object.
     */
    GraphMatrix() {
        e = 0;
    }
    /**
     * Constructs the object.
     *
     * @param      scan  The scan
     */
    GraphMatrix(final Scanner scan) {
        this.v = Integer.parseInt(scan.nextLine());
        matrix = new int[v][v];
        int edge = Integer.parseInt(scan.nextLine());
        tokens = scan.nextLine().split(",");
        int i;
        for (i = 0; i < edge; i++) {
            String[] input = scan.nextLine().split(" ");
            addEdge(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
        }
    }

    /**
     * Adds an edge.
     * The complexity of the following method is O(1).
     * As the statment of the method executes only once for the
     * each method calls.
     *
     * @param      v1    the int.
     * @param      w    the int.
     */
    public void addEdge(final int v1, final int w) {
        if (v1 != w) {
            if (!hasEdge(v1, w)) {
                matrix[v1][w] = 1;
                matrix[w][v1] = 1;
                e++;
            }
        }
    }

    /**
     * Determines if it has edge.
     * The complexity of the following method is O(1).
     * As the statment of the method executes only once for the
     * each method calls.
     *
     * @param      v1    the int.
     * @param      w    the int.
     *
     * @return     True if has edge, False otherwise.
     */
    public boolean hasEdge(final int v1, final int w) {
        if (matrix[v1][w] == 1) {
            return true;
        }
        return false;
    }

    /**
     * display method.
     * The complexity of the following method is O(E).
     * where V is the no.of vertices
     * As the method executes for the iterations of two for loops
     * upto their end values.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String str = "";
        str += v + " vertices, " + e + " edges" + "\n";
        if (e > 0) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    str += matrix[i][j] + " ";
                }
                str += "\n";
            }
            System.out.println(str);
        } else {
            str += "No edges";
            System.out.println(str);
        }
        return str.toString();
    }
}
