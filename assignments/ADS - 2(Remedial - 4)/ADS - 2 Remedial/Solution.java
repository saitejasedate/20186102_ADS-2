import java.util.Scanner;
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
		int c = 0;
		String s = "";
		for (int j = 0; j < numOfpersons; j++) {
			if (dg.outdegree(j) == 1) {
				s += j+" ";
				c++;
			}
		}
		if(c == numOfpersons) {
			System.out.println(s);
		} else {
			System.out.println("No Self Beneficiaries.");
		}
	}
}