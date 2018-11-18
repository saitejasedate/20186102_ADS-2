import java.awt.Color;
/**
 * Class for seam carver.
 */
public class SeamCarver {
    /**
     *the picture object.
     */
    private Picture picture;
    /**
     *the width of image.
     */
    private int width;
    /**
     *the height of pixel.
     */
    private int height;
    /**
     * { var_description }.
     */
    private static final double THOU = 1000.0;
    /**
     *the constructor to initialize.
     *
     * @param      pic   The picture
     */
    public SeamCarver(final Picture pic) {
        this.picture = pic;
        width = picture.width();
        height = picture.height();
    }
    /**
     *the method will return the picture.
     *object.
     * @return picture object.
     */
    public Picture picture() {
        return picture;
    }
    /**
     *this method will return the width.
     *of image.
     * @return width of pixel
     */
    public int width() {
        return width;
    }
    /**
     *height of current picture.
     *
     * @return height of image.
     */
    public int height() {
        return height;
    }
    /**
     *energy of pixel at column x and row y.
     *
     * @param      x  x coordinate
     * @param      y   y coordinate
     *
     * @return energy of pixel.
     */
    public double energy(final int x, final int y) {
        //handle exceptions
        final double num = 1000.0;
        if (x == 0 || y == 0 || y == (height - 1) || x == (width - 1)) {
            return num;
        }
        double xCoordinate = 0.0;
        double yCoordinate = 0.0;
        Color object = picture.get(x, y);
        Color leftObj = picture.get(x, y - 1);
        Color rightObj = picture.get(x, y + 1);
        double xRed = Math.abs((leftObj.getRed() - rightObj.getRed()));
        double xGreen = Math.abs((leftObj.getGreen() - rightObj.getGreen()));
        double xBlue = Math.abs((leftObj.getBlue() - rightObj.getBlue()));
        xCoordinate = Math.pow(xRed, 2) + Math.pow(xBlue, 2)
                      + Math.pow(xGreen, 2);
        Color topObj = picture.get(x - 1, y);
        Color bottomObj = picture.get(x + 1, y);
        double yRed = Math.abs((topObj.getRed() - bottomObj.getRed()));
        double yGreen = Math.abs((topObj.getGreen() - bottomObj.getGreen()));
        double yBlue = Math.abs((topObj.getBlue() - bottomObj.getBlue()));
        yCoordinate = Math.pow(yRed, 2) + Math.pow(yBlue, 2)
                      + Math.pow(yGreen, 2);
        double sum = Math.sqrt((xCoordinate + yCoordinate));
        return sum;
    }
    /**sequence of indices for horizontal seam.
     *
     *time complexity is O(w*h)
     *w is the width and h is the height
     * @return  sequence of indices of horizontal seam
     */
    public int[] findHorizontalSeam() {
        final int n = 1000;
        int[][] edgeTo = new int[height][width];
        double[][] distTo = new double[height][width];
        reset(distTo);
        for (int row = 0; row < height; row++) {
            distTo[row][0] = n;
        }
        // this is for relaxation.
        for (int col = 0; col < width - 1; col++) {
            for (int row = 0; row < height; row++) {
                relaxH(row, col, edgeTo, distTo);
            }
        }
        double minDist = Double.MAX_VALUE;
        int minRow = 0;
        for (int row = 0; row < height; row++) {
            if (minDist > distTo[row][width - 1]) {
                minDist = distTo[row][width - 1];
                minRow = row;
            }
        }
        int[] indices = new int[width];
        //to find the horizontal seam.
        for (int col = width - 1, row = minRow; col >= 0; col--) {
            indices[col] = row;
            row -= edgeTo[row][col];
        }
        return indices;
    }
    /**
     * { function_description }.
     *
     * @param      row     The row
     * @param      col     The col
     * @param      edgeTo  The edge to
     * @param      distTo  The distance to
     */
    private void relaxH(final int row, final int col,
                        final int[][] edgeTo, final double[][] distTo) {
        int nextCol = col + 1;
        for (int i = -1; i <= 1; i++) {
            int nextRow = row + i;
            if (nextRow < 0 || nextRow >= height) {
                continue;
            }
            if (i == 0) {
                if (distTo[nextRow][nextCol] >= distTo[row][col]
                        + energy(nextCol, nextRow)) {
                    distTo[nextRow][nextCol] = distTo[row][col]
                                               + energy(nextCol, nextRow);
                    edgeTo[nextRow][nextCol] = i;
                }
            }
            if (distTo[nextRow][nextCol] > distTo[row][col]
                    + energy(nextCol, nextRow)) {
                distTo[nextRow][nextCol] = distTo[row][col]
                                           + energy(nextCol, nextRow);
                edgeTo[nextRow][nextCol] = i;
            }
        }
    }
    /**
     *this method is to find the vertical seam.
     *first of all find the shortest path from top to.
     *bottom.
     *time complexity is O(w*h)
     *w is the width and h is the height
     * @return sequence of indices for vertical seam.
     */
    public int[] findVerticalSeam() {
        double[][] energy = new double[height][width];
        int[][] edgeTo = new int[height][width];
        double[][] distTo = new double[height][width];
        reset(distTo);
        int[] indices = new int[height];
        if (width == 1 || height == 1) {
            return indices;
        }
        for (int i = 0; i < width; i++) {
            distTo[0][i] = THOU;
        }
        // this is for relaxation.
        for (int i = 0; i < height - 1; i++) {
            for (int j = 0; j < width; j++) {
                relaxV(i, j, edgeTo, distTo);
            }
        }
        // calculating from last row
        // column wise
        double minDist = Double.MAX_VALUE;
        int minCol = 0;
        for (int col = 0; col < width; col++) {
            if (minDist > distTo[height - 1][col]) {
                minDist = distTo[height - 1][col];
                minCol = col;
            }
        }
        /**
        * indices values of shortest path.
        */
        for (int row = height - 1, col = minCol; row >= 0; row--) {
            indices[row] = col;
            col -= edgeTo[row][col];
        }
        indices[0] = indices[1];
        return indices;
    }
    /**
     * time complexity is O(W * H) W is the width of image H is the height of.
     * image
     *
     * @param      distTo  The distance to.
     */
    private void reset(final double[][] distTo) {
        /**
         *reset all the values to maxvalue.
         */
        for (int i = 0; i < distTo.length; i++) {
            for (int j = 0; j < distTo[i].length; j++) {
                distTo[i][j] = Double.MAX_VALUE;
            }
        }
    }
    /**
     * { function_description }.
     *
     * @param      row     The row
     * @param      col     The col
     * @param      edgeTo  The edge to
     * @param      distTo  The distance to
     */
    private void relaxV(final int row, final int col, final int[][] edgeTo,
                        final double[][] distTo) {
        int nextRow = row + 1;
        for (int i = -1; i <= 1; i++) {
            int nextCol = col + i;
            if (nextCol < 0 || nextCol >= width) {
                continue;
            }
            //spl case for bottom element.
            if (i == 0) {
                if (distTo[nextRow][nextCol] >= distTo[row][col]
                        + energy(nextCol, nextRow)) {
                    distTo[nextRow][nextCol] = distTo[row][col]
                                               + energy(nextCol, nextRow);
                    edgeTo[nextRow][nextCol] = i;
                }
            }
            if (distTo[nextRow][nextCol] > distTo[row][col]
                    + energy(nextCol, nextRow)) {
                distTo[nextRow][nextCol] = distTo[row][col]
                                           + energy(nextCol, nextRow);
                edgeTo[nextRow][nextCol] = i;
            }
        }
    }

    /**
     * Removes a horizontal seam.
     *
     * @param      seam  The seam
     */
    public void removeHorizontalSeam(final int[] seam) {
        //handle exceptions
        for (int col = 0; col < width; col++) {
            for (int row = seam[col]; row < height - 1; row++) {
                this.picture.set(col, row, this.picture.get(col, row + 1));
            }
        }
        height--;
    }

    /**
     * Removes a vertical seam.
     *
     * @param      seam  The seam
     */
    public void removeVerticalSeam(final int[] seam) {
        for (int row = 0; row < height; row++) {
            for (int col = seam[row]; col < width - 1; col++) {
                this.picture.set(col, row, this.picture.get(col + 1, row));
            }
        }
        width--;
    }
}


