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
		if (dc.lists.isEmpty() == true) {
			System.out.println("No Self Beneficiaries.");
		}
		for (Stack<Integer> s: dc.lists) {
            // TreeSet<Integer> treeset = new TreeSet<Integer>();
            HashMap<Integer, Stack> hsp = new HashMap<Integer, Stack>();
            for (int j = 0; j < dc.lists.size(); j++) {
            	hsp.put(j, s);
            }
            // System.out.println(treeset.toString().replace("[","").replace("]",""));
            for (int k = 0; k < hsp.size(); k++) {
            	System.out.println(hsp.get(k));
            }
        }
	}
}