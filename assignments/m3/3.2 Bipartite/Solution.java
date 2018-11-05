/**
 * @author : saitejasedate.
 */
import java.util.Scanner;
/**
 * client class.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //unused constructor.
    }
    /**
     * client method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertices = Integer.parseInt(sc.nextLine());
        int edges = Integer.parseInt(sc.nextLine());
        Graph graph = new Graph(vertices);
        while (sc.hasNext()) {
            String[] input = sc.nextLine().split(" ");
            graph.addEdge(Integer.parseInt(input[0]),
                          Integer.parseInt(input[1]));
        }
        DirectedCycle directedcycle = new DirectedCycle(graph);
        if (directedcycle.isBipartite()) {
            System.out.println("Graph is bipartite");
        } else {
            System.out.println("Graph is not a bipartite");
        }
    }
}
