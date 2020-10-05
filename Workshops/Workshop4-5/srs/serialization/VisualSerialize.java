package object.serialization;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VisualSerialize extends Student {

	// Main
	public static void main(String[] args) throws IOException {
		
		// Create and setup JFrame
		JFrame frame = new JFrame("Serializing object into file");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		
		// Create a JPanel that holds input fields
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
		frame.add(inputPanel);
		
		// Create label and textfield for student ID
		JLabel studentIDLabel = new JLabel("Student ID: ");
		JTextField studentIDText = new JTextField(10);
		inputPanel.add(studentIDLabel);
		inputPanel.add(studentIDText);
		
		// Create label and textfield for student first name
		JLabel studentFirstNameLabel = new JLabel("Student First Name: ");
		JTextField studentFirstNameText = new JTextField(20);
		inputPanel.add(studentFirstNameLabel);
		inputPanel.add(studentFirstNameText);
		
		// Create label and textfield for student last name
		JLabel studentLastNameLabel = new JLabel("Student Last Name: ");
		JTextField studentLastNameText = new JTextField(20);
		inputPanel.add(studentLastNameLabel);
		inputPanel.add(studentLastNameText);
		
		// Create label and textfield for student courses
		JLabel studentCoursesLabel = new JLabel("Student Courses (separeted by coma \",\"): ");
		JTextField studentCoursesText = new JTextField(30);
		inputPanel.add(studentCoursesLabel);
		inputPanel.add(studentCoursesText);
		
		// Creates a button that submits input information
		JButton submitButton = new JButton("SUBMIT");
		inputPanel.add(submitButton);
		
		// Add Action Listener to the submit button
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					// Create Student object
					Student student = new Student();
					
					// Use text field to input data from user
					// ID
					int stdid = Integer.parseInt(studentIDText.getText());
					student.setStdID(stdid);
					
					// First name
					String firstName = studentFirstNameText.getText();
					student.setFirstName(firstName);
					
					// Last Name
					String lastName = studentLastNameText.getText();
					student.setLastName(lastName);
					
					// Courses
					String coursesInput = studentCoursesText.getText();
					String[] temp = coursesInput.split(",");
					for (int i = 0; i < temp.length; i++) {
						student.setCourses(temp[i]);
					}
					
					// Write object to file
					File f = new File("objectOutput.bin");
					FileOutputStream fos = new FileOutputStream(f);
					ObjectOutputStream oos = new ObjectOutputStream(fos);
					oos.writeObject(student);

					oos.flush();
					fos.close();
					
					// Create a JPanel for success submission
					JPanel submitedPanel = new JPanel();
					submitedPanel.setLayout(new BoxLayout(submitedPanel, BoxLayout.Y_AXIS));
					
					// Create success message
					JLabel successLabel = new JLabel("Object successfully written into file.");
					submitedPanel.add(successLabel);
					
					// JFrame setup to load success message
					frame.remove(inputPanel);
					frame.setSize(300,100);
					frame.add(submitedPanel);
					frame.validate();
					
				} catch(IOException err) {
					System.out.println(err);
				}
			}
		});
		
		// JFrame setup
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
