package com.in28minutes.java.operators;

//1.D 2.C 3.B 4.C 5.E 6.C 7.E 8.B 9.D 10.A 11.D 12.D 13.B 14.A 15.C 16.B 17.D 18.C 19.E 20.D 21.D 22.A 23.A 24.C 25.B
class StringConcatenationExamples {
	public static void main(String[] args) {
		// RULE1 : Expressions are evaluated from left to right.
		// Except if there are parenthesis.
		// RULE2 : number + number = number
		// RULE3 : number + String = String
		System.out.println(5 + "Test" + 5); // 5Test5
		System.out.println(5 + 5 + "Test"); // 10Test
		System.out.println("5" + 5 + "Test"); // 55Test
		System.out.println("5" + "5" + "25"); // 5525
		System.out.println(5 + 5 + "25"); // 1025
		System.out.println("" + 5 + 5 + "25"); // 5525
		System.out.println(5 + (5 + "25")); // 5525
	}
}