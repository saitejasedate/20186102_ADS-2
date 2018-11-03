import java.util.Scanner;
public class Solution {
	public static void main(String[] args) {
		// read the first line of the input to get the number of vertices
		Scanner sc = new Scanner(System.in);
		int numOfvertices = sc.nextInt();
		sc.nextLine();
		Digraph digraph = new Digraph(numOfvertices);
		while(sc.hasNextLine()) {
			String[] line = sc.nextLine().split(" ");
			int vertex = Integer.parseInt(line[0]);
			int[] adj = new int[line.length];
			for (int i = 1; i < line.length; i++) {
				adj[i] = Integer.parseInt(line[i]);
				digraph.addEdge(vertex, adj[i]);
			}
			System.out.println(digraph);
		}
		// iterate count of vertices times 
		// to read the adjacency list from std input
		// and build the graph
		
		
		// Create page rank object and pass the graph object to the constructor
		
		// print the page rank object
		
		// This part is only for the final test case
		
		// File path to the web content
		String file = "WebContent.txt";
		
		// instantiate web search object
		// and pass the page rank object and the file path to the constructor
		
		// read the search queries from std in
		// remove the q= prefix and extract the search word
		// pass the word to iAmFeelingLucky method of web search
		// print the return value of iAmFeelingLucky
		
	}
}
