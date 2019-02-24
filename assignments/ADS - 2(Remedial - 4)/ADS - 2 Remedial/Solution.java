import java.util.*;
class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numOfpersons = Integer.parseInt(sc.nextLine());
		int numOfbeneficiaries = Integer.parseInt(sc.nextLine());
		Digraph dg = new Digraph(numOfpersons);
		for (int i = 0; i < numOfbeneficiaries; i++) {
			String[] str = sc.nextLine().split(" ");
			dg.cGraph(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
		}
		// System.out.println(dg);
		DirectedCycle dc = new DirectedCycle(dg);
		// // System.out.println(dc.cycle());
		// if (dc.cycle() == null) {
		// 	System.out.println("No Self Beneficiaries.");
		// } else {
		// 	System.out.println(dc.cycle());
		// }
		for (Stack<Integer> s: dc.lists) {
            TreeSet<Integer> treeset = new TreeSet<Integer>();
            for (Integer i : s) {
                treeset.add(i);
            }
            System.out.println(treeset.toString().replace("[","").replace("]",""));
        }
	}
}