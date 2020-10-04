package shapes;

import java.text.DecimalFormat;

/** This class creates a shape of type circle */
public class Circle implements Shape {
	
	/** circle's radius */
	private double radius;
	
	/**
	 * Constructor accepts a double for the radius
	 * @param radius A positive double representing the radius of the circle
	 * @throws CircleException Throws a message if data is not valid
	 */
	public Circle(double radius) throws CircleException {
		if (radius > 0) {
			this.radius = radius;			
		} else {
			throw new CircleException("Invalid radius!");
		}
	}
	
	// Setters
	public void setRadius(double radius) throws CircleException {
		if (radius > 0) {
			this.radius = radius;
		} else {
			throw new CircleException("Invalid radius!");
		}
	}
	
	// Getters
	public double getRadius() {
		return radius;
	}
	
	/**
	 * Calculate the perimeter of the circle
	 * @return a double indicating the perimeter of the circle
	 */
	@Override
	public double calculatePerimeter() {
		// Circle perimeter = 2.r.PI
		return 2 * radius * Math.PI;
	}
	
	/**
	 * Returning a string representing the circle
	 * @return a string representing the circle
	 */
	@Override
	public String toString() {
		return getClass().getSimpleName() + " {r=" + getRadius() + "} perimeter = " + new DecimalFormat("0.00000").format(calculatePerimeter());
	}

}
