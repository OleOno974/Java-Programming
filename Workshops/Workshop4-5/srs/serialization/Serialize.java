package object.serialization;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;

/** A console log based class that serializes and writes students objects in a file */
public class Serialize extends Student {
	
	// Main
	public static void main(String[] args) throws IOException {
		
		// Create Student objects
		Student student1 = new Student();
		
		
		// Using Console to input data from user 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		// ID
		System.out.print("Enter Student ID: ");
		int stdid1 = Integer.parseInt(in.readLine());
		student1.setStdID(stdid1);
		
		// First Name
		System.out.print("Enter Student First Name: ");
		String firstName1 = in.readLine();
		student1.setFirstName(firstName1);
		
		// Last Name
		System.out.print("Enter Student Last Name: ");
		String lastName1 = in.readLine();
		student1.setLastName(lastName1);
		
		// Courses
		System.out.print("Enter Student Courses (separeted by coma \",\"): ");
		String coursesInput = in.readLine();
		String[] temp = coursesInput.split(",");
		for (int i = 0; i < temp.length; i++) {
			student1.setCourses(temp[i]);
		}
		
		// Write object to file
		File f = new File("objectOutput.bin");
		FileOutputStream fos = new FileOutputStream(f);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(student1);
		
		oos.flush();
		fos.close();
		
		System.out.println("Object saved into file " + f.getName());
		
	}
	
}
