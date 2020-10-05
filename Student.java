package object.serialization;

import java.io.Serializable;
import java.util.ArrayList;

/** This class creates objects of type student */
public class Student implements Serializable {
	
	/** class fields */
	private int stdID;
	private String firstName;
	private String lastName;
	private ArrayList<String> courses = new ArrayList<String>();
	
	/**
	 * Default constructor
	 */
	public Student() {
		
	}
	
	/**
	 * Constructor accepts 4 arguments
	 * @param stdID An integer representing student id
	 * @param firstName A string representing student first name
	 * @param lastName A string representing student last name
	 * @param courses An array list representing student's course
	 */
	public Student(int stdID, String firstName, String lastName, ArrayList<String> courses) {
		this.stdID = stdID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.courses = courses;
	}
	
	// Setters
	public void setStdID(int stdID) {
		this.stdID = stdID;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setCourses(String courses) {
		this.courses.add(courses);
	}
	
	// Getters
	public int getStdID() {
		return stdID;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public ArrayList<String> getCourses() {
		return courses;
	}	
	
}
