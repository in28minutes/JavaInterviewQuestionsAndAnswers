package com.in28minutes.java.flow;

public class ForLoopExample {
	public static void main(String[] args) {
		// Example of a For Loop
		for (int i = 0; i < 10; i++) {
			System.out.print(i);
		}
		// Output is 0123456789

		// For loop statement has 3 parts
		// Initialization => int i=0
		// Condition => i<10
		// Operation (Increment or Decrement usually) => i++

		// There can be multiple statements in Initialization
		// or Operation seperated by commas
		for (int i = 0, j = 0; i < 10; i++, j--) {
			System.out.print(j);
		}
		// Output is 0-1-2-3-4-5-6-7-8-9

		// Enhanced For Loop
		int[] numbers = { 1, 2, 3, 4, 5 };

		for (int number : numbers) {
			System.out.print(number);
		}
		// Output is 12345

		// Any of 3 parts in a for can be empty
		for (;;) {
			System.out.print("I will be looping for ever..");
		}
		// Result : Infinite loop

	}
}
