package shapes;

/** This class creates a shape of type rectangle */
public class Rectangle extends Parallelogram {
		
	/**
	 * Constructor accepts two double for width and height
	 * @param width A positive double representing the width of the rectangle
	 * @param height A positive double representing the height of the rectangle
	 * @throws ParallelogramException Throws a message if data is not valid
	 */
	public Rectangle(double width, double height) throws ParallelogramException {
		super(width, height);
	}

}
