/**
 * @author : saitejasedate.
 * import java util Scanner class.
 */
import java.util.HashMap;
import java.util.Scanner;
/**
 * Class for solution.
 */
public class Solution {
	/**
	 * Constructs the object.
	 */
	private Solution() {
		/**
		 * Empty constructor.
		 */
	}
	/**
	 * main function.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		Scanner scan = new Scanner(System.in);
		String cases = scan.nextLine();
		switch (cases) {
		case "loadDictionary":
			// input000.txt and output000.txt
			BinarySearchST<String, Integer> hash = loadDictionary("/Files/t9.csv");
			while (scan.hasNextLine()) {
				String key = scan.nextLine();
				System.out.println(hash.get(key));
			}
			break;

		case "getAllPrefixes":
			// input001.txt and output001.txt
			T9 t9 = new T9(loadDictionary("/Files/t9.csv"));
			while (scan.hasNextLine()) {
				String prefix = scan.nextLine();
				for (String each : t9.getAllWords(prefix)) {
					System.out.println(each);
				}
			}
			break;

		case "potentialWords":
			// input002.txt and output002.txt
			t9 = new T9(loadDictionary("/Files/t9.csv"));
			int count = 0;
			while (scan.hasNextLine()) {
				String t9Signature = scan.nextLine();
				for (String each : t9.potentialWords(t9Signature)) {
					count++;
					System.out.println(each);
				}
			}
			if (count == 0) {
				System.out.println("No valid words found.");
			}
			break;

		case "topK":
			// input003.txt and output003.txt
			t9 = new T9(loadDictionary("/Files/t9.csv"));
			Bag<String> bag = new Bag<String>();
			int k = Integer.parseInt(scan.nextLine());
			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				bag.add(line);
			}
			for (String each : t9.getSuggestions(bag, k)) {
				System.out.println(each);
			}

			break;

		case "t9Signature":
			// input004.txt and output004.txt
			t9 = new T9(loadDictionary("/Files/t9.csv"));
			bag = new Bag<String>();
			k = Integer.parseInt(scan.nextLine());
			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				for (String each : t9.t9(line, k)) {
					System.out.println(each);
				}
			}
			break;

		default:
			break;

		}
	}

	// Don't modify this method.
	public static String[] toReadFile(final String file) {
		In in = new In(file);
		return in.readAllStrings();
	}

	public static BinarySearchST<String, Integer> loadDictionary(final String file) {
		BinarySearchST<String, Integer>  st = new BinarySearchST<String, Integer>();
		// your code goes here
		String[] dictionary = toReadFile(file);
		int length = dictionary.length;
		for (int i = 0; i < length; i++) {
			String word = dictionary[i].toLowerCase();
			if (st.contains(word)) {
				st.put(word, st.get(word) + 1);
			} else {
				st.put(word, 1);
			}
		}
		return st;
	}

}

class T9 {

	TST tst = new TST();
	public T9(BinarySearchST<String, Integer> st) {
		// your code goes here
		for (String str : st.keys()) {
			tst.put(str, st.get(str));
		}
	}

	// get all the prefixes that match with given prefix.
	public Iterable<String> getAllWords(final String prefix) {
		// your code goes here
		return tst.keysWithPrefix(prefix);
	}

	public Iterable<String> potentialWords(final String t9Signature) {
		// your code goes here
		HashMap<Integer, String> hmp = new HashMap<Integer, String>();
		hmp.put(1,null);
		hmp.put(2,"abc");
		hmp.put(3,"def");
		hmp.put(4,"ghi");
		hmp.put(5,"jkl");
		hmp.put(6,"mno");
		hmp.put(7,"pqrs");
		hmp.put(8,"tuv");
		hmp.put(9,"wxyz");
		for (int i = 0; i < t9Signature.length(); i++) {
			String[] tokens = t9Signature.split("");
		}
		return null;
	}

	// return all possibilities(words), find top k with highest frequency.
	public Iterable<String> getSuggestions(final Iterable<String> words, final int k) {
		// your code goes here
		return null;
	}

	// final output
	// Don't modify this method.
	public Iterable<String> t9(final String t9Signature, final int k) {
		return getSuggestions(potentialWords(t9Signature), k);
	}
}
