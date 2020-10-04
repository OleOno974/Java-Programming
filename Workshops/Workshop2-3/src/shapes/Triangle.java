package shapes;

import java.text.DecimalFormat;

/** This class creates a shape of type square */
public class Triangle implements Shape {
	
	/** triangle's sides */
	private double sideOne;
	private double sideTwo;
	private double sideThree;
	
	/**
	 * Constructor accepts three double for each side
	 * @param sideOne A positive double for side one
	 * @param sideTwo A positive double for side two
	 * @param sideThree A positive double for side three
	 * @throws TriangleException Throws a message if data is no valid
	 */
	public Triangle(double sideOne, double sideTwo, double sideThree) throws TriangleException {
		if (sideOne < (sideTwo + sideThree) && sideTwo < (sideOne + sideThree) && sideThree < (sideOne + sideTwo)) {
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		} else {
			throw new TriangleException("Invalid side(s)!");
		}
	}
	
	// Setters
	public void setSideOne(double sideOne, double sideTwo, double sideThree) throws TriangleException {
		if (sideOne < (sideTwo + sideThree)) {
			this.sideOne = sideOne;
		} else {
			throw new TriangleException("Side one is invalid!");
		}
	}
	
	public void setSideTwo(double sideOne, double sideTwo, double sideThree) throws TriangleException {
		if (sideTwo < (sideOne + sideThree)) {
			this.sideTwo = sideTwo;
		} else {
			throw new TriangleException("Side two is invalid!");
		}
	}
	
	public void setSideThree(double sideOne, double sideTwo, double sideThree) throws TriangleException {
		if (sideThree < (sideOne + sideTwo)) {
			this.sideThree = sideThree;
		} else {
			throw new TriangleException("Side three is invalid!");
		}
	}
	
	
	// Getters
	public double getSideOne() {
		return sideOne;
	}
	
	public double getSideTwo() {
		return sideTwo;
	}
	
	public double getSideThree() {
		return sideThree;
	}
	
	/**
	 * Calculate the perimeter of the triangle
	 * @return a double indicating the perimeter of the triangle
	 */
	@Override
	public double calculatePerimeter() {
		// Triangle perimeter = a+b+c
		return sideOne + sideTwo + sideThree;
	}
	
	/**
	 * Returning a string representing the triangle
	 * @return a string representing the triangle
	 */
	@Override
	public String toString() {
		return getClass().getSimpleName() + " {s1=" + getSideOne() + ", s2=" + getSideTwo() + ", s3=" + getSideThree() + "} perimeter = " + new DecimalFormat("0.00000").format(calculatePerimeter());
	}
}
