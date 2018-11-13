/**
 * @author : saitejasedate.
 * import java Scanner class.
 */
import java.util.Scanner;
/**
 * Solution class.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        /**
         * Empty constructor.
         */
    }
    /**
     * main function to take inputs and call the functions.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        String[] words = loadWords();
        //Your code goes here...
        // System.out.println(Arrays.toString(words));
        TST tst = new TST();
        Scanner sc = new Scanner(System.in);
        String inp = sc.nextLine();
        for (int i = 0; i < words.length; i++) {
            String[] tokens = new String[words[i].length()];
            for (int j = 0; j < words[i].length(); j++) {
                tokens[j] = words[i].substring(j, 
                    words[i].length());
                tst.put(tokens[j], 0);
            }
        }
        System.out.println(tst.keysWithPrefix(inp));
    }
    /**
     * Loads words.
     *
     * @return     { description_of_the_return_value }
     */
    public static String[] loadWords() {
        In in = new In("/Files/dictionary-algs4.txt");
        String[] words = in.readAllStrings();
        return words;
    }
}



