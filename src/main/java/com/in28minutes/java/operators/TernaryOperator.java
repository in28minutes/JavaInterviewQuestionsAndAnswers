package com.in28minutes.java.operators;

//1.D 2.C 3.B 4.C 5.E 6.C 7.E 8.B 9.D 10.A 11.D 12.D 13.B 14.A 15.C 16.B 17.D 18.C 19.E 20.D 21.D 22.A 23.A 24.C 25.B
class TernaryOperator {
	public static void main(String[] args) {
		int age = 18;
		// syntax - booleanCondition?ResultIfTrue:ResultIfFalse;
		System.out.println(age >= 18 ? "Can Vote" : "Cannot Vote");// Can Vote

		age = 15;
		System.out.println(age >= 18 ? "Can Vote" : "Cannot Vote");// Cannot
																	// Vote
	}
}