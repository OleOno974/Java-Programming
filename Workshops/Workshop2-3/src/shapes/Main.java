package shapes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/** This class is used to read from file, create logic, and run the program */
public class Main {

	/**
	 * Main
	 * @param args
	 * @throws ParallelogramException Throw a message if input data is invalid
	 */
	public static void main(String[] args) throws ParallelogramException {

		/** Data structure to hold created shapes */
		Shape shapes[] = new Shape[50];
		int count = 0;
		
		/**
		 * Task 1: Read the file Shapes.txt, create the shapes and store them in
		 * your data structure. Then print the number of shapes you created,
		 * and finally, print all the shapes and their calculated perimeters polymorphically.
		 */
		System.out.println("------->JAC 444 Assignment 2 & 3<-------");
		System.out.println("------->Task 1 ... <-------");

		/**
		 * Method that reads a file line by line
		 */
		try (BufferedReader br = new BufferedReader(new FileReader("shapes.txt"))) {
			
			// String that holds current line
			String s;
			while ((s = br.readLine()) != null) {
				
				// Array that split current line
				String[] tokens = s.split(",");

				/**
				 * If Circle
				 * Validates input and calls circle's constructor
				 */
				if (tokens[0].equals("Circle") && tokens.length == 2) {
					try {
						shapes[count] = new Circle(Double.parseDouble(tokens[1]));
						count++;
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
				
				/**
				 * If Triangle
				 * Validates input and calls triangle's constructor
				 */
				else if (tokens[0].equals("Triangle") && tokens.length == 4) {
					try {
						shapes[count] = new Triangle(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]));
						count++;
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
				
				/**
				 * If Square
				 * Validates input and calls square's constructor
				 */
				else if (tokens[0].equals("Square") && tokens.length == 2) {
					try {
						shapes[count] = new Square(Double.parseDouble(tokens[1]));
						count++;
					} catch (Exception e) {
						System.out.println("Invalid side!");
					}
				}
				
				/**
				 * If Parallelogram
				 * Validates input and calls parallelogram's constructor
				 */
				else if (tokens[0].equals("Parallelogram") && tokens.length == 3) {
					try {
						shapes[count] = new Parallelogram(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]));
						count++;
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
				
				/**
				 * If Rectangle
				 * Validates input and calls rectangle's constructor
				 */
				else if (tokens[0].equals("Rectangle") && tokens.length == 3) {
					try {
						shapes[count] = new Rectangle(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]));
						count++;
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		/**
		 * Task 1 output
		 */
		System.out.println();
		System.out.println(count + " shapes were created:");
		for (int i = 0; i < count; i++) {
			System.out.println(shapes[i]);
			System.out.println();
		}
		
		/**
		 * Task 2: Delete the triangle with the minimum perimeter (there could be
		 * more than one minimum) and the circle with the maximum perimeter (there
		 * could be more than one maximum) from the shapes. Print the all the
		 * remaining shapes and their perimeters polymorphically.
		 */
		double smallestTriangle = 10^6;
		double largestCircle = 0;
		int resultCount = 0;
		
		// For loop that gets smallest and largest perimeters
		for (int i = 0; i < count; i++) {
			
			// Smallest triangle perimeter
			if (shapes[i].getClass().getSimpleName().contentEquals("Triangle")) {
				if (shapes[i].calculatePerimeter() < smallestTriangle) {
					smallestTriangle = shapes[i].calculatePerimeter();
				}
			}
			
			// Largest circle perimeter
			if (shapes[i].getClass().getSimpleName().contentEquals("Circle")) {
				if (shapes[i].calculatePerimeter() > largestCircle) {
					largestCircle = shapes[i].calculatePerimeter();
				}
			}
		}
		
		// For loop that counts now many items must be excluded
		for (int i = 0; i < count; i++) {
			if (shapes[i].getClass().getSimpleName().contentEquals("Triangle")) {
				if (shapes[i].calculatePerimeter() == smallestTriangle) {
					resultCount++;
				}
			}
			if (shapes[i].getClass().getSimpleName().contentEquals("Circle")) {
				if (shapes[i].calculatePerimeter() == largestCircle) {
					resultCount++;
				}
			}
		}
		
		// Creates a new array of shapes
		resultCount = count - resultCount;
		Shape resultShapes[] = new Shape[resultCount];
		int index = 0;
		
		// Does not copy into the new array if it is a smallest triangle perimeter
		// or if it is a largest circle perimeter
		for (int i = 0; i < count; i++) {
			if (shapes[i].getClass().getSimpleName().contentEquals("Triangle")) {
				if (shapes[i].calculatePerimeter() != smallestTriangle) {
					resultShapes[index] = shapes[i];
					index++;
				}
			} else if (shapes[i].getClass().getSimpleName().contentEquals("Circle")) {
				if (shapes[i].calculatePerimeter() != largestCircle) {
					resultShapes[index] = shapes[i];
					index++;
				}
			} else {
				resultShapes[index] = shapes[i];
				index++;
			}
		}
		
		/**
		 * Task 2 output
		 */
		System.out.println("------->Task 2 ... <-------");
		for (int i = 0; i < resultCount; i++) {
			System.out.println(resultShapes[i]);
			System.out.println();
		}
		
		/**
		 * Task 3: Calculate and print the total perimeter of all parallelograms
		 * and the total perimeter of all triangles.
		 * After changes on Task 2.
		 */
		double parallelogramTotalPerimeter = 0;
		double triangleTotalPerimeter = 0;
		
		// For loop that gets the total perimeter of the specified shapes
		for (int i = 0; i < resultCount; i ++) {
			
			// Triangle total perimeter
			if (resultShapes[i].getClass().getSimpleName().contentEquals("Triangle")) {
				triangleTotalPerimeter += resultShapes[i].calculatePerimeter();
			}
			
			// Parallelogram total perimeter
			if (resultShapes[i].getClass().getSimpleName().contentEquals("Parallelogram")) {
				parallelogramTotalPerimeter += resultShapes[i].calculatePerimeter();
			}
		}
		
		/**
		 * Task 3 output
		 */
		System.out.println("------->Task 3 ... <-------");
		System.out.println("Total perimeter of Parallelogram is: " + parallelogramTotalPerimeter);
		System.out.println("Total perimeter of Triangle is: " + triangleTotalPerimeter);
	}
}