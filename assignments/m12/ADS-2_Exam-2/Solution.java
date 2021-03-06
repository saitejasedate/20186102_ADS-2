import java.util.*;
public class Solution {
	public static void main(String[] args) {
		// Self loops are not allowed...
		// Parallel Edges are allowed...
		// Take the Graph input here...
		Scanner sc = new Scanner(System.in);
		int numOfcities = Integer.parseInt(sc.nextLine());
		int numOfroadLines = Integer.parseInt(sc.nextLine());
		// System.out.println("hello");
		EdgeWeightedGraph edgeweighted = new EdgeWeightedGraph(numOfcities);
		while(numOfroadLines > 0) {
			String[] line = sc.nextLine().split(" ");
			Edge edge = new Edge(Integer.parseInt(line[0]), 
				Integer.parseInt(line[1]), Integer.parseInt(line[2]));
			edgeweighted.addEdge(edge);
			numOfroadLines --;
		}
		String caseToGo = sc.nextLine();
		switch (caseToGo) {
		case "Graph":
			System.out.println(edgeweighted);
			break;

		case "DirectedPaths":
			String[] directedPath = sc.nextLine().split(" ");
			int source = Integer.parseInt(directedPath[0]);
			int destination = Integer.parseInt(directedPath[1]);
			DijkstraSP dij = new DijkstraSP(edgeweighted, source);
			if (dij.hasPathTo(destination)) {
                System.out.println(dij.distTo(destination));
            } else {
                System.out.println("No Path Found.");
            }
			break;

		case "ViaPaths":
			// Handle the case of ViaPaths, where three integers are given.
			// First is the source and second is the via is the one where path should pass throuh.
			// third is the destination.
			// If the path exists print the distance between them.
			// Other wise print "No Path Found."
			break;

		default:
			break;
		}
	}
}
