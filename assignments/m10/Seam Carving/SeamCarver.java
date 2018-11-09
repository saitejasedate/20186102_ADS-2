import java.awt.Color;
public class SeamCarver {
	// create a seam carver object based on the given picture
	private Picture picture;
	/*private double[][] array;
	double height;
	double width;*/
	public SeamCarver(Picture picture1) {
		if (picture1 == null) {
			throw new IllegalArgumentException("picture is null");
		}
		this.picture = picture1;
	}
	// current picture
	public Picture picture() {
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
		if (x == 0 || y == 0 || x == picture.width() - 1 ||
		 y == picture.height() - 1 ) {
			return 1000;
		} else {
			Color left = picture.get(x, y - 1);
			Color right = picture.get(x, y + 1);
			Color top = picture.get(x - 1, y);
			Color bottom = picture.get(x + 1, y);
			int redh = bottom.getRed() - top.getRed();
			int blueh = bottom.getBlue() - top.getBlue();
			int greenh = bottom.getGreen() - top.getGreen();
			double horizontal = redh * redh  + blueh * blueh  + greenh * greenh ;
			int redv = left.getRed() - right.getRed();
            int bluev = left.getBlue() - right.getBlue();
            int greenv = left.getGreen() - right.getGreen();
            int vertical = redv * redv  + bluev * bluev  + greenv * greenv ;
            double energies = Math.sqrt(horizontal + vertical);
            return energies; 
		}
	} 

	// public void calculateEnergy() {
	// 	for (int i = 0; i < picture.width(); i++) {
	// 		for (int j = 0; j < picture.height(); j++) {
	// 			array[i][j] = energy(i, j);
	// 		}
	// 	}
	// }

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