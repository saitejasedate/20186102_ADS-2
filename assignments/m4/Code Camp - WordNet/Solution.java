/**
 * @author : saitejasedate.
 */
import java.util.Scanner;
/**
 * Class for solution.
 */
class Solution {
    /**
     * Constructs the object.
     */
    protected Solution() {

    }
    /**
     * main method.
     *Time Complexity : O(V).
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        String synset = sc.nextLine();
        String hypernyms = sc.nextLine();
        try {
            WordNet w = new WordNet(synset, hypernyms);
            String inputType = sc.nextLine();
            if (w.gethasCycle()) {
                System.out.println("Cycle detected");
                return;
            }

            if (inputType.equals("Graph")) {
                w.checkMultipleRoots();
                if (w.gethasMultipleRoots()) {
                    return;
                } else {

                    System.out.println(w.getDigraph());
                }
            }
            if (inputType.equals("Queries")) {
                while (sc.hasNextLine()) {
                    String[] tokens = sc.nextLine().split(" ");
                    try {
                        w.sap(tokens[0], tokens[1]);
                        System.out.println("distance = "
                         + w.distance(tokens[0], tokens[1])
                          + ", ancestor = " + w.sap(tokens[0], tokens[1]));

                    } catch (Exception e) {
                        System.out.println("IllegalArgumentException");
                    }
                }

            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}


