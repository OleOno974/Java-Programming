package shapes;

import java.text.DecimalFormat;

/** This class creates a shape of type square */
public class Square extends Rectangle {
	
	/**
	 * Constructor accepts a double for the length
	 * @param width A positive double representing the length of the square
	 * @throws SquareException Throws a message if data is not valid
	 */
	public Square(double width) throws ParallelogramException {
		super(width, width);
	}
	

	// Need to do the setters
	// Dont need override calculate perimeter

	// !!! Need to do the setters
	// !!! Dont need override calculate perimeter

	
	/**
	 * Calculate the perimeter of the square
	 * @return a double indicating the perimeter of the square
	 */
	@Override
	public double calculatePerimeter() {
		// Square perimeter = 4.s
		return 4 * getWidth();
	}
	
	/**
	 * Returning a string representing the square
	 * @return a string representing the square
	 */
	@Override
	public String toString() {
		return getClass().getSimpleName() + " {s=" + getWidth() + "} perimeter = " + new DecimalFormat("0.00000").format(calculatePerimeter());
	}
}
