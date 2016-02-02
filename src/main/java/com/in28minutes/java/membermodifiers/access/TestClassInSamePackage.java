package com.in28minutes.java.membermodifiers.access;

public class TestClassInSamePackage {
	public static void main(String[] args) {
		ExampleClass example = new ExampleClass();

		example.publicVariable = 5;
		example.publicMethod();

		// privateVariable is not visible
		// Below Line, uncommented, would give compiler error
		// example.privateVariable=5; //COMPILE ERROR
		// example.privateMethod();

		example.protectedVariable = 5;
		example.protectedMethod();

		example.defaultVariable = 5;
		example.defaultMethod();
	}
}