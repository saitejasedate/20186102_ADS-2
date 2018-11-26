import java.util.Scanner;
public class BlackFilter {

	// Do not instantiate.
	private BlackFilter() { }

	public static void main(String[] args) {
		In in = new In("dictionary.txt");
		String[] dict = in.readAllStrings();
		if (args[0].equals("TrieST")) {
			TrieST<Integer> t = new TrieST();
			// read in strings and add to TST
			for (String s : dict) {
				String word = s.toLowerCase();
				if (t.contains(word)) {
					t.put(word, t.get(word) + 1);
				} else {
					t.put(word, 1);
				}
			}
			In in1 = new In("war.txt");
			String[] dict1 = in1.readAllStrings();
			// read in string from standard input, printing out all exceptions
			Stopwatch s = new Stopwatch();
			for (String s1 : dict1) {
				String word = s1.toLowerCase().replaceAll("[^A-Za-z0-9]", "");
				if (word.length() > 1) {
					if (!t.contains(word)) {
						StdOut.println(word);
					}
				}
			}
			System.out.println(s.elapsedTime());
		} else if (args[0].equals("TST")) {
			TST<Integer> t = new TST();
			// read in strings and add to TST
			for (String s : dict) {
				String word = s.toLowerCase();
				if (t.contains(word)) {
					t.put(word, t.get(word) + 1);
				} else {
					t.put(word, 1);
				}
			}
			In in1 = new In("war.txt");
			String[] dict1 = in1.readAllStrings();
			// read in string from standard input, printing out all exceptions
			Stopwatch s = new Stopwatch();
			for (String s1 : dict1) {
				String word = s1.toLowerCase().replaceAll("[^A-Za-z0-9]", "");
				if (word.length() > 1) {
					if (!t.contains(word)) {
						StdOut.println(word);
					}
				}
			}
			System.out.println(s.elapsedTime());
		}
	}
}
