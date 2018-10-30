/**
 * import Scanner class.
 */
import java.util.Scanner;
/**
 * import Array class.
 */
import java.util.Arrays;
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
    GraphMatrix(Scanner scan) {
        this.v = Integer.parseInt(scan.nextLine());
        matrix = new int[v][v];
        int edge = Integer.parseInt(scan.nextLine());
        tokens = scan.nextLine().split(",");
        for (int i = 0; i < edge; i++) {
            String[] inputs = scan.nextLine().split(" ");
            addEdge(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1]));
        }
    }

    /**
     * Adds an edge.
     *
     * @param      v    the int.
     * @param      w    the int.
     */
    public void addEdge(int v, int w) {
        if (v != w) {
            if (!hasEdge(v, w)) {
                matrix[v][w] = 1;
                matrix[w][v] = 1;
                e++;
            }
        }
    }

    /**
     * Determines if it has edge.
     *
     * @param      v    the int.
     * @param      w    the int.
     *
     * @return     True if has edge, False otherwise.
     */
    public boolean hasEdge(int v, int w) {
        if (matrix[v][w] == 1) {
            return true;
        }
        return false;
    }

    /**
     * display method.
     */
    public void print() {
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
    }
}
