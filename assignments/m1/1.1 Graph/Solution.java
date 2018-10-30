import java.util.Scanner;
/**
 * @author : saitejasedate.
 */
import java.util.Arrays;
/**
 * Class for solution.
 */
public class Solution {
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
        String type = scan.nextLine();
        switch (type) {
        case "List":
            GraphList lisObj = new GraphList(scan);
            System.out.println(lisObj);
            break;
        case "Matrix":
            GraphMatrix lisMat = new GraphMatrix(scan);
            lisMat.print();
            break;
        default :
            break;
        }
    }
}
