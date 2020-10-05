package object.serialization;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/** A swing based class that deserializes and reads students objects from a file */
public class VisualDeserialize extends Student {

	// Main
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		// Create and setup JFrame
		JFrame frame = new JFrame("Deserializing object from file");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		
		// Create a JPanel that holds starting options and button
		JPanel startPanel = new JPanel();
		startPanel.setLayout(new BoxLayout(startPanel, BoxLayout.X_AXIS));
		frame.add(startPanel);
		
		// Create label and textfield for file name
		JLabel fileName = new JLabel("File name:");
		JTextField fileNameInput = new JTextField(15);
		startPanel.add(fileName);
		startPanel.add(fileNameInput);
		
		// Creates a button and add to start panel
		JButton startButton = new JButton("START");
		startPanel.add(startButton);
		
		// Add Action Listener to the button
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	        	
				// Read object from file
				File f = new File(fileNameInput.getText());
				
				try {
					
					FileInputStream fis = new FileInputStream(f);
					ObjectInputStream ois = new ObjectInputStream(fis);
					
					// Create object from file
					Student newStudent = (Student) ois.readObject();
					
					// Close file reader
					ois.close();
					
					// Create a JPanel that holds the results
					JPanel resultPanel = new JPanel();
					resultPanel.setLayout(new BoxLayout(resultPanel, BoxLayout.Y_AXIS));
					
					// Set border for the panel
					resultPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Deserialized Object"));
					
					// Set values to labels and append to result panel
					JLabel stdIDLabel = new JLabel("Student ID: " + newStudent.getStdID());
					resultPanel.add(stdIDLabel);
					
					JLabel firstNameLabel = new JLabel("Student First Name: " + newStudent.getFirstName());
					resultPanel.add(firstNameLabel);
					
					JLabel lastNameLabel = new JLabel("Student Last Name: " + newStudent.getLastName());
					resultPanel.add(lastNameLabel);
					
					JLabel coursesLabel = new JLabel("Courses: " + newStudent.getCourses());
					resultPanel.add(coursesLabel);
		        	
		        	// JFrame setup to load results
		        	frame.remove(startPanel);
		    		frame.setSize(500, 300);
		        	frame.add(resultPanel);
		        	frame.validate();
				
				} catch (IOException | ClassNotFoundException err) {
					// Create a JPanel that holds the error
					JPanel errorPanel = new JPanel();
					errorPanel.setLayout(new BoxLayout(errorPanel, BoxLayout.Y_AXIS));
					
					// Set border for the error panel
					errorPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Deserialized Object"));
					
					// Set values to labels and append to error panel
					JLabel error = new JLabel(err.getMessage());
					errorPanel.add(error);
					
					// JFrame setup to load error
		        	frame.remove(startPanel);
		    		frame.setSize(500, 300);
		        	frame.add(errorPanel);
		        	frame.validate();
				}
				
	        }
	    });
		
		// JFrame setup
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}
}