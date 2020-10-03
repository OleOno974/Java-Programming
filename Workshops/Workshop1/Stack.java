// Name: Olena Onopriyenko
// Seneca Student ID:124605163 
// Seneca email: oonopriyenkko@myseneca.ca
// Date of completion: 2020-01-20
//
// I confirm that the content of this file is created by me,
//   with the exception of the parts provided to me by my professor.
//
// Workshop 1
// Stack.java

public class Stack {

	// Create an array to hold the stack
	private char[] stack;
	private int top;
	
	// Constructor
	public Stack(int size) {
		stack = new char[size];
		top = -1;
	}
	
	// Create a method that add data into stack
	public void push(char data) {
		stack[++top] = data;
	}

	// Create a method that remove data from stack
	public char pop() {
		return stack[top--];
	}
	
}