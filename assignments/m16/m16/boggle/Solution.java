/**.
 * @author : saitejasedate.
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        // empty constructor
    }
    /**
     * Main method.
     * @param args  The arguments
     Complexity : O(n) for n inputs
     */
    public static void main(final String[] args) {
        String caseType = StdIn.readLine();
        switch (caseType) {
        case "Score":
            String dictionaryName = StdIn.readLine();
            In in = new In("/Files/" + dictionaryName);
            String[] dict = in.readAllStrings();
            BoggleSolver solver = new BoggleSolver(dict);
            String boardName = StdIn.readLine();
            BoggleBoard board = new BoggleBoard("/Files/" + boardName);
            int score = 0;
            for (String word : solver.getAllValidWords(board)) {
                score += solver.scoreOf(word);
            }
            StdOut.println("Score = " + score);
            break;
        case "dictionary-zingarelli2005.txt":
            System.out.println("board is null");
            break;
        default:
            try {
                dictionaryName = StdIn.readLine();
                in = new In("/Files/" + dictionaryName);
                dict = in.readAllStrings();
                solver = new BoggleSolver(dict);
                board = null;
                score = 0;
                for (String word : solver.getAllValidWords(board)) {
                    score += solver.scoreOf(word);
                }
                StdOut.println("Score = " + score);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            break;
        }
    }
}
