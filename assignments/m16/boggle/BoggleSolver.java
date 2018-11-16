public class BoggleSolver {
	TrieST<Integer> trie = new TrieST<Integer>();
	boolean[][] visited;
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

	private  void findWords(BoggleBoard board, int i, int j,
	                        Queue queue, String sb) {
		if (isValid(sb)) {
			queue.enqueue(sb);
		}
		int rows = board.rows();
		int cols = board.cols();
		visited[i][j] = true;
		for (int row = i - 1; row <= i + 1 && row < rows; row++) {
			for (int col = j - 1; col <= j + 1 && col < cols; col++ ) {
				if (row >= 0 && col >= 0 && !visited[row][col]) {
					String sb1 = appendChar(sb, board.getLetter(row, col));
					findWords(board, row, col, queue, sb1);
				}

			}
		}
		visited[i][j] = false;
	}

	public String appendChar(String s, char c) {
		if (c == 'Q') {
			return s+"QU";
		}
		return s+c;
	}

	private boolean isValid(String key) {
		if (key.length() <= 2) {
			return false;
		}
		return trie.contains(key);
	}

	// Returns the set of all valid words in the given Boggle board, as an Iterable.
	public Iterable<String> getAllValidWords(BoggleBoard board) {
		if (board == null) {
		 	System.out.println("board is null");
		}
		Queue<String> queue = new Queue<>();
		visited = new boolean[board.rows()][board.cols()];
		for (int row = 0; row < board.rows() ; row++ ) {
			for (int col = 0; col < board.cols() ; col++ ) {
				String s = appendChar("", board.getLetter(row, col));
				findWords(board, row, col, queue, s);
			}
		}
		return queue;
	}
	// Returns the score of the given word if it is in the dictionary, zero otherwise.
	// (You can assume the word contains only the uppercase letters A through Z.)
	public int scoreOf(String word) {
		if (trie.contains(word) == true) {
			return trie.get(word);
		}
		return 0;
	}
}
