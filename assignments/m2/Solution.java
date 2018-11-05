/**
 * @author : saitejasedate.
 * import java Scanner class.
 */
import java.util.Scanner;
/**
 * Class for solution.
 */
class Solution {
	/**
	 * Constructs the object.
	 */
	private Solution() {
		/**
		 * { Empty constructor }
		 */
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = Integer.parseInt(sc.nextLine());
		sc.nextLine();
		Percolation obj = new Percolation(size);
		while (sc.hasNext()) {
			String[] tokens = sc.nextLine().split(" ");
			obj.open(Integer.parseInt(tokens[0])-1, 
				Integer.parseInt(tokens[1])-1);
		}
		System.out.println(obj.percolates());
	}
}