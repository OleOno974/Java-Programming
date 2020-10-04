package shapes;

/** This class handles exception for the Triangle class */
public class TriangleException extends Exception {
	
	/**
	 * Constructor accepts a string for the message
	 * @param message A string representing the message
	 */
	public TriangleException(String message) {
		super(message);
	}
}
