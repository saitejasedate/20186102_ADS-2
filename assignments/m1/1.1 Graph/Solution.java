import java.util.Scanner;
/**
 * @author : saitejasedate.
 */
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
    }
    /**
     * main method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        String query = scan.nextLine();
        switch (query) {
        case "List":
            GraphList graphList = new GraphList(scan);
            System.out.println(graphList);
            break;
        case "Matrix":
            GraphMatrix graphMatrix = new GraphMatrix(scan);
            graphMatrix.toString();
            break;
        default :
            break;
        }
    }
}
