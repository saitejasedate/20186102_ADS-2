/**
 * @author : saitejasedate.
 */
import java.util.Scanner;
/**
 *client class.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //unused constructor.
    }
    /**
     * main method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertices = Integer.parseInt(sc.nextLine());
        int edges = Integer.parseInt(sc.nextLine());
        Digraph digraph = new Digraph(vertices);
        while (sc.hasNext()) {
            String[] input = sc.nextLine().split(" ");
            digraph.addEdge(Integer.parseInt(input[0]),
                            Integer.parseInt(input[1]));
        }
        DirectedCycle directedcycle = new DirectedCycle(digraph);
        System.out.println(directedcycle);
    }
}
