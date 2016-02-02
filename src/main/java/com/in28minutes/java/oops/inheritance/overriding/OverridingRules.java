package com.in28minutes.java.oops.inheritance.overriding;

import java.io.FileNotFoundException;

public class OverridingRules {
}

class SuperClass {
	public void publicMethod() throws FileNotFoundException {

	}

	void protectedMethod() {

	}
}

class SubClass {
	// Cannot reduce visibility of SuperClass Method
	// So, only option is public
	// Cannot throw bigger exceptions than Super Class
	public void publicMethod() /* throws IOException */{

	}

	// Can be overridden with public,(default) or protected
	// private would give COMPILE ERROR!
	public void protectedMethod() {

	}

}