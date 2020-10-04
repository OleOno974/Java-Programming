package shapes;

import java.text.DecimalFormat;

/** This class creates a shape of type parallelogram */
public class Parallelogram implements Shape {
	
	/** parallelogram's width and height */
	private double width;
	private double height;
	
	/**
	 * Constructor accepts tow double for width and height
	 * @param width A positive double representing the width of the parallelogram
	 * @param height A positive double representing the height of the parallelogram
	 * @throws ParallelogramException Throws a message if data is not valid
	 */
	Parallelogram(double width, double height) throws ParallelogramException {
		if (width > 0 && height > 0) {
			this.width = width;
			this.height = height;
		} else {
			throw new ParallelogramException("Invalid side(s)!");
		}
	}
	
	// Setters
	public void setWidth(double width) throws ParallelogramException {
		if (width > 0) {
			this.width = width;
		} else {
			throw new ParallelogramException("Invalid width!");
		}
	}
	
	public void setHeight(double height) throws ParallelogramException {
		if (height > 0) {
			this.height = height;
		} else {
			throw new ParallelogramException("Invalid height!");
		}
	}
	
	// Getters
	public double getWidth() {
		return width;
	}
	
	public double getHeight() {
		return height;
	}
	
	/**
	 * Calculate the perimeter of the parallelogram
	 * @return a double indicating the perimeter of the parallelogram
	 */
	@Override
	public double calculatePerimeter() {
		// Parallelogram perimeter = 2.w + 2.h
		return 2 * width + 2 * height;
	}
	
	/**
	 * Returning a string representing the parallelogram
	 * @return a string representing the parallelogram
	 */
	@Override
	public String toString() {
		return getClass().getSimpleName() + " {w=" + getWidth() + ", h=" + getHeight() + "} perimeter = " + new DecimalFormat("0.00000").format(calculatePerimeter());
	}

}
