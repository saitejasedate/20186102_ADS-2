import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// Self loops are not allowed...
		// Parallel Edges are allowed...
		// Take the Graph input here...
		Scanner sc = new Scanner(System.in);
		int numOfcities = sc.nextInt();
		sc.nextLine();
		int numOfroadLines = sc.nextInt();
		sc.nextLine();
		Digraph digraph = new Digraph(numOfcities);
		System.out.println("hello");
		while(sc.hasNextLine()) {
			String[] line = sc.nextLine().split(" ");
			int cities = Integer.parseInt(line[0]);
			int[] adj = new int[line.length];
			for (int i = 1; i < line.length; i++) {
				adj[i] = Integer.parseInt(line[i]);
				digraph.addEdge(cities, adj[i]);
			}
		}
		String caseToGo = null;
		switch (caseToGo) {
		case "Graph":
			System.out.println(numOfcities + "vertices" + " " + numOfroadLines + "edges");
			System.out.println(digraph);
			break;

		case "DirectedPaths":
			// Handle the case of DirectedPaths, where two integers are given.
			// First is the source and second is the destination.
			// If the path exists print the distance between them.
			// Other wise print "No Path Found."
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