/**
 * @author : saitejasedate.
 * import java Scanner class.
 */
import java.util.*;
/**
 * Class for solution.
 */
public class Solution {
	/**
	 * Constructs the object.
	 */
	private Solution() {
		/**
		 * Empty Comstructor,
		 */
	}
	/**
     * Reads in a sequence of fixed-length strings from standard input;
     * 3-way radix quicksorts them;
     * and prints them to standard output in ascending order.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {

        // read in the strings from standard input
        Quick3string quick3way = new Quick3string();
        String[] a = StdIn.readAllStrings();
        int n = a.length;

        // sort the strings
        quick3way.sort(a);

        // print the results
        for (int i = 0; i < n; i++)
            StdOut.println(a[i]);
    }
}