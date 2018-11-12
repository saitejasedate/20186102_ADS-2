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
        Scanner sc = new Scanner(System.in);
        Quick3string quick3way = new Quick3string();
        int numOfStrings = sc.nextInt();
        sc.nextLine();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < numOfStrings; i++) {
        	sb.append(sc.nextLine() + "::");
        }
        // sort the strings
        String[] lines = sb.toString().split("::");
        quick3way.sort(lines);

        // print the results
        String str = "[";
        for (int i = 0; i < numOfStrings; i++) {
        	// String str = "[";
        	str += lines[i] + ", ";
        }
        System.out.println(str.substring(0, str.length() - 2) + "]");
    }
}