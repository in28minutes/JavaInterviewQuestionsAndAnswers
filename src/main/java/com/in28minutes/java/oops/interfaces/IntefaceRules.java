package com.in28minutes.java.oops.interfaces;

public class IntefaceRules {
}

interface ExampleInterface1 {
	// By default - public static final. No other modifier allowed
	// value1,value2,value3,value4 all are - public static final
	int value1 = 10;
	public int value2 = 15;
	public static int value3 = 20;
	public static final int value4 = 25;

	// private int value5 = 10;//COMPILER ERROR

	// By default - public abstract. No other modifier allowed
	void method1();// method1 is public and abstract
	// private void method6();//COMPILER ERROR!

	//Interface can have a default definition of method.
	//NEW FEATURE
	default void method5() {
		System.out.println("Method5");
	}
}

interface ExampleInterface2 {
	void method2();
}

// An interface can extend another interface
// Class implementing SubInterface1 should
// implement method3 and method1(from ExampleInterface1)
interface SubInterface1 extends ExampleInterface1 {
	void method3();
}

/*
 * //COMPILE ERROR IF UnCommented //Interface cannot extend a Class interface
 * SubInterface2 extends InterfaceRules{ void method3(); }
 */

/* A Class can implement multiple interfaces */
class SampleImpl implements ExampleInterface1, ExampleInterface2 {
	/*
	 * A class should implement all the methods in an interface. If either of
	 * method1 or method2 is commented, it would result in compilation error.
	 */
	public void method2() {
		System.out.println("Sample Implementation for Method2");
	}

	public void method1() {
		System.out.println("Sample Implementation for Method1");
	}

}