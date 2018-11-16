public class BoggleSolver {
	TrieST<Integer> trie = new TrieST<Integer>();
	// Initializes the data structure using the given array of strings as the dictionary.
	// (You can assume each word in the dictionary contains only the uppercase letters A through Z.)
	public BoggleSolver(String[] dictionary) {
		for (int i = 0; i < dictionary.length; i++) {
			if (dictionary[i].length() >= 3 || dictionary[i].length() <= 4) {
				trie.put(dictionary[i], 1);
			}
			else if (dictionary[i].length() == 5) {
				trie.put(dictionary[i], 2);
			}
			else if (dictionary[i].length() == 6) {
				trie.put(dictionary[i], 3);
			}
			else if (dictionary[i].length() == 7) {
				trie.put(dictionary[i], 5);
			}
			else if(dictionary[i].length() >= 8) {
				trie.put(dictionary[i], 11);
			}
			else {
				trie.put(dictionary[i], 0);
			}
		}
	}

	// Returns the set of all valid words in the given Boggle board, as an Iterable.
	public Iterable<String> getAllValidWords(BoggleBoard board) {
		if (board == null) {
		 	throw new IllegalArgumentException("board is null");
		}
		return new Bag<String>();
	}

	// Returns the score of the given word if it is in the dictionary, zero otherwise.
	// (You can assume the word contains only the uppercase letters A through Z.)
	public int scoreOf(String word) {
		if (trie.contains(word) == false) {
			return 0;
		}
		else {
			return trie.get(word);
		}
	}
}
