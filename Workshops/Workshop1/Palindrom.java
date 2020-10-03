// Name: Olena Onopriyenko
// Seneca Student ID:124605163 
// Seneca email: oonopriyenkko@myseneca.ca
// Date of completion: 2020-01-20
//
// I confirm that the content of this file is created by me,
//   with the exception of the parts provided to me by my professor.
//
// Workshop 1
// Palindrome.java

public class Palindrome {
	
	// Check if the stack is palindrome
	private static boolean isPalindrome(String input) {

		// Create a Stack to hold the input
		Stack stack = new Stack(input.length());
			
		// For loop to populate the stack
		for (int i = 0; i < input.length(); i++) {
			stack.push(input.charAt(i));
		}
			
		// Compare input with pop, this way we don't need to reverse the array
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) != stack.pop()) {
				return false;
			}
		}
		return true;
	}
	
	// Create main
	public static void main(String[] args) {
		
		// Create a string from argument
		String input = args[0];
		
		if (isPalindrome(input)) {
			System.out.println("The string " + input + " is a palindrome.");
		} else {
			System.out.println("The string " + input + " is NOT a palindrome.");
		}
	}
}
