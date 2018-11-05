/**
 * @author : saitejasedate.
 */
import java.util.Scanner;
/**.
 * solution class
 */
final class Solution {
    /**.
     * solution constructor
     */
    private Solution() {
        //Solution constructor
    }
    /**.
     * main method
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int numOfVertices = Integer.parseInt(scan.nextLine());
        int numOfEdges = Integer.parseInt(scan.nextLine());
        EdgeWeightedGraph g = new EdgeWeightedGraph(numOfVertices);
        while (scan.hasNext()) {
            String[] tokens = scan.nextLine().split(" ");
            g.addEdge(new Edge(Integer.parseInt(
                tokens[0]), Integer.parseInt(
                tokens[1]), Double.parseDouble(
                tokens[2])));
        }
        KruskalMST krushkal = new KruskalMST(g);
        System.out.format("%.5f", krushkal.totalWeight());

    }
}