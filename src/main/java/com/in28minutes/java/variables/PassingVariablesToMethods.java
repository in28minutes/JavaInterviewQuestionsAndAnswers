package com.in28minutes.java.variables;

public class PassingVariablesToMethods {
	public static void main(String[] args) {
		PassingVariablesToMethods ref = new PassingVariablesToMethods();

		int n = 50;
		ref.incrementBy2(n);
		System.out.println("Passing primitive " + n);// Passing primitive 50

		Cricketer cric = new Cricketer();
		cric.runs = 50;
		ref.modifyCricketer(cric);
		System.out.println("Passing reference variable " + cric.runs);// Passing
																		// reference
																		// variable
																		// 150
	}

	void incrementBy2(int number) {
		number = number + 2;
	}

	void modifyCricketer(Cricketer cricketer) {
		cricketer.runs += 100;
	}
}

class Cricketer {
	String name;
	int runs;
}