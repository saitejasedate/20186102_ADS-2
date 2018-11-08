public class SeamCarver {
	// create a seam carver object based on the given picture
	Picture picture;
	private double[][] array;
	double height;
	double width;
	public SeamCarver(Picture picture1) {
		this.picture = picture1;

	}
	// current picture
	public Picture picture() {
		if (this.picture == null) {
			throw new IllegalArgumentException("picture is null");
		}
		return picture;
	}
	// width of current picture
	public int width() {
		return picture.width();
	}

	// height of current picture
	public int height() {
		return picture.height();
	}

	// energy of pixel at column x and row y
	public double energy(int x, int y) {
		if (x == 0 || y == 0 || x == picture.height() - 1 ||
		 y == picture.width() - 1 ) {
		}
		return 1000;
	}

	// sequence of indices for horizontal seam
	public int[] findHorizontalSeam() {
		return new int[0];
	}

	// sequence of indices for vertical seam
	public int[] findVerticalSeam() {
		return new int[0];
	}

	// remove horizontal seam from current picture
	public void removeHorizontalSeam(int[] seam) {

	}

	// remove vertical seam from current picture
	public void removeVerticalSeam(int[] seam) {

	}
}