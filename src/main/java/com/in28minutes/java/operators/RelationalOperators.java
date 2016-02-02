package com.in28minutes.java.operators;

public class RelationalOperators {
	public static void main(String[] args) {
		int number = 7;
		// Always return true or false
		// <, <=, >, >=, ==, and !=

		// greater than operator
		System.out.println(number > 5);// true
		System.out.println(number > 7);// false

		// greater than equal to operator
		System.out.println(number >= 7);// true

		// less than operator
		System.out.println(number < 9);// true
		System.out.println(number < 7);// false

		// less than equal to operator
		System.out.println(number <= 7);// true

		// is equal to operator
		System.out.println(number == 7);// true
		System.out.println(number == 9);// false

		// NOT equal to operator
		System.out.println(number != 9);// true
		System.out.println(number != 7);// false

		// NOTE : single = is assignment operator
		// == is comparison. Below statement uses =.
		System.out.println(number = 7);// 7

		// Equality for Primitives only compares values
		int a = 5;
		int b = 5;

		// compares if they have same value
		System.out.println(a == b);// true

		// Equality for Reference Variables.
		Integer aReference = new Integer(5);
		Integer bReference = new Integer(5);

		// compares if they are refering to the same object
		System.out.println(aReference == bReference);// false

		bReference = aReference;
		// Now both are referring to same object
		System.out.println(aReference == bReference);// true
	}
}