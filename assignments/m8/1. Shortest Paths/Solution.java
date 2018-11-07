import java.util.Scanner;
import java.util.ArrayList;
/**
 *@author:saitejasedate.
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
      /**
       * private counstructor.
       */
    }
    /**
     *It is thge main method in this we can read the
     * inputs from the input files and then converted into
     * the tokens and then send as parameters to the spcified
     * methods of the classes.
     * The time complexity of the main method is O(E+V).
     * As the for loops iterates upto the no.of vertices
     * and the no.of edges.
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        String[] edges = sc.nextLine().split(" ");
        ArrayList<String> list = new ArrayList<String>();
        for (int j = 0; j < edges.length; j++) {
            list.add(edges[j]);
        }
        EdgeWeightedGraph graph = new EdgeWeightedGraph(Integer.
                                              parseInt(input[0]));
        for (int i = 0; i < Integer.parseInt(input[1]); i++) {
            String[] tokens = sc.nextLine().split(" ");
            graph.addEdge(new Edge(list.indexOf(tokens[0]),
                                   list.indexOf(tokens[1]),
                                   Integer.parseInt(tokens[2])));
        }
        int cases = Integer.parseInt(sc.nextLine());
        for (int k = 0; k < cases; k++) {
            String[] item = sc.nextLine().split(" ");
            DijkstraSP dsp = new DijkstraSP(graph, list.indexOf(item[0]));
            System.out.println(Math.round(dsp.distTo(list.indexOf(item[1]))));
        }
    }
}


