import java.util.Scanner;
/**
 * @author : @saitejasedate.
 */
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //unused
    }
    /**
     * main method to read input.
     *
     * @param args String
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = Integer.parseInt(scan.nextLine());
        Percolation percolobj = new Percolation(size);
        while (scan.hasNext()) {
            String[] tokens = scan.nextLine().split(" ");
            percolobj.open(Integer.parseInt(tokens[0]) - 1,
                      Integer.parseInt(tokens[1]) - 1);
        }
        System.out.println(percolobj.percolates());
    }
}
