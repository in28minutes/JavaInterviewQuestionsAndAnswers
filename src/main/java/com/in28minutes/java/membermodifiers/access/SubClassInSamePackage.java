package com.in28minutes.java.membermodifiers.access;

public class SubClassInSamePackage extends ExampleClass {

	void subClassMethod() {
		publicVariable = 5;
		publicMethod();

		// privateVariable is not visible to SubClass
		// Below Line, uncommented, would give compiler error
		// privateVariable=5; //COMPILE ERROR
		// privateMethod();

		protectedVariable = 5;
		protectedMethod();

		defaultVariable = 5;
		defaultMethod();
	}
}