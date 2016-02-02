package com.in28minutes.java.classmodifiers.nonaccess.abstractclass;

public abstract class AbstractClassExample {

	// Abstract class can contain instance and static variables
	public int publicVariable;
	private int privateVariable;
	static int staticVariable;

	// Abstract Class can contain 0 or more abstract methods
	// Abstract method does not have a body
	abstract void abstractMethod1();

	abstract void abstractMethod2();

	// Abstract Class can contain 0 or more non-abstract methods
	public void nonAbstractMethod() {
		System.out.println("Non Abstract Method");
	}

	public static void main(String[] args) {
		// An abstract class cannot be instantiated
		// Below line gives compilation error if uncommented
		// AbstractClassExample ex = new AbstractClassExample();
	}
}

// A non-abstract sub class of an abstract class should
// implement all the abstract methods
// Below class gives compilation error if uncommented
/*
 * class SubClass extends AbstractClassExample {
 * 
 * }
 */

// This class implements both abstractMethod1 and abstractMethod2
class SubClass2 extends AbstractClassExample {
	void abstractMethod1() {
		System.out.println("Abstract Method1");
	}

	void abstractMethod2() {
		System.out.println("Abstract Method2");
	}
}

// We can create a subclass of an abstract class which is abstract
// It doesn't need to implement all the abstract methods
abstract class AbstractSubClass extends AbstractClassExample {
	void abstractMethod1() {
		System.out.println("Abstract Method1");
	}
	// abstractMethod2 is not defined at all.
}
