package com.in28minutes.java.variables.scope;

public class VariablesExample {
	// RULE 1:Static Variable can be used anywhere in the class.
	static int staticVariable;

	// RULE 2:Member Variable can be used in any non-static method.
	int memberVariable;

	void method1() {
		// RULE 3: method1LocalVariable can be used only in method1.
		int method1LocalVariable;

		memberVariable = 5;// RULE 2
		staticVariable = 5;// RULE 1

		// Some Code
		{
			// RULE 4:blockVariable can be used only in this block.
			int blockVariable;
			// Some Code
		}

		// blockVariable = 5;//COMPILER ERROR - RULE 4
	}

	void method2() {
		// method1LocalVariable = 5; //COMPILER ERROR - RULE3
	}

	static void staticMethod() {
		staticVariable = 5;// RULE 1
		// memberVariable = 5; //COMPILER ERROR - RULE 2
	}
}