import java.util.Scanner;
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String synsetsFile = sc.nextLine();
		String hypernymFile = sc.nextLine();
		String line = sc.nextLine();
		WordNet wordNet = new WordNet("Files/" + synsetsFile,
			"Files/" + hypernymFile);

		switch(line) {
			case"Graph":
				wordNet.printGraph();
			break;
			case"Query":
			break;
			default:
			break;
		}
	}
}