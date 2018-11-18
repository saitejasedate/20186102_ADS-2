import java.util.ArrayList;
import java.util.HashMap;
/**.
BoggleSolver class for boggle
*/
public class BoggleSolver {
    /**.
    dict the trie dictionary
    */
    private Trie<Integer> dict;
    /**.
    board the boggleboard object
    */
    private BoggleBoard board;
    /**.
    map the hashmap for storng the key
    */
    private HashMap<String, Integer> map;
    /**.
    list for storing the final list of keys
    */
    private ArrayList<String> list;
    /**.
    @param dictionary the string
    Complexity is O(l) l is length of dictionary
    */
    public BoggleSolver(String[] dictionary) {
        dict = new Trie<>();
        for (int i = 0; i < dictionary.length; i++) {
            dict.put(dictionary[i], getScore(dictionary[i]));
        }
    }
    /**.
    @return the return for final list
    @param board the bogglebpard object
    Compelxity O(r*c) r:no: of rows, c: no: of cols
    */
    public Iterable<String> getAllValidWords(BoggleBoard board) {
        this.board = board;
        this.map = new HashMap<>();
        this.list = new ArrayList<>();
        boolean[][] marked = new boolean[board.rows()][board.cols()];
        for (int i = 0; i < board.rows(); i++) {
            for (int j = 0; j < board.cols(); j++) {
                verifyword(marked, "", i, j, 0);
            }
        }
        return list;
    }
    /**.
    @param array the boolean array for running dfs
    @param prefix the prefix of the string
    @param i the row number
    @param j the column number
    @param count the number of chars in the string
    Complexity O(1) : functional called for every cell once,
    steps are executed for that cell, no loops.
    */
    private void verifyword(boolean[][] array, String prefix,
                            int i,
                            int j,
                            int count) {
        char c = board.getLetter(i, j);
        if (c == 'Q') {
            prefix += "QU";
            count += 2;
        } else {
            prefix += c;
            count += 1;
        }
        array[i][j] = true;
        boolean temp = false;
        if (dict.contains(prefix)) {
            temp = true;
            if (count >= 3 && !map.containsKey(prefix)) {
                map.put(prefix, getScore(prefix));
                list.add(prefix);
            }
        }
        if (temp || dict.hasKey(prefix)) {
            if (j - 1 >= 0 && !array[i][j - 1])
                verifyword(array, prefix, i, j - 1, count);
            if (j + 1 < board.cols() && !array[i][j + 1])
                verifyword(array, prefix, i, j + 1, count);
            if (i - 1 >= 0) {
                if (j - 1 >= 0 && !array[i - 1][j - 1])
                    verifyword(array, prefix, i - 1, j - 1, count);
                if (!array[i - 1][j])
                    verifyword(array, prefix, i - 1, j, count);
                if (j + 1 < board.cols() && !array[i - 1][j + 1])
                    verifyword(array, prefix, i - 1, j + 1, count);
            }
            if (i + 1 < board.rows()) {
                if (j - 1 >= 0 && !array[i + 1][j - 1])
                    verifyword(array, prefix, i + 1, j - 1, count);
                if (!array[i + 1][j])
                    verifyword(array, prefix, i + 1, j, count);
                if (j + 1 < board.cols() && !array[i + 1][j + 1])
                    verifyword(array, prefix, i + 1, j + 1, count);
            }
        }
        array[i][j] = false;
    }
    /**.
    @param word the wrod for scoring
    Complexity O(1) : score the word appropriately and return
    @return the return for word score
    */
    private int getScore(String word) {
        if (word.length() <= 2)
            return 0;
        if (word.length() == 3 || word.length() == 4)
            return 1;
        else if (word.length() == 5)
            return 2;
        else if (word.length() == 6)
            return 3;
        else if (word.length() == 7)
            return 5;
        else
            return 11;
    }
    /**.
    @param word the word for scoring
    @return the return for final score
    Complexity O(1) : finds the score and returns
    */
    public int scoreOf(String word) {
        if (dict.contains(word))
            return dict.get(word);
        return 0;
    }
}
