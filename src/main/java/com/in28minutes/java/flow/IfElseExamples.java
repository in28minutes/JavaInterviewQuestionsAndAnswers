package com.in28minutes.java.flow;

public class IfElseExamples {
	public static void main(String[] args) {

		// Code inside If is executed only if the condition is true
		if (true) {
			System.out.println("Will be printed");
		}

		// Statement inside this condition is not executed
		if (false) {
			System.out.println("Will NOT be printed");// Not executed
		}

		// Lets look at an example
		int x = 5;

		if (x == 5) {
			System.out.println("x is 5");// executed since x==5 is true
		}

		x = 6;
		if (x == 5) {
			System.out.println("x is 5");// Not executed since x==5 is false
		}

		// If Else
		// If condition is true code in if is executed, else code in else is
		// executed

		int y = 10;

		if (y == 10) {
			System.out.println("Y is 10");// executed-condn y==10 is true
		} else {
			System.out.println("Y is Not 10");
		}

		y = 11;

		if (y == 10) {
			System.out.println("Y is 10");// NOT executed
		} else {
			System.out.println("Y is Not 10");// executed-condn y==10 is false
		}

		// Nested else if
		// The code in the first if condition that is true is executed.
		// If none of the if conditions are true, then code in else is executed.
		int z = 15;
		if (z == 10) {
			System.out.println("Z is 10");// NOT executed
		} else if (z == 12) {
			System.out.println("Z is 12");// NOT executed
		} else if (z == 15) {
			System.out.println("Z is 15");// executed. Rest of the if else are
											// skipped.
		} else {
			System.out.println("Z is Something Else.");// NOT executed
		}

		z = 18;
		if (z == 10) {
			System.out.println("Z is 10");// NOT executed
		} else if (z == 12) {
			System.out.println("Z is 12");// NOT executed
		} else if (z == 15) {
			System.out.println("Z is 15");// NOT executed
		} else {
			System.out.println("Z is Something Else.");// executed
		}

		// Be very careful with formatting
		int number = 5;
		if (number < 0) // condn is false. So the line in if is not executed.
			number = number + 10; // Not executed
		number++; // This statement is not part of if
		System.out.println(number);// prints 6

		// Guess the output
		int k = 15;
		if (k > 20) {
			System.out.println(1);
		} else if (k > 10) {
			System.out.println(2);
		} else if (k < 20) {
			System.out.println(3);
		} else {
			System.out.println(4);
		}
		// Output is 2. Once a condition in nested-if-else is true the rest of
		// the code is not executed.

		// Guess the output
		int l = 15;

		if (l < 20)
			System.out.println("l<20");
		if (l > 20)
			System.out.println("l>20");
		else
			System.out.println("Who am I?");
		// Output is "l<20" followed by "Who am I?" on next line.
		// else belong to the last if before it unless brackets ({}) are used.

		// Guess the output
		int m = 15;

		if (m > 20)
			if (m < 20)
				System.out.println("m>20");
			else
				System.out.println("Who am I?");
		// Nothing is printed to output. Above code is similar to code below
		if (m > 20) {// Condn is false. So, code in if is not executed
			if (m < 20)
				System.out.println("m>20");
			else
				System.out.println("Who am I?");
		}

		int x1 = 0;
		// Condition in if should always be boolean
		// if(x1) {} //COMPILER ERROR
		// if(x1=0) {}//COMPILER ERROR. Using = instead of ==

		boolean isTrue = false;
		if (isTrue == true) {
			System.out.println("TRUE TRUE");// Will not be printed
		}
		if (isTrue = true) {
			System.out.println("TRUE");// Will be printed.
		}
		// Condition is isTrue=true. This is assignment. Returns true. So, code
		// in if is executed.
	}
}
